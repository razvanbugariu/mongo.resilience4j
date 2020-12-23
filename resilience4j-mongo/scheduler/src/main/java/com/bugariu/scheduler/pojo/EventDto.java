package com.bugariu.scheduler.pojo;

import java.io.Serializable;
import java.util.Date;

public class EventDto implements Serializable {

    private String id;
    private Date date;
    private String message;

    public EventDto(Date date, String message) {
        this.date = date;
        this.message = message;
    }

    public EventDto(String id, Date date, String message) {
        this.id = id;
        this.date = date;
        this.message = message;
    }

    public EventDto() {
        //for serialization and objectMapper
    }

    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
