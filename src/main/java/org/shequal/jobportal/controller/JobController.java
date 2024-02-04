package org.shequal.jobportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JobController {

    // type url http://localhost:8080/api/hello on your browser or in PostMan

    @GetMapping("/hello")
    public String hello() {
        return "Hello World ";
    }
}
