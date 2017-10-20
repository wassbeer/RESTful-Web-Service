package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping; //The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
import org.springframework.web.bind.annotation.RequestParam; // @RequestParam binds the value of the query string parameter name into the name parameter of the greeting() method. 
import org.springframework.web.bind.annotation.RestController;

/*

This code uses Spring 4’s new @RestController annotation, 
which marks the class as a controller where every method 
returns a domain object instead of a view. 
It’s shorthand for @Controller and @ResponseBody rolled together.

*/

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}