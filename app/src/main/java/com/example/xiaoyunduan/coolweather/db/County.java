package com.example.xiaoyunduan.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by xiaoyunduan on 2017/8/28.
 */

public class County extends DataSupport {
    private int CountyId;
    private int CityId;
    private String CountryName;
    private String weatherId;

    public int getCountryId(){
        return CountyId;
    }
    public void setCityId(int id){
        this.CityId=id;
    }
    public int getCityId(){
        return CityId;
    }
    public String getCountryName(){
        return CountryName;
    }
    public void setCountryName(String name){
        this.CountryName=name;
    }
    public String getWeatherId(){
        return weatherId;
    }
    public void setWeatherId(String Id){
        this.weatherId=Id;
    }

}
