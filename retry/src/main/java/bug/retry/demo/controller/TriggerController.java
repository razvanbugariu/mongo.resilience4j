package bug.retry.demo.controller;

import bug.retry.demo.config.CustomRetryException;
import bug.retry.demo.service.CallingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriggerController {

    @Autowired
    public TriggerController(CallingService callingService) {
        this.callingService = callingService;
    }

    private CallingService callingService;

    @GetMapping(value = "/trigger")
    public String trigger() throws CustomRetryException {
        return callingService.call();
    }

}
