package com.microservice.valpro.oauth;

import com.microservice.valpro.common.filter.UriInteceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.servlet.config.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableRedisHttpSession
public class MicroServiceOauthApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceOauthApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/oauth/confirm_access").setViewName("authorize");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

   /* public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UriInteceptor()).addPathPatterns("/**");
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")	// 允许跨域访问的路径
                .allowedOrigins("*")	// 允许跨域访问的源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")	// 允许请求方法
                .maxAge(168000)	// 预检间隔时间
                .allowedHeaders("*")  // 允许头部设置
                .allowCredentials(true);	// 是否发送cookie
    }*/
}

