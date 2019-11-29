package com.jongchan.ctest;

import android.app.Application;

import com.jongchan.ctest.network.AppRequestAPI;

public class CTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AppRequestAPI.getInstance();
    }
}
