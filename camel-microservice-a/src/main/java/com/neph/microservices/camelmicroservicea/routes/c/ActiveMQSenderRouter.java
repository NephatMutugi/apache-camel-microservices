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
    public void configure() throws Exception {
        // timer
        from("timer:active-mq-timer?period=10000")
                .transform().constant("My Message for Active MQ")
                .to("activemq:my-active-mq-queue");
    }
}
