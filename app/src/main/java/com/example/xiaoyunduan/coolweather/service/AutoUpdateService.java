package com.example.xiaoyunduan.coolweather.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.os.SystemClock;
import android.preference.PreferenceManager;

import com.example.xiaoyunduan.coolweather.WeatherActivity;
import com.example.xiaoyunduan.coolweather.gson.Weather;
import com.example.xiaoyunduan.coolweather.util.HttpUtil;
import com.example.xiaoyunduan.coolweather.util.Utillity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class AutoUpdateService extends Service {
    public AutoUpdateService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       updateWeather();
        updateBingPic();
        AlarmManager manager=(AlarmManager)getSystemService(ALARM_SERVICE);
        int anHour=8*60*60*1000;
        long triggerAtTime= SystemClock.elapsedRealtime()+anHour;
        Intent i=new Intent(this,AutoUpdateService.class);
        PendingIntent pi=PendingIntent.getService(this,0,i,0);
        manager.cancel(pi);
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime,pi);
        return super.onStartCommand(intent, flags, startId);
    }
    private void updateWeather(){
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String weatherString=prefs.getString("weather",null);
        if(weatherString!=null){
            Weather weather= Utillity.handWeatherResponse(weatherString);
            String weatherId=weather.basic.weatherId;
            String weatherUrl="http://guolin.tech/api/weather?cityid="+
                    weatherId+"&key=bba4e6f423ef477a9a15f2b45855c8ed";
            HttpUtil.sendOkHttpRequest(weatherUrl, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                       String responseText=response.body().string();
                    Weather weather=Utillity.handWeatherResponse(responseText);
                    if(weather!=null && "ok".equals(weather.status)){
                        SharedPreferences.Editor editor=PreferenceManager
                                .getDefaultSharedPreferences(AutoUpdateService.this).edit();
                        editor.putString("weather",responseText);
                        editor.apply();
                    }
                }
            });
        }

    }
    private void updateBingPic(){
           String requestBingPic="http://guolin.tech/api/bing_pic";
           HttpUtil.sendOkHttpRequest(requestBingPic, new Callback() {
               @Override
               public void onFailure(Call call, IOException e) {
                   e.printStackTrace();
               }

               @Override
               public void onResponse(Call call, Response response) throws IOException {
                    String bingPic =response.body().string();
                    SharedPreferences.Editor editor=PreferenceManager
                            .getDefaultSharedPreferences(AutoUpdateService.this).edit();
                   editor.putString("bing_pic",bingPic);
                   editor.apply();
               }
           });
    }
}
