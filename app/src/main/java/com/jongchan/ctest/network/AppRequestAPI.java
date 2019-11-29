package com.jongchan.ctest.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppRequestAPI {
    private static final String BASE_URL = "http://demo2587971.mockable.io/";
    private static OkHttpClient mOkHttpClient = null;

    private AppRequestAPI() {
        initOkHttpClient();
    }

    public static AppRequestAPI getInstance() {
        return AppRequestAPI.LazyHolder.INSTANCE;
    }

    private void initOkHttpClient() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build();
    }

    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static class LazyHolder {
        private static final AppRequestAPI INSTANCE = new AppRequestAPI();
    }
}
