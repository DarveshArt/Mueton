package com.darveshart.app.friend;

/**
 * Created by zamee on 12/5/2017.
 */

class BaseMessage {
    public BaseMessage(){}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    User sender;

    long createdAt;

}