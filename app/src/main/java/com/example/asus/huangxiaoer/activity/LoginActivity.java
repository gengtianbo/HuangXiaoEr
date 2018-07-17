package com.example.asus.huangxiaoer.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.huangxiaoer.Iview.IMLoginActivity;
import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.bean.LoginBean;
import com.example.asus.huangxiaoer.presenter.LoginPresenter;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener,IMLoginActivity {

    private ImageView iv_login_yanzhengma, iv_login_yanzhengma1, daojishi_img;
    private RelativeLayout relativeLayout1, relativeLayout2, daojishi;
    private TextView tv_login_changgui;
    private int num = 0;
    private int mima = 0;
    private TextView daojishi_text;
    private Timer timer;
    private int size = 0;
    private ImageView showmima;
    private EditText et_login_pwd2,et_login_phone;
    private Button login;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            int what = msg.what;
            size = what;
            //倒计时==0时
            if (what == 0) {
                iv_login_yanzhengma.setImageResource( R.drawable.getagain );//重新获取验证码
                daojishi.setVisibility( View.INVISIBLE );//倒计时
                daojishi_text.setText( "30s后" );
                timer.cancel();
                return;
            } else {
                daojishi_text.setText( what + "s后" );
            }
        }
    };
    private ImageView image_qq;
    private LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        presenter = new LoginPresenter(this);
        initView();
        qq();
    }

    private void initView() {
        login = findViewById( R.id.login );
        login.setOnClickListener( this );
        tv_login_changgui = findViewById( R.id.tv_login_changgui );
        iv_login_yanzhengma = findViewById( R.id.iv_login_yanzhengma );
        iv_login_yanzhengma.setOnClickListener( this );
        relativeLayout1 = findViewById( R.id.relativeLayout1 );
        relativeLayout2 = findViewById( R.id.relativeLayout2 );
        tv_login_changgui.setOnClickListener( this );
        iv_login_yanzhengma1 = findViewById( R.id.iv_login_yanzhengma );
        daojishi = findViewById( R.id.daojishi );
        daojishi_text = findViewById( R.id.tv_daojishi );
        showmima = findViewById( R.id.showmima );
        showmima.setOnClickListener( this );
        et_login_pwd2 = findViewById( R.id.et_login_pwd2 );
        et_login_phone = findViewById( R.id.et_login_phone );
        showmima.setImageResource( R.drawable.hidemima );
        et_login_pwd2.setTransformationMethod( PasswordTransformationMethod.getInstance() );
        image_qq = findViewById( R.id.image_qq );

    }

    private void qq() {
        final UMShareAPI umShareAPI = UMShareAPI.get( this );
        image_qq.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                umShareAPI.getPlatformInfo( LoginActivity.this, SHARE_MEDIA.QQ, authListener );
            }
        } );
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.CALL_PHONE,
                    Manifest.permission.READ_LOGS,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.SET_DEBUG_APP,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.GET_ACCOUNTS,
                    Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions( this, mPermissionList, 123 );
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        UMShareAPI.get( this ).onActivityResult( requestCode, resultCode, data );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
    }

    /**
     * 点击事件
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //切换登录方式  改变布局
            case R.id.tv_login_changgui:
                num++;
                if (num % 2 == 1) {
                    relativeLayout1.setVisibility( View.INVISIBLE );
                    relativeLayout2.setVisibility( View.VISIBLE );
                    tv_login_changgui.setText( "短信验证码登录方式" );
                } else if (num % 2 == 0) {
                    relativeLayout2.setVisibility( View.INVISIBLE );
                    relativeLayout1.setVisibility( View.VISIBLE );
                    tv_login_changgui.setText( "使用常规登录方式" );
                }

                break;
            //获取验证码
            case R.id.iv_login_yanzhengma:
                if (size > 0) {
                    //不作操作
                } else {
                    daojishi.setVisibility( View.VISIBLE );
                    timer = new Timer();
                    TimerTask timerTask = new TimerTask() {
                        int t = 30;

                        @Override
                        public void run() {
                            t--;
                            Message msg = Message.obtain();
                            msg.what = t;
                            handler.sendMessage( msg );
                        }
                    };
                    timer.schedule( timerTask, 1000, 1000 );
                }

                break;
            //隐藏显示密码
            case R.id.showmima:
                mima++;
                if (mima % 2 == 0) {
                    //隐藏密码
                    showmima.setImageResource( R.drawable.hidemima );
                    et_login_pwd2.setTransformationMethod( PasswordTransformationMethod.getInstance() );
                } else if (mima % 2 == 1) {
                    //显示密码
                    showmima.setImageResource( R.drawable.showmima );
                    et_login_pwd2.setTransformationMethod( HideReturnsTransformationMethod.getInstance() );
                }
                break;
            case R.id.login:
                String s = et_login_phone.getText().toString();
                String s1 = et_login_pwd2.getText().toString();
                presenter.getUrl( s,s1 );
                Intent intent = new Intent( LoginActivity.this, SaoActivity.class );
                startActivity( intent );
                break;
        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Map<String, String> map = data;
            Log.i( "data", map.toString() );

            String name = map.get( "name" );
            String headimg = map.get( "profile_image_url" );
            String expiration = map.get( "expiration" );
            Intent intent = new Intent( LoginActivity.this, HomeActivity.class );
            intent.putExtra( "name", name );
            intent.putExtra( "headimg", headimg );
            intent.putExtra( "expiration", expiration );
            setResult( 2, intent );
            finish();
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText( LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG ).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText( LoginActivity.this, "取消了", Toast.LENGTH_LONG ).show();
        }
    };

    @Override
    public void login(LoginBean bean) {
        Toast.makeText( LoginActivity.this, bean.getMsg(), Toast.LENGTH_LONG ).show();
    }
}
