package com.neph.microservices.camelmicroservicea.routes.c;

import com.neph.microservices.camelmicroservicea.config.CamelMicroserviceConfigs;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @ Author Nephat Muchiri
 * Date 26/06/2023
 */
@Component
@RequiredArgsConstructor
public class ActiveMQSenderRouter extends RouteBuilder {

    private final CamelMicroserviceConfigs camelMicroserviceConfigs;


    @Override
    public void configure() {
        // timer
//        from("timer:active-mq-timer?period=10000")
//                .transform().constant("My Message for Active MQ")
//                .log("${body}")
//                .to("activemq:" + camelMicroserviceConfigs.getQueueName());

        from("file:files/json")
                .log("${body}")
                .to("activemq:" + camelMicroserviceConfigs.getQueueName());
    }
}
