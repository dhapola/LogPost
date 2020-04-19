package com.deepesh.logpostdemo;

import android.app.Application;

import com.logpost.android.Logger;

public class LogPostDemoApplication extends Application {

    private static LogPostDemoApplication applicationInstance = null;

    @Override
    public void onCreate(){
        super.onCreate();

        applicationInstance = this;
        Logger.startLooper();
    }

    @Override
    public void onTerminate() {

        Logger.stopLooper();
        super.onTerminate();
    }

    public static Application getInstance(){
        return applicationInstance;
    }

}
