package com.microservice.valpro.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @description:
 * @author: Mr.Lee
 * @create: 2019-03-06 00:47
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IpResponse {
    private String ip;
    private String country;;
    private String area;
    private String region;
    private String city;
    private String county;
    private String isp;
    private int country_id;
    private int area_id;
    private int region_id;
    private int city_id;
    private int county_id;
    private int isp_id;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getCounty_id() {
        return county_id;
    }

    public void setCounty_id(int county_id) {
        this.county_id = county_id;
    }

    public int getIsp_id() {
        return isp_id;
    }

    public void setIsp_id(int isp_id) {
        this.isp_id = isp_id;
    }
}
