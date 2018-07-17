package com.example.asus.huangxiaoer.utils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author:Created by gengtianbo on 2018/7/2.
 */
public class RetrofitUtils3 {

    private final Retrofit retrofit;
    public static RetrofitUtils3 retrofitUtils = null;
    public RetrofitUtils3(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor( new HttpLoggingInterceptor(  ).setLevel( HttpLoggingInterceptor.Level.BODY ) )
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl( "http://39.108.3.12:3000/" )
                .addConverterFactory( GsonConverterFactory.create() )
                .addCallAdapterFactory( RxJava2CallAdapterFactory.create() )
                .build();
    }
    public static RetrofitUtils3 getRetrofitUtils(){
        if (null == retrofitUtils){
            synchronized (RetrofitUtils3.class){
                if (null==retrofitUtils){
                    retrofitUtils = new RetrofitUtils3();
                }
            }
        }
        return retrofitUtils;
    }

    public Api3 getApi(){
        return retrofit.create( Api3.class );
    }
}
