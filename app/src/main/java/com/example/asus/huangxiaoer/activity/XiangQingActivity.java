package com.example.asus.huangxiaoer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.asus.huangxiaoer.CanPinFragment.CanPinFragment;
import com.example.asus.huangxiaoer.CanPinFragment.PinJiaFragment;
import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.adapter.MyRightZiAdapter;
import com.example.asus.huangxiaoer.bean.DianCaiBean;

import java.util.List;

public class XiangQingActivity extends AppCompatActivity implements MyRightZiAdapter.ModifyGoodsItemNumberListener{

    private ViewPager vp;
    private int totalNum = 0;
    private double totalPrice= 0.00;
    List<DianCaiBean.DataBean.SpusBean> spus;
    private MyRightZiAdapter adapter;
    List<DianCaiBean.DataBean> data;
    private TextView tvAllPrice,tv_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_xiang_qing );
        vp = (ViewPager) findViewById( R.id.vp );
        RadioGroup radioGroup = findViewById( R.id.rg );
        TextView textView = findViewById( R.id.tv );
        textView.setText( "知青居" );
        ImageView image_fanhui = findViewById( R.id.image_fanhui );
        adapter = new MyRightZiAdapter( spus, this );
        tvAllPrice = (TextView) findViewById(R.id.heji);
        tv_num  = findViewById( R.id.tv_num );
        image_fanhui.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
        vp.setAdapter( new FragmentPagerAdapter( getSupportFragmentManager() ) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new CanPinFragment();
                        break;
                    case 1:
                        fragment = new PinJiaFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 2;
            }
        } );
        radioGroup.setOnCheckedChangeListener( new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        vp.setCurrentItem( 0 );
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem( 1 );
                        break;
                }
            }
        } );


    }
    @Override
    public void jia(int position, View view) {
        DianCaiBean.DataBean.SpusBean spusBean = data.get( position ).getSpus().get( position );
        int praise_num = spusBean.getPraise_num();
        praise_num++;
        spusBean.setPraise_num( praise_num );
        adapter.notifyDataSetChanged();
        checkedPrice();
    }

    @Override
    public void jian(int position, View view) {
        DianCaiBean.DataBean.SpusBean spusBean = data.get( position ).getSpus().get( position );
        int praise_num = spusBean.getPraise_num();
        if (praise_num==1){
            return;
        }
        praise_num--;
        spusBean.setPraise_num( praise_num );
        adapter.notifyDataSetChanged();
        checkedPrice();
    }
    private void checkedPrice() {
        totalNum = 0;
        totalPrice = 0.00;
        for (DianCaiBean.DataBean datum : data) {
            for (DianCaiBean.DataBean.SpusBean spusBean : datum.getSpus()) {
                totalNum++;
                totalPrice += spusBean.getPraise_num() * 30;
            }
        }
        tvAllPrice.setText("合计:￥"+totalPrice);
    }


}
