package com.microservice.valpro.resource01.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.microservice.valpro.common.dto.Result;
import com.microservice.valpro.common.util.HttpUtils;
import com.microservice.valpro.resource01.vo.ChartResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

/**
 * @description: Rest controller for manage system font end
 * @author: Mr.Lee
 * @create: 2019-02-22 13:15
 **/
@RestController
public class ManageController {
    @Resource
    private RestTemplate template;

    @RequestMapping("/test")
    public Mono<String> getLoginValidate() {
        return Mono.just("hdkajs");
    }


    @RequestMapping("/chart")
    public Mono<List> getChart() {
        String ipCheckUrl = "http://ip.taobao.com//service/getIpInfo.php";
        List<ChartResult> result = new ArrayList<>();
        String pathname = "D:\\document\\WeChat Files\\zjz05209486\\Files\\vwx.access.log";
        Map<String, ChartResult> map = new HashMap<>();

        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                // 一次读入一行数据

                int index = line.indexOf(" ");
                String matchResult = line.substring(0, index);

                if(map.containsKey(matchResult)){
                    ChartResult one=map.get(matchResult);
                    one.setValue(one.getValue()+1);
                    map.put(matchResult,one);
                }else {
                    map.put(matchResult,new ChartResult(1));
                }
            }

            int i=1;
            for(String matchResult:map.keySet()){
                String strbody;
                Map<String,String> amap=new HashMap<>();
                amap.put("ip",matchResult);

                strbody = HttpUtils.doGet(ipCheckUrl, amap);

                Result uniResult = new Result();
                if (strbody != null && !strbody.equals("")) {
                    uniResult = JSON.parseObject(strbody, new TypeReference<Result>() {
                    });
                    assert uniResult != null;
                    if (uniResult.getCode() == 200 || uniResult.getCode() == 0) {
                        String city = ((JSONObject) uniResult.getData()).get("city").toString();
                        if (city != null && !city.equals("")) {
                            ChartResult chartResult=map.get(matchResult);
                            chartResult.setName(city+"("+matchResult+")");
                            result.add(chartResult);
                        }
                    }
                } else {
                    System.out.println("the"+i+"time:"+"request fail"+System.currentTimeMillis());
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Mono.just(result);
    }
}