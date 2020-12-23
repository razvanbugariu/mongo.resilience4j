package bug.retry.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    private static final int TIMEOUT_MILLIES = 1000;
    private static final int MAX_ATTEMPTS = 7;
    private static final int BACKOFF_INTERVAL = 200;

    @Bean
    public RetryTemplate retryTemplate() {
        System.out.println("Configuring retry");
        RetryTemplate retryTemplate = new RetryTemplate();

        FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
        fixedBackOffPolicy.setBackOffPeriod(BACKOFF_INTERVAL);
        retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

        Map<Class<? extends Throwable>, Boolean> retryableExceptions = new HashMap<>();
        retryableExceptions.put(CustomRetryException.class, Boolean.TRUE);
        SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(MAX_ATTEMPTS, retryableExceptions);
        retryTemplate.setRetryPolicy(retryPolicy);

        return retryTemplate;
    }
}
