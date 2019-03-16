package com.microservice.vapro.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//服务监控治理
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableZuulProxy
//@EnableOAuth2Sso
public class MicroServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceZuulApplication.class, args);
    }

}

