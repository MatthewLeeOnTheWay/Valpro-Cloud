package com.microservice.valpro.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroServiceEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceEurekaApplication.class, args);
    }

}

