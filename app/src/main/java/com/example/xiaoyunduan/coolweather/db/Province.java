package com.example.xiaoyunduan.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by xiaoyunduan on 2017/8/28.
 */

public class Province extends DataSupport {
    private int ProviceId;
    private String ProviceName;
    private int ProviceCode;
    public int getId(){
        return ProviceId;
    }
    public void setId(int id){
        this.ProviceId=id;
    }
    public String getProviceName(){
        return ProviceName;
    }
    public void setProviceName(String name){
        this.ProviceName=name;
    }
    public int getProviceCode(){
        return ProviceCode;
    }
    public void setProviceCode(int code){
        this.ProviceCode=code;
    }
}
