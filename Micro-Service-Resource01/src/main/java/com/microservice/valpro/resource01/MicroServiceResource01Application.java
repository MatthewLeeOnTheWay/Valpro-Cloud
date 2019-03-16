package com.microservice.valpro.resource01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://localhost:8888", "null"})
@SpringBootApplication(exclude={JacksonAutoConfiguration.class})
@EnableDiscoveryClient
@EnableHystrix
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MicroServiceResource01Application {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceResource01Application.class, args);
    }

}

