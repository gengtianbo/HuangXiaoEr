package com.example.asus.huangxiaoer.yingdao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.huangxiaoer.R;

/**
 * author:Created by gengtianbo on 2018/7/6.
 */
public class Fragment1 extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate( R.layout.fragment1, container, false );

        return inflate;
    }
}
