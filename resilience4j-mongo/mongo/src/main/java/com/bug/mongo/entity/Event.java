package com.bug.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
public class Event {

    @Id
    private String id;
    private Date date;
    private String message;

    public Event(String id, Date date, String message) {
        this.id = id;
        this.date = date;
        this.message = message;
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

    public static Event createFrom(EventDto eventDto) {
        String id = eventDto.getId();
        if(id == null || !id.isEmpty()) {
            id = UUID.randomUUID().toString();
        }
        return new Event(id, eventDto.getDate(), eventDto.getMessage());
    }

    public EventDto toDto() {
        return new EventDto(this.getId(), this.date, this.message);
    }
}
