package com.example.asus.huangxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.adapter.MainViewPagerAdapter;
import com.example.asus.huangxiaoer.fragment.SaoMaFragment;
import com.example.asus.huangxiaoer.fragment.WoDeFragment;
import com.example.asus.huangxiaoer.fragment.YuYueFragment;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioButton but1,but2;
    private RadioButton main_img;
    private ViewPager viewPager;
    private SaoMaFragment saoMaFragment;
    private WoDeFragment woDeFragment;
    private YuYueFragment yuYueFragment;
    private MainViewPagerAdapter pagerAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();

    }
    private void initView() {
        yuYueFragment = new YuYueFragment();
        woDeFragment = new WoDeFragment();
        viewPager = findViewById(R.id.viewPager);
        saoMaFragment = new SaoMaFragment();
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        main_img = findViewById(R.id.main_img);
        main_img.setOnClickListener(this);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,yuYueFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,woDeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,saoMaFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,saoMaFragment).commit();
        viewPager.setVisibility(View.GONE);
    }

    private void initData() {
        pagerAdapter1 = new MainViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter1);
        Intent intent=getIntent();
        int aa = intent.getIntExtra("aa", 0);
        if(aa==1)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,saoMaFragment).commit();
        }
        else if(aa==2)
        {
            getSupportFragmentManager().beginTransaction().hide(saoMaFragment).commit();
            but1.setChecked(true);
            but2.setChecked(false);
            viewPager.setVisibility(View.VISIBLE);
            viewPager.setCurrentItem(0);
        }
        else if(aa==3)
        {
            getSupportFragmentManager().beginTransaction().hide(saoMaFragment).commit();
            but2.setChecked(true);
            but1.setChecked(false);
            viewPager.setVisibility(View.VISIBLE);
            viewPager.setCurrentItem(1);
        }

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position)
                {
                    case 0:
                        but1.setChecked(true);
                        but2.setChecked(false);
                        break;
                    case 1:
                        but2.setChecked(true);
                        but1.setChecked(false);
                        break;
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.but1:
                viewPager.setVisibility( View.VISIBLE);
                viewPager.setCurrentItem(0);
                getSupportFragmentManager().beginTransaction().hide(saoMaFragment).commit();
                break;
            case R.id.main_img:
                getSupportFragmentManager().beginTransaction().show(saoMaFragment).commit();
                viewPager.setVisibility(View.GONE);
                but1.setChecked(false);
                but2.setChecked(false);
                break;
            case R.id.but2:
                viewPager.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(1);
                getSupportFragmentManager().beginTransaction().hide(saoMaFragment).commit();
                break;
        }
    }
}
