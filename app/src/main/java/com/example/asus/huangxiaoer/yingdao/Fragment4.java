package com.example.asus.huangxiaoer.yingdao;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.example.asus.huangxiaoer.activity.LoginActivity;
import com.example.asus.huangxiaoer.R;

/**
 * author:Created by gengtianbo on 2018/7/6.
 */
public class Fragment4 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = inflater.inflate( R.layout.fragment4, container, false );
        ImageView image_huanying = inflate.findViewById( R.id.image_huanying );
        ImageView bt_welcome = inflate.findViewById( R.id.bt_welcome );
        final Handler handler = new Handler();
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
                .into( new GlideDrawableImageViewTarget( image_huanying, 1 ) );
        bt_welcome.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getActivity(), LoginActivity.class );
                startActivity( intent );
            }
        } );
        return inflate;
    }
}
