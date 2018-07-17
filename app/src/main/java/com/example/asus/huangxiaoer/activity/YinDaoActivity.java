package com.example.asus.huangxiaoer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.yingdao.Fragment1;
import com.example.asus.huangxiaoer.yingdao.Fragment2;
import com.example.asus.huangxiaoer.yingdao.Fragment3;
import com.example.asus.huangxiaoer.yingdao.Fragment4;

public class YinDaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_yin_dao );

        ViewPager viewPager = findViewById( R.id.vp );

        viewPager.setAdapter( new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position){
                    case 0:
                        fragment = new Fragment1();
                        break;
                    case 1:
                        fragment = new Fragment2();
                        break;
                    case 2:
                        fragment = new Fragment3();
                        break;
                    case 3:
                        fragment = new Fragment4();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return 4;
            }
        } );
    }
}
