package com.example.asus.huangxiaoer.presenter;

import com.example.asus.huangxiaoer.Iview.IMBanBenGengXinActivity;
import com.example.asus.huangxiaoer.Iview.IMBanBenGengXinPresenter;
import com.example.asus.huangxiaoer.bean.BanBenGengXinBean;
import com.example.asus.huangxiaoer.model.BanBenGengXinModel;

/**
 * author:Created by gengtianbo on 2018/7/14.
 */
public class BanBenGengXinPresenter implements IMBanBenGengXinPresenter<BanBenGengXinBean> {
    IMBanBenGengXinActivity imBanBenGengXinActivity;
    private final BanBenGengXinModel model;

    public BanBenGengXinPresenter(IMBanBenGengXinActivity imBanBenGengXinActivity) {
        this.imBanBenGengXinActivity = imBanBenGengXinActivity;
        model = new BanBenGengXinModel( this );
    }


    public void getUrl() {
        model.getUrl();
    }


    @Override
    public void banbengengxin(BanBenGengXinBean banBenGengXinBean) {
        imBanBenGengXinActivity.banbengengxin( banBenGengXinBean );
    }
}
