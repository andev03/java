package com.luv2code.demo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define our init method

    @Override
    public String getDailyWorkout() {
        return "Practice fast working for 15 minutes";
    }
}
