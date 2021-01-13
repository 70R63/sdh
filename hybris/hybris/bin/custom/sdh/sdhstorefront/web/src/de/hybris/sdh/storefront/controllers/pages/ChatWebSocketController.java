package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.sdh.core.pojos.chatws.Message;
import de.hybris.sdh.core.pojos.chatws.MessageDecoder;
import de.hybris.sdh.core.pojos.chatws.MessageEncoder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;


@ServerEndpoint(value = "/chatEndPoint/{userType}/{userId}/{username}/{comment}/{subjectType}", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class ChatWebSocketController {
    private Session session;
    private static final Set<ChatWebSocketController> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> activeUsers = new HashMap<>();

    //All Customer list that are waiting to be picked
    private static final HashMap<String, Message> activedCustomer = new HashMap<>();

    //All Customer Session
    private static final HashMap<String, Session> activedCustomerSession = new HashMap<>();

    //List of all agent that are connected
    private static Set<Session> activedAgents = new CopyOnWriteArraySet<>();

    //List of all agent that has opened a new chat conversation
    private static Set<Session> activeAgentConversation = new CopyOnWriteArraySet<>();

    private static final Logger LOG = Logger.getLogger(ChatWebSocketController.class);
    private final static  String AGENT_SESSION_USER_TYPE = "AGENTSESSION";
    private final static  String CUSTOMER_USER_TYPE = "CUSTOMER";
    private final static  String AGENT_USER_TYPE = "AGENT";
    private final static  String BOT_USER_TYPE = "BOT";
    private final static  String BOT_USER_ID = "SDH_BOT";
    private final static  String BOT_USER_NAME= "SDH Bot";
    private final static  String CONTENT_TYPE_MESSAGE = "MSG";
    private final static  String CONTENT_TYPE_LIST = "LIST";
    private final static  String CONTENT_TYPE_NEW_CUSTM = "NEWCUSTM";
    private final static  String CONTENT_TYPE_DEL_CUSTM = "DELCUSTM";
    private final static  String CONTENT_TYPE_BLK_CUSTM = "BKLCUSTM";
    private final static  String CONTENT_TYPE_UNBLK_CUSTM = "UNBKLCUSTM";


    private final static  String INITIAL_SESSION_MESSAGE = "En un momento unos de nuestros agentes tomara su session...";

    @OnOpen
    public void onOpen(final Session session,
                @PathParam("userType") final String userType,
                @PathParam("userId") final String userId,
                @PathParam("username") final String username,
                @PathParam("comment") final String comment,
                @PathParam("subjectType") final String subjectType) throws IOException, EncodeException {

        final Message message = new Message();
        message.setFrom(userId);
        message.setUserType(userType);
        message.setUserName(username);
        message.setContent(comment);
        message.setSubjectType(subjectType);
        messageBroadCaster(message, session);
    }

    @OnMessage
    public void onMessage(final Session session, final Message message) throws IOException, EncodeException {
        if(message.getContentType().equals("AgentUserMessage")){
            message.setFrom(session.getId());
            activedCustomerSession.get(message.getTo()).getBasicRemote().sendObject(message);
            LOG.info("New message ["+message+"] sent by: AgentSession " + session);
        }else if(message.getContentType().equals("CustomerUserMessage") ||
                message.getContentType().equals("closeSession")){
            final Session chatSession = activeAgentConversation.stream().filter(agentChatSession ->
                    message.getTo().equals(agentChatSession.getId())).findAny().orElse(null);
			if (chatSession != null && chatSession.getBasicRemote() != null)
			{
            chatSession.getBasicRemote().sendObject(message);
			}
            LOG.info("New message ["+message+"] sent by: CustomerSession " + session);
        }else if(message.getContentType().equals("blockSession")){
            sendCustomerBlocked(message);
            LOG.info("New message ["+message+"] sent by: CustomerSession " + session + " to block a customer");
        }else if(message.getContentType().equals("unBlockCustomer")){
            sendCustomerUnBlocked(message);
            LOG.info("New message ["+message+"] sent by: CustomerSession " + session + " to unblock a customer");
        }
    }

    @OnClose
    public void onClose(final Session session) throws IOException, EncodeException {
        final Message removedCustomer = activedCustomer.remove(session.getId());
        final boolean removedAgent = activedAgents.remove(session);

        if(Objects.nonNull(removedCustomer)){
            sendCustomerDeleted(removedCustomer);
            activedCustomerSession.remove(session.getId());
            LOG.info("Customer id[" + session.getId() + "] has disconnected");
        }else if(removedAgent){
            activeAgentConversation.remove(session);
            LOG.info("Agent id[" + session.getId() + "] has disconnected");
        }
    }

    @OnError
    public void onError(final Session session, final Throwable throwable) {
        LOG.debug("Error: " + throwable.toString());
    }


    private static void messageBroadCaster(final Message message, final Session session) throws IOException, EncodeException {
        if(message.getUserType().equals(CUSTOMER_USER_TYPE)){ //Customer has connected
            activedCustomer.put(session.getId(),message);
            activedCustomerSession.put(session.getId(), session);
            sendNewCustomerToAllAgents(message, session);
            sendWelcomeMessageToCustomer(session);
            LOG.info("New Customer is connected: " + message);
        }else if(message.getUserType().equals(AGENT_USER_TYPE)){ //Agent has connected
            activedAgents.add(session);
            sendAllActivedCustomerList(session);
            LOG.info("New Agent is connected: " + message);
        }else if(message.getUserType().equals(AGENT_SESSION_USER_TYPE)){ //Agent has picked a conversation
            activeAgentConversation.add(session);
            LOG.info("An Agent has picked a new conversation: " + message);
        }
    }

    private static void sendWelcomeMessageToCustomer(final Session targetSession) throws IOException, EncodeException{
        final Message replyMessage = botMessage();
        replyMessage.setContent(INITIAL_SESSION_MESSAGE);
        replyMessage.setContentType(CONTENT_TYPE_MESSAGE);
        targetSession.getBasicRemote().sendObject(replyMessage);
    }

    private static void sendAllActivedCustomerList(final Session targetSession) throws IOException, EncodeException{
        final Message replyMessage = botMessage();
        replyMessage.setActivedCustomer(activedCustomer);
        replyMessage.setContentType(CONTENT_TYPE_LIST);
        targetSession.getBasicRemote().sendObject(replyMessage);
    }

    private static void sendCustomerBlocked(final Message message){
        final Message replyMessage = botMessage();
        replyMessage.setFrom(message.getFrom());
        replyMessage.setContentType(CONTENT_TYPE_BLK_CUSTM);
        sendMessageToAgents(replyMessage);
        activedCustomer.get(message.getUserSessionId()).setPicked(true);
    }

    private static void sendCustomerUnBlocked(final Message message){
        final Message replyMessage = botMessage();
        replyMessage.setFrom(message.getFrom());
        replyMessage.setContentType(CONTENT_TYPE_UNBLK_CUSTM);
        sendMessageToAgents(replyMessage);
        activedCustomer.get(message.getUserSessionId()).setPicked(false);
    }

    private static void sendCustomerDeleted(final Message message){
        message.setContentType(CONTENT_TYPE_DEL_CUSTM);
        sendMessageToAgents(message);
    }

    private static void sendNewCustomerToAllAgents(final Message message, final Session session){
        message.setContentType(CONTENT_TYPE_NEW_CUSTM);
        message.setUserSessionId(session.getId());
        sendMessageToAgents(message);
    }

    private static void sendMessageToAgents(final Message message){
        activedAgents.forEach(endpointSession -> {
            synchronized (endpointSession) {
                try {
                    endpointSession.getBasicRemote().sendObject(message);
                } catch (IOException | EncodeException e) {
                    LOG.info("WS Warnign (Couldn't sent message to an actived user): " + e.toString());
                }
            }
        });
    }

    private static Message botMessage(){
        final Message botMessage = new Message();
        botMessage.setFrom(BOT_USER_ID);
        botMessage.setUserType(BOT_USER_TYPE);
        botMessage.setUserName(BOT_USER_NAME);
        return botMessage;
    }


}
