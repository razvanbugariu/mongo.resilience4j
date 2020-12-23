package bug.resilience4j.demo.controller;

import bug.resilience4j.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping(value = "/{statusCode}")
    public String get(@PathVariable String statusCode) {
        return demoService.callDestination(statusCode).orElse("Empty response from controller");
    }

}
