package com.example.asus.huangxiaoer.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by gengtianbo on 2018/7/2.
 */
public class RetrofitUtils2 {

    private final Retrofit retrofit;
    public static RetrofitUtils2 retrofitUtils = null;
    public RetrofitUtils2(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor( new HttpLoggingInterceptor(  ).setLevel( HttpLoggingInterceptor.Level.BODY ) )
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl( "http://www.wanandroid.com/" )
                .addConverterFactory( GsonConverterFactory.create() )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .build();
    }
    public static RetrofitUtils2 getRetrofitUtils(){
        if (null == retrofitUtils){
            synchronized (RetrofitUtils.class){
                if (null==retrofitUtils){
                    retrofitUtils = new RetrofitUtils2();
                }
            }
        }
        return retrofitUtils;
    }

    public Api2 getApi(){
        return retrofit.create( Api2.class );
    }
}
