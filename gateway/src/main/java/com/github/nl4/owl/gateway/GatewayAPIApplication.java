package com.github.nl4.owl.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(scanBasePackages = {"com.github.nl4.owl.gateway", "com.github.nl4.owl.common"})
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayAPIApplication.class, args);
    }

}