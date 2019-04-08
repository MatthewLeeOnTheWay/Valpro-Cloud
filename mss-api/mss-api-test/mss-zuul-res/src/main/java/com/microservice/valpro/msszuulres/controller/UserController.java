package com.microservice.valpro.msszuulres.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user/")
public class UserController {

	@RequestMapping("/test")
	public Mono<String> getString(){
		return Mono.just("Hello World");
	}

}
