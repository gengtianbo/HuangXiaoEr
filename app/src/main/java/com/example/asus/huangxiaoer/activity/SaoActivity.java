package com.example.asus.huangxiaoer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.asus.huangxiaoer.R;

public class SaoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img;
    private RadioButton but1;
    private RadioButton but2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sao);
        initView();
    }

    private void initView() {
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        img = findViewById(R.id.img);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.img:
                Bundle bundle1=new Bundle();
                bundle1.putInt("aa",1);
                Intent intent1=new Intent(SaoActivity.this,HomeActivity.class);
                startActivity(intent1);
                break;
            case R.id.but1:
                Bundle bundle2=new Bundle();
                bundle2.putInt("aa",2);
                Intent intent2=new Intent(SaoActivity.this, HomeActivity.class);
                intent2.putExtras(bundle2);
                startActivity(intent2);
                break;
            case R.id.but2:
                Bundle bundle3=new Bundle();
                bundle3.putInt("aa",3);
                Intent intent3=new Intent(SaoActivity.this, HomeActivity.class);
                intent3.putExtras(bundle3);
                startActivity(intent3);
                break;
        }
    }
}
