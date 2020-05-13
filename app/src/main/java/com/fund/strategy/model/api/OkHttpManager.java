package com.fund.strategy.model.api;

import android.text.TextUtils;

import com.fund.strategy.App;
import com.jingewenku.abrahamcaijin.commonutil.application.AppUtils;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.Nullable;
import okhttp3.Cache;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpManager {

    private static OkHttpClient okHttpClient;

    private OkHttpManager() {

    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            synchronized (OkHttpManager.class) {
                if (okHttpClient == null) {
                    // 指定缓存路径,缓存大小50Mb
                    Cache cache = new Cache(new File(AppUtils.getContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 50);
                    if (okHttpClient == null) {
                        okHttpClient = new OkHttpClient.Builder()
                                .cache(cache)
                                .retryOnConnectionFailure(true)
                                //添加通用参数
                                .addInterceptor(new CommonRequestParameterInterceptor())
                                .addInterceptor(new ModifyUrlInterceptor())
                                .build();
                    }
                }
            }
        }
        return okHttpClient;
    }

    private static class ModifyUrlInterceptor implements Interceptor {

        private static final String NEW_URL_KEY = "url";

        @NotNull
        @Override
        public Response intercept(@NotNull Chain chain) throws IOException {
            Request request = chain.request();
            String url = request.header(NEW_URL_KEY);

            if (!TextUtils.isEmpty(url)) {
                HttpUrl httpUrl = request.url();

                HttpUrl parse = HttpUrl.parse(url);
                HttpUrl.Builder builder = httpUrl.newBuilder();

                if (parse != null) {
                    builder.scheme(parse.scheme())
                            .host(parse.host())
                            .port(parse.port());
                }

                request = request.newBuilder()
                        .url(builder.build())
                        .removeHeader(NEW_URL_KEY)
                        .build();
            }

            return chain.proceed(request);
        }
    }

    private static class CommonRequestParameterInterceptor implements Interceptor {

        private static final String TAG = "CommonRequestParameterI";

        private static final Map<String, String> sCommonParams = new HashMap<>();

        public CommonRequestParameterInterceptor() {
            sCommonParams.put("product", "EFund");
            sCommonParams.put("plat", "Android");
            sCommonParams.put("appType", "ttjj");
            sCommonParams.put("Version", "6.2.4");
            sCommonParams.put("deviceid", "656c09923c567b89bb44801020bc59ab%7C%7Ciemi_tluafed_me");
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String method = request.method();
            if ("GET".equalsIgnoreCase(method)) {
                //注入到url
                request = injectParamsIntoUrl(request);
            } else if ("POST".equalsIgnoreCase(method)) {
                //注入到body
                Request paramsIntoForm = injectParamsIntoForm(request);
                if (paramsIntoForm != null) {
                    request = paramsIntoForm;
                } else {
                    //如果body注入不了，则尝试注入url
                    request = injectParamsIntoUrl(request);
                }
            }

            return chain.proceed(request);
        }

        private Request injectParamsIntoUrl(Request request) {
            Request.Builder requestBuilder = request.newBuilder();
            HttpUrl.Builder httpUrlBuilder = request.url().newBuilder();

            //原始的请求数据
            HttpUrl httpUrl = request.url();

            for (Map.Entry<String, String> entry : sCommonParams.entrySet()) {
                //如果请求的参数中没有通用参数则添加
                if (TextUtils.isEmpty(httpUrl.queryParameter(entry.getKey()))) {
                    httpUrlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
                }
            }

            requestBuilder.url(httpUrlBuilder.build());
            return requestBuilder.build();
        }

        @Nullable
        private Request injectParamsIntoForm(Request request) {
            RequestBody body = request.body();
            if (body instanceof FormBody) {
                FormBody formBody = (FormBody) body;
                FormBody.Builder builder = new FormBody.Builder();

                int size = formBody.size();

                //复制原始参数
                for (int i = 0; i < size; i++) {
                    builder.add(formBody.name(i), formBody.value(i));
                }

                //加入通用参数
                for (Map.Entry<String, String> entry : sCommonParams.entrySet()) {
                    boolean contain = false;
                    for (int i = 0; i < size; i++) {
                        //在原始参数中搜索是否存在通用参数
                        if (formBody.name(i).equalsIgnoreCase(entry.getKey())) {
                            contain = true;
                            break;
                        }
                    }

                    //不存在通用参数才添加参数
                    if (!contain) {
                        builder.add(entry.getKey(), entry.getValue());
                    }

                }
                return request.newBuilder()
                        .post(builder.build())
                        .build();
            }
            return null;
        }
    }
}
