package com.neph.microservices.camelmicroserviceb.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ Author Nephat Muchiri
 * Date 07/07/2023
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("activemq")
public class CamelMicroserviceConfigs {
    private String queueName;
}
