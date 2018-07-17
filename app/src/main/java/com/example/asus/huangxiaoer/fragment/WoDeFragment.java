package com.example.asus.huangxiaoer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.activity.BianJiZiLiaoActivity;
import com.example.asus.huangxiaoer.activity.LoginActivity;
import com.example.asus.huangxiaoer.activity.QuanBuDingDanActivity;
import com.example.asus.huangxiaoer.activity.SettingActivity;
import com.example.asus.huangxiaoer.activity.XiHuanDeDianActivity;
import com.example.asus.huangxiaoer.activity.YouHuiJuanActivity;

/**
 * author:Created by gengtianbo on 2018/7/6.
 */
public class WoDeFragment extends Fragment{

    private ImageView image_touxiang;
    private TextView tv_name,tv_user_zhanghao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.wodefragment, container, false );
        LinearLayout ll_shezhi = view.findViewById( R.id.ll_shezhi );
        LinearLayout ll_grrenziliao = view.findViewById( R.id.ll_grrenziliao );
        LinearLayout quanbudingdan = view.findViewById( R.id.quanbudingdan );
        LinearLayout ll_xihuandedian = view.findViewById( R.id.ll_xihuandedian );
        LinearLayout ll_youhuijuan = view.findViewById( R.id.ll_youhuijuan );
        image_touxiang = view.findViewById( R.id.image_touxiang );
        tv_name = view.findViewById( R.id.tv_name );
        tv_user_zhanghao = view.findViewById( R.id.tv_user_zhanghao );
        ll_youhuijuan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),YouHuiJuanActivity.class);
                startActivity( intent );
            }
        } );
        ll_xihuandedian.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),XiHuanDeDianActivity.class);
                startActivity( intent );
            }
        } );
        quanbudingdan.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),QuanBuDingDanActivity.class);
                startActivity( intent );
            }
        } );
        ll_grrenziliao.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),BianJiZiLiaoActivity.class);
                startActivity( intent );
            }
        } );
        ll_shezhi.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), SettingActivity.class );
                startActivity( intent );
            }
        } );
        tv_name.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), LoginActivity.class );
                startActivityForResult(intent, 1);
            }
        } );

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            //注册成功后传回来值，账号密码
            String name = data.getStringExtra("name");
            String headimg = data.getStringExtra("headimg");
            String expiration = data.getStringExtra("expiration");
            tv_name.setText( name );
            tv_user_zhanghao.setText( expiration );
            Glide.with( this ).load( headimg ).into( image_touxiang );
        }
    }
}
