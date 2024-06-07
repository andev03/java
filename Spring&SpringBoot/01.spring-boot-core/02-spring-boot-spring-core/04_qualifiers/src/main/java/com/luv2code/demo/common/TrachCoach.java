package com.luv2code.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TrachCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "TrackCoach";
    }
}
