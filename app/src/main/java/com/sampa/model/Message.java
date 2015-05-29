package com.sampa.model;

import java.util.Date;

/**
 * Created by cclamb on 5/29/15.
 */
public final class Message {

    private Date whenCreated;
    private String title;
    private String message;

    public Message(Date whenCreated, String title, String message) {

    }

    public Date getWhenCreated() {
        return whenCreated;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

}
