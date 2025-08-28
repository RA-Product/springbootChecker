package com.ra.Rasolutions;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages = {"com.ra.Rasolutions"})
public class Imagerest {

    @GetMapping("/Hello")
    public String Hello(){
        return "Hello spring boot";
    }
}
