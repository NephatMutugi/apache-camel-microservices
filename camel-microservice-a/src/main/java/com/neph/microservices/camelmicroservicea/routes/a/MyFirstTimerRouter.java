package com.neph.microservices.camelmicroservicea.routes.a;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final SimpleLoggingProcessingComponent loggingComponent;
    @Override
    public void configure() throws Exception {
        // Create all routes here

        // Starting point of routes
        from("timer:first-timer")
                .log("${body}")
//                .transform().constant("Current Time "+ LocalDateTime.now())
                .bean(getCurrentTimeBean, "getCurrentTime")
                .log("${body}")
                .bean(loggingComponent)
                .process(new SimpleLoggingProcessor())
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

@Component
class SimpleLoggingProcessingComponent{
    private final Logger logger = LoggerFactory.getLogger(SimpleLoggingProcessingComponent.class);
    public void process(String message){
        logger.info("SimpleLoggingProcessingComponent {}", message);
    }
}

@Slf4j
class SimpleLoggingProcessor implements Processor{

    @Override
    public void process(Exchange exchange) throws Exception {
        log.info("SimpleLoggingProcessor: {}", exchange.getMessage().getBody());
    }
}