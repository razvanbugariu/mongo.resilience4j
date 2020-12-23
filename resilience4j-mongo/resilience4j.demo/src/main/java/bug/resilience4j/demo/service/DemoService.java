package bug.resilience4j.demo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DemoService {

    private static final String URL = "http://localhost:8081/";

    private final RestTemplate restTemplate;

    public DemoService() {
        restTemplate = new RestTemplate();
    }

    @Retry(name = "BACKEND", fallbackMethod = "fallbackR")
    @CircuitBreaker(name = "BACKEND", fallbackMethod = "fallbackC")
    public Optional<String> callDestination(String status) {
        System.out.println("Calling service...");
        String url = URL + "status/" + status;
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        if(entity.getStatusCode().value() != 200) {
            throw new HttpServerErrorException(entity.getStatusCode());
        }
        return Optional.ofNullable(entity.getBody());
    }

    public Optional<String> fallbackR(String status, RuntimeException e) {
        return Optional.of("Hello there, this is the fallback method for Retry.");
    }

    public Optional<String> fallbackC(String status, RuntimeException e) {
        return Optional.of("Hello there, this is the fallback method for CircuitBreaker.");
    }


}
