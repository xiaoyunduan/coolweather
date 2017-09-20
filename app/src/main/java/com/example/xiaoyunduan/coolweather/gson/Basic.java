package com.example.xiaoyunduan.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xiaoyunduan on 2017/9/7.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }

}
