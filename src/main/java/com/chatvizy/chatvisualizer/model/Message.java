package com.chatvizy.chatvisualizer.model;

import lombok.Data;

@Data
public abstract class AbstractMessage {

    protected final String date;
    protected final String time;
    protected final String userName;
    protected final String text;

}
