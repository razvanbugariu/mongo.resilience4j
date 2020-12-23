package bug.resilience4j.destination;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ApiController {

    @GetMapping("/status/{statusCode}")
    public ResponseEntity<String> getResponseWithStatusCode(@PathVariable int statusCode) {
        System.out.println("Called with statusCode " + statusCode);
        if( statusCode == 200) {
            return ResponseEntity.status(200).body("Hello, this is 200 message");
        }
        return ResponseEntity.status(statusCode).build();
    }

    @GetMapping("/something")
    public ResponseEntity<String> getOkSomething() {
        Random random = new Random();
        return ResponseEntity.ok(String.valueOf(random.nextInt()));
    }

}
