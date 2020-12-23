package com.bugariu.scheduler.service;

import com.bugariu.scheduler.pojo.ChuckNorrisJoke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChuckNorrisService {

    private static final String CHUCK_NORRIS_JOKES_API = "https://api.chucknorris.io/jokes";

    private final RestTemplate restTemplate;

    @Autowired
    public ChuckNorrisService() {
        restTemplate = new RestTemplate();
    }

    public ChuckNorrisJoke retrieveRandomJoke() {
        String randomJokeUrl = CHUCK_NORRIS_JOKES_API + "/random";
        ResponseEntity<ChuckNorrisJoke> forEntity = restTemplate.getForEntity(randomJokeUrl, ChuckNorrisJoke.class);
        return forEntity.getBody();
    }
}
