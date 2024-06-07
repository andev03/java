package com.luv2code.demo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrachCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "TrackCoach";
    }
}
