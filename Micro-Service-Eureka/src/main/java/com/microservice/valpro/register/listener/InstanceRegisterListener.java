package com.microservice.valpro.register.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 服务注册监听器
 * @author: Mr.Lee
 * @create: 2019-01-01 23:53
 **/

@Configuration
public class InstanceRegisterListener implements ApplicationListener<EurekaInstanceRegisteredEvent> {
    private static Logger logger = LoggerFactory.getLogger(InstanceRegisterListener.class);
    @Override
    public void onApplicationEvent(EurekaInstanceRegisteredEvent event) {
        logger.info("该服务>>>"+event.getInstanceInfo().getAppName()+">>>被注册");
    }
}
