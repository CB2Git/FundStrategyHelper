package com.fund.strategy.model.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static final String BASE_URL = "https://fundmobapi.eastmoney.com/";

    private RetrofitManager() {

    }

    private static Retrofit mRetrofitClient = null;

    private static Retrofit getRetroClient() {
        if (mRetrofitClient == null) {
            synchronized (RetrofitManager.class) {
                if (mRetrofitClient == null) {
                    mRetrofitClient = new Retrofit
                            .Builder()
                            .baseUrl(BASE_URL)
                            .client(OkHttpManager.getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return mRetrofitClient;
    }

    public static Api getApiService() {
        return getRetroClient().create(Api.class);
    }
}
