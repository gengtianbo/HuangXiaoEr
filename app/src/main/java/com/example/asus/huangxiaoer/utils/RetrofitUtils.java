package com.example.asus.huangxiaoer.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by gengtianbo on 2018/7/9.
 */
public class RetrofitUtils {
    public static RetrofitUtils retrofit = null;
    private final Retrofit retrofit1;

    public RetrofitUtils() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor( new HttpLoggingInterceptor().setLevel( HttpLoggingInterceptor.Level.BODY ) )
                .build();
        retrofit1 = new Retrofit.Builder().baseUrl( "https://www.zhaoapi.cn/" )
                .addConverterFactory( GsonConverterFactory.create() )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (null == retrofit) {
            synchronized (RetrofitUtils.class) {
                if (null == retrofit) {
                    retrofit = new RetrofitUtils();
                }
            }
        }
        return retrofit;
    }

    public Api getApi() {
        return retrofit1.create( Api.class );
    }
}


