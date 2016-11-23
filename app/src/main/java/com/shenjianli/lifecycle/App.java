package com.shenjianli.lifecycle;

import android.app.Application;

import com.shenjianli.shenlib.LibApp;

/**
 * Created by edianzu on 2016/11/23.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        LibApp.getLibInstance().setLogEnable(true);
    }
}
