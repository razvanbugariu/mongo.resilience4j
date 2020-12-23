package bug.retry.demo.service;

import bug.retry.demo.config.CustomRetryException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallingClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String url = "http://localhost:8080/some1";

    public String getSome() throws CustomRetryException {
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            System.out.println("Retrying....");
            throw new CustomRetryException();
        }
    }
}
