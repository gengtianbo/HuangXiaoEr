package com.example.asus.huangxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.bean.UploadBean;
import com.example.asus.huangxiaoer.utils.RetrofitUtils;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class BianJiZiLiaoActivity extends AppCompatActivity {

    private ImageView image_touxiang;
    private TextView tv_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bian_ji_zi_liao );
        TextView textView = findViewById( R.id.tv );
        textView.setText( "个人资料" );
        ImageView image_fanhui = findViewById( R.id.image_fanhui );
        image_fanhui.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        image_touxiang = findViewById( R.id.image_touxiang );
        tv_user = findViewById( R.id.tv_user );
        image_touxiang.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File f = new File( Environment.getExternalStorageDirectory(), "/storage/emulated/0/asd.jpg" );
                RequestBody uidBody = RequestBody.create( MediaType.parse( "multipart/form-data" ), "10134" );
                MultipartBody.Part filePart = MultipartBody.Part.createFormData( "file", f.getName(), RequestBody.create(
                        MediaType.parse( "application/octet-stream" ), f ) );

                Observable<UploadBean> upload = RetrofitUtils.getInstance().getApi().upload( uidBody, filePart );
                upload.subscribeOn( Schedulers.io() )
                        .observeOn( AndroidSchedulers.mainThread() )
                        .subscribe( new Consumer<UploadBean>() {
                            @Override
                            public void accept(UploadBean uploadBean) throws Exception {
                                Log.i( "aaaaaaaaaa", uploadBean.msg );
                            }
                        } );
            }
        } );

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            //注册成功后传回来值，账号密码
            String name = data.getStringExtra("name");
            String headimg = data.getStringExtra("headimg");

            tv_user.setText( name );
            Glide.with( this ).load( headimg ).into( image_touxiang );
        }
    }
}
