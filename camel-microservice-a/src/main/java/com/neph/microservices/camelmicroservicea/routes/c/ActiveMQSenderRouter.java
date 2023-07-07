package com.neph.microservices.camelmicroservicea.routes.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @ Author Nephat Muchiri
 * Date 26/06/2023
 */
@Component
public class ActiveMQSenderRouter extends RouteBuilder {
    @Override
    public void configure() {
        // timer
        from("timer:active-mq-timer?period=10000")
                .transform().constant("My Message for Active MQ")
                .log("${body}")
                .to("activemq:my-activemq-queue");
    }
}
