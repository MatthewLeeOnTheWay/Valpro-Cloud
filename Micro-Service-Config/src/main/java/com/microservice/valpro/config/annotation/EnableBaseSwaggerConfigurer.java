package com.microservice.valpro.config.annotation;

import com.microservice.valpro.config.swagger.SwaggerConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:需要在yml文件指定：base-package
 * @author: Mr.Lee
 * @create: 2019-01-02 16:51
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SwaggerConfig.class)
public @interface EnableBaseSwaggerConfigurer {
}
