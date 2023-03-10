package com.example.greetingapp.controller;
import com.example.greetingapp.model.User;
import com.example.greetingapp.service.IGreetingService;
import com.example.greetingapp.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    @Autowired
    private static final String template = "Hello, %s";
    private IGreetingService greetingService;
    private final AtomicLong counter= new AtomicLong();
    public GreetingController(IGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/")
    public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

   /* @GetMapping("/greeting")
    public String greeting(){
        return greetingService.getGreetingMessage();
    } */

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "firstName", defaultValue = "Hello") String firstName,
                           @RequestParam(name = "lastName", defaultValue = "World") String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.getGreetingMessage(user);
    }

    @PostMapping("/greeting")
    public Greeting addGreeting(@RequestParam(name = "firstName", defaultValue = "Hello") String firstName,
                                @RequestParam(name = "lastName", defaultValue = "World") String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreetingMessage(user);
    }

    @GetMapping("/greeting/{id}")
    public Greeting getGreetingMsgById(@PathVariable("id") long id){
        return greetingService.getGreetingMsgById(id);
    }

    @GetMapping("/greetings")
    public List<Greeting> getAllGreetingMsg(){
        return greetingService.getAllGreetingMsg();
    }

    @PutMapping("/update/{id}")
    public Greeting updateGreetingMsg(@PathVariable("id") long id, @RequestBody User user){
        return greetingService.updateGreetingMsg(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public Greeting deleteGreeting(@PathVariable("id") long id){
        return greetingService.deleteGreetingMsg(id);
    }

}