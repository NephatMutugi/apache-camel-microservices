package com.neph.microservices.camelmicroservicea.routes;

import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @ Author Nephat Muchiri
 * Date 21/06/2023
 */
@Component
@RequiredArgsConstructor
public class MyFirstTimerRouter extends RouteBuilder {
    private final GetCurrentTimeBean getCurrentTimeBean;
    @Override
    public void configure() throws Exception {
        // Create all routes here

        // Starting point of routes
        from("timer:first-timer")
//                .transform().constant("Current Time "+ LocalDateTime.now())
                .bean(getCurrentTimeBean, "getCurrentTime")
                .to("log:first-timer");
    }
}

// Bean to generate custom message
@Component
class GetCurrentTimeBean{
    public String getCurrentTime(){
        return "Time now is " + LocalDateTime.now();
    }
}
