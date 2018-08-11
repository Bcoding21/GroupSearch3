package com.groupme.search;

import org.json.JSONObject;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("messages")
public class Message {

    @Id
    private String messageId;
    private String userId;
    private String groupId;
    private String userName;
    private String text;
    private long timeStamp;

    public Message(){

    }

    public Message(JSONObject jsonObject){
        messageId = jsonObject.getString("id");
        userId = jsonObject.getString("user_id");
        groupId = jsonObject.getString("group_id");
        userName = jsonObject.getString("name");
        text = jsonObject.getString("text");
        timeStamp = jsonObject.getLong("created_at");
    }

    public static boolean hasText(JSONObject jsonObject){
        Object text = jsonObject.get("text");
        return text != null && text instanceof String;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
