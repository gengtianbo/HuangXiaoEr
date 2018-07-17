package com.example.asus.huangxiaoer.model;

import com.example.asus.huangxiaoer.Iview.IMBanBenGengXinPresenter;
import com.example.asus.huangxiaoer.bean.BanBenGengXinBean;
import com.example.asus.huangxiaoer.utils.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by gengtianbo on 2018/7/14.
 */
public class BanBenGengXinModel {

    IMBanBenGengXinPresenter imBanBenGengXinPresenter;

    public BanBenGengXinModel(IMBanBenGengXinPresenter imBanBenGengXinPresenter) {
        this.imBanBenGengXinPresenter = imBanBenGengXinPresenter;
    }

    public void getUrl() {
        Observable<BanBenGengXinBean> banbenGengXinBean = RetrofitUtils.getInstance().getApi().getBanbenGengXinBean();
        banbenGengXinBean.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<BanBenGengXinBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BanBenGengXinBean value) {
                        imBanBenGengXinPresenter.banbengengxin( value );
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
