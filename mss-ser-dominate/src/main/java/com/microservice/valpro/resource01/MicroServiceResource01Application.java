package com.microservice.valpro.resource01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*@CrossOrigin(origins = {"http://localhost:8888", "null"})*/
@SpringBootApplication(exclude={JacksonAutoConfiguration.class})
@EnableDiscoveryClient
public class MicroServiceResource01Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceResource01Application.class, args);
    }
}


