package bug.retry.demo.service;

import bug.retry.demo.config.CustomRetryException;
import org.springframework.retry.annotation.Retryable;

public interface ICallingService {
//    @Retryable(value = CustomRetryException.class, maxAttempts = 8)
    String call() throws CustomRetryException;
}
