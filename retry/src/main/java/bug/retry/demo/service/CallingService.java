package bug.retry.demo.service;

import bug.retry.demo.config.CustomRetryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class CallingService implements ICallingService {

    private final RetryTemplate retryTemplate;
    private final CallingClient callingClient;

    @Autowired
    public CallingService(RetryTemplate retryTemplate, CallingClient callingClient) {
        this.retryTemplate = retryTemplate;
        this.callingClient = callingClient;
    }

    public String call() throws CustomRetryException {
        return retryTemplate.execute(retryContext -> {
            System.out.println(retryContext);
            return callingClient.getSome();});
    }

}
