package com.github.mlgsec.controllers;

import com.github.mlgsec.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final AtomicLong counter = new AtomicLong();

    // http://localhost:8080/greeting?name=Mateus
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "Hello Word")
            String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
