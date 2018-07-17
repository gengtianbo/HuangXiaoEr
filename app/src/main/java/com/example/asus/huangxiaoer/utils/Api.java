package com.example.asus.huangxiaoer.utils;

import com.example.asus.huangxiaoer.bean.BanBenGengXinBean;
import com.example.asus.huangxiaoer.bean.LoginBean;
import com.example.asus.huangxiaoer.bean.ReXiaoBean;
import com.example.asus.huangxiaoer.bean.UploadBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * author:Created by gengtianbo on 2018/7/9.
 */
public interface Api {

    @GET("home/getHome")
    Observable<ReXiaoBean> getReXiaoBean();

    @POST("file/upload")
    @Multipart
    Observable<UploadBean> upload(@Part("uid") RequestBody uid, @Part MultipartBody.Part file);

    @GET("quarter/getVersion")
    Observable<BanBenGengXinBean> getBanbenGengXinBean();

    @GET("user/login")
    Observable<LoginBean> getLoginBean(@Query( "mobile" ) String mobile,@Query( "password" )String password);

}
