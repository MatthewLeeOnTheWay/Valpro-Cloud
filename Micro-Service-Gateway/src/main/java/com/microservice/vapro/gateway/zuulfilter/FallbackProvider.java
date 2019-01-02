package com.microservice.vapro.gateway.zuulfilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.valpro.common.entity.ErrorCode;
import com.microservice.valpro.common.entity.Msg;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-01-02 00:49
 **/
@Service
public class FallbackProvider implements org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider {
    @Override
    public String getRoute() {
        //“*”代表所有
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        cause.printStackTrace();
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                //响应体
                Msg msg = new Msg();
                msg.setCode(ErrorCode.MICRO_SERVICE_UNAVAILABLE);
                msg.setMsg("微服务不可用，请稍后再试");
                ObjectMapper objectMapper = new ObjectMapper();
                String content = objectMapper.writeValueAsString(msg);
                return new ByteArrayInputStream(content.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }
}
