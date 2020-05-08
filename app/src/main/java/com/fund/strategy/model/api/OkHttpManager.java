package com.fund.strategy.model.api;

import com.fund.strategy.App;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class OkHttpManager {

    private static OkHttpClient okHttpClient;

    private OkHttpManager() {

    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttpManager.class) {
                if (okHttpClient == null) {
                    // 指定缓存路径,缓存大小50Mb
                    Cache cache = new Cache(new File(App.getApplication().getCacheDir(), "HttpCache"), 1024 * 1024 * 50);
                    if (okHttpClient == null) {
                        okHttpClient = new OkHttpClient.Builder()
                                .cache(cache)
                                .retryOnConnectionFailure(true)
                                .build();
                    }
                }
            }
        }
        return okHttpClient;
    }
}
