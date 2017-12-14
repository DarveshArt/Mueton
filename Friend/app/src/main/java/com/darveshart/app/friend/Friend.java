package com.darveshart.app.friend;

import java.util.Random;

/**
 * Created by zamee on 12/5/2017.
 */

public class Friend {
    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
        think();
    }

    public String getMyMessage() {
        return myMessage;
    }

    public void setMyMessage(String myMessage) {
        this.myMessage = myMessage;
    }

    private String userMessage, myMessage;

    private String[] response = {"Hello, You can talk, I'm Listening","Keep Going","I won't talk, so that you can talk everything you have to talk"};

    public Friend(){}

    public void think(){
        Random random = new Random();
        int i = random.nextInt(3);
        setMyMessage(response[i]);
    }
}
