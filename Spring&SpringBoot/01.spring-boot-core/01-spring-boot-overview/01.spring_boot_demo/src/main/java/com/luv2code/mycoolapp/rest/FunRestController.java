package com.luv2code.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @PostMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}
