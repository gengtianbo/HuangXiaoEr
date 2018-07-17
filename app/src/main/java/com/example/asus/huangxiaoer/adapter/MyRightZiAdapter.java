package com.example.asus.huangxiaoer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.bean.DianCaiBean;

import java.util.List;

/**
 * author:Created by gengtianbo on 2018/7/2.
 */
public class MyRightZiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ModifyGoodsItemNumberListener modifyGoodsItemNumberListener;
    List<DianCaiBean.DataBean.SpusBean> spus;
    Context context;

    public MyRightZiAdapter(List<DianCaiBean.DataBean.SpusBean> spus, Context context) {
        this.spus = spus;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( context ).inflate( R.layout.item_right_zi, null );
        return new View1Holder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {
        Glide.with( context ).load( spus.get( position ).getPic_url() ).into( ((View1Holder) holder).image_right_zi );
        ((View1Holder) holder).tv_name.setText( spus.get( position ).getName() );
        ((View1Holder) holder).tv_yueshou.setText( "月售" + spus.get( position ).getPraise_num() );
        ((View1Holder) holder).tv_price.setText( "￥：" + spus.get( position ).getSkus().get( 0 ).getPrice() );

        ((View1Holder) holder).jian.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyGoodsItemNumberListener.jian( position,((View1Holder) holder).num );
            }
        } );
        ((View1Holder) holder).jia.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyGoodsItemNumberListener.jia( position,((View1Holder) holder).num );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return spus.size();
    }

    class View1Holder extends RecyclerView.ViewHolder {


        private final ImageView image_right_zi;
        private final TextView tv_name;
        private final TextView tv_yueshou;
        private final TextView tv_price, jian, num, jia;

        public View1Holder(View itemView) {
            super( itemView );

            image_right_zi = itemView.findViewById( R.id.image_right_zi );
            tv_name = itemView.findViewById( R.id.tv_name );
            tv_yueshou = itemView.findViewById( R.id.tv_yueshou );
            tv_price = itemView.findViewById( R.id.tv_price );
            jian = itemView.findViewById( R.id.jian );
            num = itemView.findViewById( R.id.num );
            jia = itemView.findViewById( R.id.jia );

        }
    }

    public interface ModifyGoodsItemNumberListener {
        void jia(int position, View view);

        void jian(int position, View view);
    }

}
