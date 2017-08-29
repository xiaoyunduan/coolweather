package com.example.xiaoyunduan.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by xiaoyunduan on 2017/8/28.
 */

public class City extends DataSupport {
    private int CityId;
    private String CityName;
    private int CityCode;
    private int ProvinceId;
    public int getCityId(){
        return CityId;
    }
    public void setCityId(int id){
        this.CityId=id;
    }
    public String getCityName(){
        return CityName;
    }
    public void setCityName(String name){
        this.CityName=name;
    }
    public int getCityCode(){
        return CityCode;
    }
    public void setProviceCode(int code){
        this.CityCode=code;
    }
    public int getProvinceId(){
        return ProvinceId;
    }
    public void setProvinceId(int Id){
        this.ProvinceId=Id;
    }
}
