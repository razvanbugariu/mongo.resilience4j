package com.bug.mongo.controller;

import com.bug.mongo.entity.Event;
import com.bug.mongo.entity.EventDto;
import com.bug.mongo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping(value = "/event")
    public ResponseEntity<EventDto> saveEvent(@RequestBody EventDto eventDto) {
        Event event = Event.createFrom(eventDto);
        eventService.saveEvent(event);
        return ResponseEntity.ok(event.toDto());
    }

    @GetMapping(value = "/event")
    public ResponseEntity<List<EventDto>> getAll() {
        List<Event> all = eventService.getAll();
        List<EventDto> allDto = all.stream().map(Event::toDto).collect(Collectors.toList());
        return ResponseEntity.ok(allDto);
    }

}
