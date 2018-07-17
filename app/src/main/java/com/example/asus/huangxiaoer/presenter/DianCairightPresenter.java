package com.example.asus.huangxiaoer.presenter;


import com.example.asus.huangxiaoer.Iview.IMDianCairightActivity;
import com.example.asus.huangxiaoer.Iview.IMDianCairightPresenter;
import com.example.asus.huangxiaoer.bean.DianCaiBean;
import com.example.asus.huangxiaoer.model.DianCairightModel;

/**
 * author:Created by gengtianbo on 2018/7/2.
 */
public class DianCairightPresenter implements IMDianCairightPresenter {

    IMDianCairightActivity imDianCaiActivity;
    private final DianCairightModel model;

    public DianCairightPresenter(IMDianCairightActivity imDianCaiActivity) {
        this.imDianCaiActivity = imDianCaiActivity;
        model = new DianCairightModel( this );
    }


    public void getUrl(String id) {
        model.getUrl(id);
    }


    @Override
    public void right(DianCaiBean bean) {
        imDianCaiActivity.right( bean );
    }
    public void data() {
        imDianCaiActivity = null;
    }
}
