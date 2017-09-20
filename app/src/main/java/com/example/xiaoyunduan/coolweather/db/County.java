package com.example.xiaoyunduan.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by xiaoyunduan on 2017/8/28.
 */

public class County extends DataSupport {
    private int id;
    private int CityId;
    private String CountyName;
    private String weatherId;

    public int getCountyId(){
        return id;
    }
    public void setCityId(int id){
        this.CityId=id;
    }
    public int getCityId(){
        return CityId;
    }
    public String getCountyName(){
        return CountyName;
    }
    public void setCountyName(String name){
        this.CountyName=name;
    }
    public String getWeatherId(){
        return weatherId;
    }
    public void setWeatherId(String Id){
        this.weatherId=Id;
    }

}
