package com.adk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/myContact")
    public String sayWelcome(){
        return "Here are the contact details from the DB";
    }

}
