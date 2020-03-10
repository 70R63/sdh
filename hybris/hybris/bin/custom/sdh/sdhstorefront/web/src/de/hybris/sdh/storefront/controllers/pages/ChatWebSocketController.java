package de.hybris.sdh.storefront.controllers.pages;

import de.hybris.sdh.core.pojos.chatws.Message;
import de.hybris.sdh.core.pojos.chatws.MessageDecoder;
import de.hybris.sdh.core.pojos.chatws.MessageEncoder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
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


@ServerEndpoint(value = "/chatEndPoint/{username}", decoders = MessageDecoder.class, encoders = MessageEncoder.class)
public class ChatWebSocketController {
    private Session session;
    private static final Set<ChatWebSocketController> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> activeUsers = new HashMap<>();
    private static final Logger LOG = Logger.getLogger(ChatWebSocketController.class);

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException {
        LOG.debug("New user has connected: [" + username + "]");
        this.session = session;
        chatEndpoints.add(this);
        activeUsers.put(session.getId(), username);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("Connected!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message) throws IOException, EncodeException {
        message.setFrom(activeUsers.get(session.getId()));
        broadcast(message);
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        LOG.debug("User [" + activeUsers.get(session.getId()) + "] has disconnected");
        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(activeUsers.get(session.getId()));
        message.setContent("Disconnected!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        LOG.debug("Error: " + throwable.toString());
    }

    private static void broadcast(Message message) throws IOException, EncodeException {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote()
                            .sendObject(message);
                } catch (IOException | EncodeException e) {
                    LOG.info("WS Warnign (Couldn't sent message to an actived user): " + e.toString());
                }
            }
        });
    }

}
