package com.example.asus.huangxiaoer.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.utils.CleanMessageUtil;

public class SettingActivity extends AppCompatActivity {

    private TextView tv_clear;

    private String totalCacheSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setting );
        LinearLayout ll_guanyu = findViewById( R.id.ll_guanyu );
        LinearLayout ll_banbengengxin = findViewById( R.id.ll_banbengengxin );
        ImageView image_fanhui = findViewById( R.id.image_fanhui );
        LinearLayout ll_qingchuhuancun = findViewById( R.id.ll_qingchuhuancun );
        tv_clear = findViewById( R.id.tv_clear );
        ll_banbengengxin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SettingActivity.this, BanBenGengXinActivity .class );
                startActivity( intent );
            }
        } );
        ll_qingchuhuancun.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder( SettingActivity.this );
                builder.setTitle( "确定要清除缓存吗？" );
                builder.setPositiveButton( "确定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            totalCacheSize = CleanMessageUtil.getTotalCacheSize( SettingActivity.this );
                            tv_clear.setText( totalCacheSize );
                            CleanMessageUtil.clearAllCache( getApplicationContext() );
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                } );
                builder.setNegativeButton( "取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } ).show();
            }
        } );
        image_fanhui.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SettingActivity.this, SaoActivity.class );
                startActivityForResult( intent, 1 );
            }
        } );
        ll_guanyu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( SettingActivity.this, GuanYuActivity.class );
                startActivity( intent );
            }
        } );

    }
}
