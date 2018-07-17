package com.example.asus.huangxiaoer.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.example.asus.huangxiaoer.R;

public class GuanYuActivity extends AppCompatActivity {

    private TextView tv_banben;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_guan_yu );
        final Handler handler = new Handler();
        ImageView imageView = findViewById( R.id.image_qwe );
        TextView textView = findViewById( R.id.tv );
        tv_banben = findViewById( R.id.tv_banben );
        textView.setText( "关于黄小二" );
        ImageView image_fanhui = findViewById( R.id.image_fanhui );
        image_fanhui.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( GuanYuActivity.this,SettingActivity.class );
                startActivity( intent );
            }
        } );
        Glide.with( this ).load( R.drawable.shanping )
                .diskCacheStrategy( DiskCacheStrategy.SOURCE )
                .listener( new RequestListener<Integer, GlideDrawable>() {
                    public static final int ANIMDISMISS = 1;

                    @Override
                    public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        int duration = 0;
                        // 计算动画时长
                        GifDrawable drawable = (GifDrawable) resource;
                        GifDecoder decoder = drawable.getDecoder();
                        for (int i = 0; i < drawable.getFrameCount(); i++) {
                            duration += decoder.getDelay( i );
                        }
                        //发送延时消息，通知动画结束
                        handler.sendEmptyMessageDelayed( ANIMDISMISS, duration );
                        return false;
                    }
                } )
                .into( new GlideDrawableImageViewTarget( imageView, 1 ) );

        try {
            getVersionName();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private String getVersionName() throws Exception {
        PackageManager packageManager = getPackageManager();
        PackageInfo packInfo = packageManager.getPackageInfo( getPackageName(), 0 );
        Log.e( "TAG", "版本号" + packInfo.versionCode );
        Log.e( "TAG", "版本名" + packInfo.versionName );
        tv_banben.setText("v"+ packInfo.versionName );
        return packInfo.versionName;
    }


}

