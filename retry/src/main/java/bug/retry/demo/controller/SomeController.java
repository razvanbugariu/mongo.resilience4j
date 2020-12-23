package bug.retry.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @GetMapping(value = "some")
    public String getSome() {
        return "some";
    }
}
