package com.example.asus.huangxiaoer.model;


import com.example.asus.huangxiaoer.Iview.IMDianCairightPresenter;
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
public class DianCairightModel {
    IMDianCairightPresenter imDianCaiPresenter;
    public DianCairightModel(IMDianCairightPresenter imDianCaiPresenter) {

        this.imDianCaiPresenter = imDianCaiPresenter;

    }

    public void getUrl(String id) {
        Observable<DianCaiBean> dianCaiBean = RetrofitUtils2.getRetrofitUtils().getApi().getDianCaiBean2( id );

        dianCaiBean.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<DianCaiBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DianCaiBean value) {
                        imDianCaiPresenter.right( value );
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
