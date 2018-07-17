package com.example.asus.huangxiaoer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.huangxiaoer.R;

public class XiHuanDeDianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_xi_huan_de_dian );

        TextView textView = findViewById( R.id.tv );
        textView.setText( "喜欢的店" );
        ImageView image_fanhui = findViewById( R.id.image_fanhui );
        image_fanhui.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             finish();
            }
        } );

    }
}
