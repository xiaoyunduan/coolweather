package com.example.xiaoyunduan.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by xiaoyunduan on 2017/9/7.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
