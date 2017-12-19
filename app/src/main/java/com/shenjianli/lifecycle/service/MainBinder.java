package com.shenjianli.lifecycle.service;

import android.os.Binder;

public class MainBinder extends Binder {

    private MainService mainService;
    public MainBinder(MainService mainService){
        this.mainService = mainService;
    }

    MainService getService() {
        return mainService;
    }
}
