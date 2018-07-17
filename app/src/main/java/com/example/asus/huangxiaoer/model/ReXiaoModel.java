package com.example.asus.huangxiaoer.model;

import com.example.asus.huangxiaoer.Iview.IMReXiaoPresnter;
import com.example.asus.huangxiaoer.bean.ReXiaoBean;
import com.example.asus.huangxiaoer.utils.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * author:Created by gengtianbo on 2018/7/9.
 */
public class ReXiaoModel {
    IMReXiaoPresnter imReXiaoPresnter;
    public ReXiaoModel(IMReXiaoPresnter imReXiaoPresnter) {

        this.imReXiaoPresnter = imReXiaoPresnter;

    }

    public void getUrl() {
        Observable<ReXiaoBean> reXiaoBean = RetrofitUtils.getInstance().getApi().getReXiaoBean();
        reXiaoBean.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<ReXiaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ReXiaoBean value) {
                          imReXiaoPresnter.rexiao( value );
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
