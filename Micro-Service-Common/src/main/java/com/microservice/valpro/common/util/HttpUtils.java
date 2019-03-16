package com.microservice.valpro.common.util;

import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-03-06 17:06
 **/
public class HttpUtils {
    public static String doGet(String url, Map<String, String> param) throws IOException{
        DefaultHttpClient httpclient=new DefaultHttpClient();
        HttpGet request= new HttpGet(url);
        HttpResponse response=null;// httpclient.execute(request);
        // 创建Httpclient对象

        String resultString = "";

        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36");
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
            }else{
                System.out.println(response.getStatusLine().getStatusCode()+":"+response.getStatusLine().getReasonPhrase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            /*try {
                *//*if (response != null) {
                    response.close();
                    ((CloseableHttpResponse) response).close();
                }*//*
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        return resultString;
    }

    public static String doGet(String url) throws IOException{
        return doGet(url, null);
    }

    public static String doGetJson(String url,Map<String, String> param){
        return "";
    }

    public static String doPost(String url, Map<String, String> param) throws IOException {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建参数列表
            if (param != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (String key : param.keySet()) {
                    paramList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
                httpPost.setEntity(entity);
            }
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            response.close();
        }

        return resultString;
    }

    public static String doPost(String url) throws IOException {
        return doPost(url, null);
    }

    public static String doPostJson(String url, String json) {
        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return resultString;
    }

//    public static  void main(String[] args) throws IOException {
//        DefaultHttpClient httpclient=new DefaultHttpClient();
//        String url="https://www.yiibai.com/hadoop/hadoop_mapreduce.html";
//        String uri="http://ip.taobao.com/service/getIpInfo.php?ip=140.205.205.25";
//        HttpGet request= new HttpGet(uri);
//        request.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36");
//        HttpResponse response= httpclient.execute(request);
//        if (response.getStatusLine().getStatusCode() == 200) {
//            String resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
//            System.out.println(resultString);
//        }
//
//    }
}
