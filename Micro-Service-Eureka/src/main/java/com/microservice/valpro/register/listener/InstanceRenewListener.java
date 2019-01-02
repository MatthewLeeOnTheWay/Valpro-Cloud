package com.microservice.valpro.register.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 服务重新注册监听器
 * @author: Mr.Lee
 * @create: 2019-01-01 23:59
 **/
@Configuration
public class InstanceRenewListener implements ApplicationListener<EurekaInstanceRenewedEvent> {
    private static Logger logger = LoggerFactory.getLogger(InstanceRenewListener.class);

    @Override
    public void onApplicationEvent(EurekaInstanceRenewedEvent event) {
        logger.info("该服务>>>"+event.getAppName()+">>>被重新注册！");
    }
}
