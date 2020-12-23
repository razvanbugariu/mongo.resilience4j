package com.bugariu.scheduler.scheduler;

import com.bugariu.scheduler.pojo.ChuckNorrisJoke;
import com.bugariu.scheduler.service.ChuckNorrisService;
import com.bugariu.scheduler.service.MongoDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class SchedulerConfig {

    private ChuckNorrisService chuckNorrisService;

    private MongoDBService mongoDBService;

    @Autowired
    public SchedulerConfig(ChuckNorrisService chuckNorrisService, MongoDBService mongoDBService) {
        this.chuckNorrisService = chuckNorrisService;
        this.mongoDBService = mongoDBService;
    }

    @Scheduled(fixedDelay = 10000)
    public void scheduleFixedDelay() {
        ChuckNorrisJoke joke = chuckNorrisService.retrieveRandomJoke();
        mongoDBService.saveJoke(joke);
    }
}
