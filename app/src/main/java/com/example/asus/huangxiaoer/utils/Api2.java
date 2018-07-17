package com.example.asus.huangxiaoer.utils;


import com.example.asus.huangxiaoer.bean.DianCaiBean;
import com.example.asus.huangxiaoer.bean.DianPuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author:Created by gengtianbo on 2018/7/2.
 */
public interface Api2 {


    @GET("tools/mockapi/6523/restaurant-list")
    Observable<DianCaiBean> getDianCaiBean();

    @GET("tools/mockapi/6523/restaurant-list")
    Observable<DianCaiBean> getDianCaiBean2(@Query("id") String id);

    @GET("tools/mockapi/6523/restaurants_offset_4_limit_4")
    Observable<DianPuBean> getDianPuBean();

}
