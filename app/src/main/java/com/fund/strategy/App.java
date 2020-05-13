package com.fund.strategy;

import android.app.Application;

import com.jingewenku.abrahamcaijin.commonutil.application.AppUtils;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(this);
    }
}
