package com.fund.strategy;


import com.jingewenku.abrahamcaijin.commonutil.application.AppUtils;

import androidx.multidex.MultiDexApplication;

public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        AppUtils.init(this);
    }
}
