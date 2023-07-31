package com.neph.microservices.camelmicroserviceb.routes;

import com.neph.microservices.camelmicroserviceb.configs.CamelMicroserviceConfigs;
import lombok.RequiredArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

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

        // JSON
        // Map : {  "id": 1000,  "from": "USD",  "to": "INR",  "conversionMultiple": 70}

        from("activemq:" + microserviceConfigs.getQueueName())
                .to("log:received-message-from-active-mq");
    }
}


class CurrencyExchange{
    Long id;
    String from;
    String to;
    BigDecimal conversionMultiple;

}
