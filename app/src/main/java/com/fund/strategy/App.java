package com.fund.strategy;

import android.app.Application;

public class App extends Application {

    private static Application sApp;

    public static Application getApplication() {
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }
}
