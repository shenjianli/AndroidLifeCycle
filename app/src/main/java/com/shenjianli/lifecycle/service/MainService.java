package com.shenjianli.lifecycle.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.format.Time;

import com.shenjianli.shenlib.util.LogUtils;

public class MainService extends Service {

    private MainBinder mBinder = new MainBinder(this);

    @Override
    public void onCreate() {
        LogUtils.i("onCreate()");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        LogUtils.i("onStartCommand()");
        return flags;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        LogUtils.i("onStart()");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        LogUtils.i("onBind()");
        return mBinder;
    }


    //这里我写了一个获取当前时间的函数，不过没有格式化就先这么着吧
    public String getSystemTime(){

        Time t = new Time();
        t.setToNow();
        return t.toString();
    }


    @Override
    public boolean onUnbind(Intent intent) {
        LogUtils.i("onUnbind()");
        return false;
    }

    @Override
    public void onDestroy() {
        LogUtils.i("onDestroy()");
    }


}
