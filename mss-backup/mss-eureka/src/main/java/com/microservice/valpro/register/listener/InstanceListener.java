package com.microservice.valpro.register.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 服务监听器：取消
 * @author: Mr.Lee
 * @create: 2019-01-01 23:36
 **/
@Configuration
public class InstanceListener implements ApplicationListener<EurekaInstanceCanceledEvent> {
    private static Logger logger = LoggerFactory.getLogger(InstanceListener.class);

    @Override
    public void onApplicationEvent(EurekaInstanceCanceledEvent event) {
        logger.info("该服务>>>"+event.getAppName()+">>>被取消了！");
    }
}
