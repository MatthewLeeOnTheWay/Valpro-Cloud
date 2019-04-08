package com.microservice.valpro.msszuulres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MssZuulResApplication {

    public static void main(String[] args) {
        SpringApplication.run(MssZuulResApplication.class, args);
    }

}
