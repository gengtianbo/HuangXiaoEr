package com.example.asus.huangxiaoer.presenter;

import com.example.asus.huangxiaoer.Iview.IMLoginActivity;
import com.example.asus.huangxiaoer.Iview.IMLoginPresenter;
import com.example.asus.huangxiaoer.bean.LoginBean;
import com.example.asus.huangxiaoer.model.LoginModel;

/**
 * author:Created by gengtianbo on 2018/7/16.
 */
public class LoginPresenter implements IMLoginPresenter {
    IMLoginActivity imLoginActivity;
    private final LoginModel model;

    public LoginPresenter(IMLoginActivity imLoginActivity) {
        this.imLoginActivity = imLoginActivity;
        model = new LoginModel( this );
    }

    @Override
    public void login(LoginBean bean) {
        imLoginActivity.login( bean );
    }

    public void getUrl(String name,String pwd) {
         model.getUrl(name,pwd);
    }
}
