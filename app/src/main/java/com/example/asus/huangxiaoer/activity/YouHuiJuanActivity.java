package com.example.asus.huangxiaoer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.huangxiaoer.R;

public class YouHuiJuanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_you_hui_juan );

        TextView textView = findViewById( R.id.tv );
        textView.setText( "优惠券" );
        ImageView image_fanhui = findViewById( R.id.image_fanhui );
        image_fanhui.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        } );
    }
}
