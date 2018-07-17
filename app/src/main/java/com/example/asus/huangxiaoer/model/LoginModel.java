package com.example.asus.huangxiaoer.model;

import com.example.asus.huangxiaoer.Iview.IMLoginPresenter;
import com.example.asus.huangxiaoer.bean.LoginBean;
import com.example.asus.huangxiaoer.utils.RetrofitUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by gengtianbo on 2018/7/16.
 */
public class LoginModel {
    IMLoginPresenter imLoginPresenter;

    public LoginModel(IMLoginPresenter imLoginPresenter) {
        this.imLoginPresenter = imLoginPresenter;
    }

    public void getUrl(String name,String pwd) {
        Observable<LoginBean> loginBean = RetrofitUtils.getInstance().getApi().getLoginBean(name,pwd);
        loginBean.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() )
                .subscribe( new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean value) {
                        imLoginPresenter.login( value );
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
