package com.example.asus.huangxiaoer.model;


import com.example.asus.huangxiaoer.Iview.IMDianCaiPresenter;
import com.example.asus.huangxiaoer.bean.DianCaiBean;
import com.example.asus.huangxiaoer.utils.RetrofitUtils2;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by gengtianbo on 2018/7/2.
 */
public class DianCaiModel {
    IMDianCaiPresenter imDianCaiPresenter;
    public DianCaiModel(IMDianCaiPresenter imDianCaiPresenter) {

        this.imDianCaiPresenter = imDianCaiPresenter;

    }

    public void getUrl() {
        Observable<DianCaiBean> dianCaiBean = RetrofitUtils2.getRetrofitUtils().getApi().getDianCaiBean();

        dianCaiBean.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<DianCaiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DianCaiBean value) {
                        imDianCaiPresenter.diancai( value );
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                } );

    }
}
