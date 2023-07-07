package com.neph.microservices.camelmicroserviceb.routes;

import com.neph.microservices.camelmicroserviceb.configs.CamelMicroserviceConfigs;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * @ Author Nephat Muchiri
 * Date 07/07/2023
 */
@Component
@RequiredArgsConstructor
public class ActiveMQReceiverRouter extends RouteBuilder {

    private final CamelMicroserviceConfigs microserviceConfigs;
    @Override
    public void configure() throws Exception {
        from("activemq:" + microserviceConfigs.getQueueName());
    }
}
