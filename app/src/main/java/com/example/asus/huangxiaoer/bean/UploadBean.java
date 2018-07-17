package com.example.asus.huangxiaoer.bean;

/**
 * author:Created by gengtianbo on 2018/7/10.
 */
public class UploadBean {

    public String code;
    public String msg;

    public UploadBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
