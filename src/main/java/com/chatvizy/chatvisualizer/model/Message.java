package com.chatvizy.chatvisualizer.model;

/**
 * Holds parameters like data, time, userName and text.
 * */

public class Message {

    protected final String date;
    protected final String time;
    protected final String userName;
    protected final String text;

    public Message(String date, String time,
                   String userName, String text) {
        this.date = date;
        this.time = time;
        this.userName = userName;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getUserName() {
        return userName;
    }

    public String getText() {
        return text;
    }
}
