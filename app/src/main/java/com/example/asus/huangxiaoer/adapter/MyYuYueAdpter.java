package com.example.asus.huangxiaoer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.bean.DianPuBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * author:Created by gengtianbo on 2018/7/12.
 */
public class MyYuYueAdpter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    List<DianPuBean.DataBean> data;
    Context context;

    public MyYuYueAdpter(List<DianPuBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( context ).inflate( R.layout.item_dianpu, null );
        View1Hoider view1Hoider = new View1Hoider( view );


        return view1Hoider;
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {

        Glide.with( context ).load( data.get( position ).getPic_url() ).into( ((View1Hoider)holder).image_dianpu_touxiang );
        ((View1Hoider) holder).tv_danpu_name.setText( data.get( position ).getName() );
        ((View1Hoider) holder).tv_dianpu_juli.setText( data.get( position ).getDistance() );
        ((View1Hoider) holder).tv_dianpu_pingfeng.setText( data.get( position ).getDelivery_score()+"" );
        ((View1Hoider) holder).tv_dianpu_renju.setText( data.get( position ).getAverage_price_tip() );
        ((View1Hoider) holder).tv_dianpu_yueshou.setText( data.get( position ).getMonth_sales_tip() );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class View1Hoider extends XRecyclerView.ViewHolder {

        private final ImageView image_dianpu_touxiang;
        private final TextView tv_danpu_name;
        private final TextView tv_dianpu_yueshou;
        private final TextView tv_dianpu_pingfeng;
        private final TextView tv_dianpu_renju;
        private final TextView tv_dianpu_juli;

        public View1Hoider(View itemView) {
            super( itemView );
            image_dianpu_touxiang = itemView.findViewById( R.id.image_dianpu_touxiang );
            tv_danpu_name = itemView.findViewById( R.id.tv_danpu_name );
            tv_dianpu_yueshou = itemView.findViewById( R.id.tv_dianpu_yueshou );
            tv_dianpu_pingfeng = itemView.findViewById( R.id.tv_dianpu_pingfeng );
            tv_dianpu_renju = itemView.findViewById( R.id.tv_dianpu_renju );
            tv_dianpu_juli = itemView.findViewById( R.id.tv_dianpu_juli );
        }
    }
}
