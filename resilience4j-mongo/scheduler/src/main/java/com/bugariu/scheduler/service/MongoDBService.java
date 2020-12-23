package com.bugariu.scheduler.service;

import com.bugariu.scheduler.pojo.ChuckNorrisJoke;
import com.bugariu.scheduler.pojo.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class MongoDBService {

    private static final String MONGO_SERVICE_URL = "http://localhost:8080/event";

    private final RestTemplate restTemplate;

    @Autowired
    public MongoDBService() {
        this.restTemplate = new RestTemplate();
    }

    public void saveJoke(ChuckNorrisJoke joke) {
        EventDto eventDto = new EventDto(joke.getId(), new Date(), joke.getValue());
        restTemplate.postForEntity(MONGO_SERVICE_URL, eventDto, EventDto.class);
    }
}
