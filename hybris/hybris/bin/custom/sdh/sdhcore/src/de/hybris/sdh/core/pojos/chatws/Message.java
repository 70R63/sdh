package de.hybris.sdh.core.pojos.chatws;

import java.util.HashMap;

public class Message {
    private String from; //userId
    private String userType;
    private String userName;
    private String subjectType;
    private String to;
    private String content;
    private String contentType;
    private String userSessionId;
    private boolean isPicked;
    private HashMap<String, Message> activedCustomer;



    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserType() { return userType; }

    public void setUserType(String userType) { this.userType = userType; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getSubjectType() { return subjectType; }

    public void setSubjectType(String subjectType) { this.subjectType = subjectType; }

    public String getContentType() { return contentType; }

    public void setContentType(String contentType) { this.contentType = contentType; }

    public HashMap<String, Message> getActivedCustomer() { return activedCustomer; }

    public void setActivedCustomer(HashMap<String, Message> activedCustomer) { this.activedCustomer = activedCustomer; }

    public String getUserSessionId() {
        return userSessionId;
    }

    public void setUserSessionId(String userSessionId) {
        this.userSessionId = userSessionId;
    }

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }


    @Override
    public String toString() {
        return "Message{" +
                "from='" + from + '\'' +
                ", userType='" + userType + '\'' +
                ", userName='" + userName + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                ", contentType='" + contentType + '\'' +
                ", userSessionId='" + userSessionId + '\'' +
                ", activedCustomer=" + activedCustomer +
                '}';
    }
}
