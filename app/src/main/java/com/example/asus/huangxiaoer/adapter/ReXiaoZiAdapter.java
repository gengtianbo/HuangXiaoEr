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
import com.example.asus.huangxiaoer.bean.ReXiaoBean;

import java.util.List;

/**
 * author:Created by gengtianbo on 2018/7/9.
 */
public class ReXiaoZiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ReXiaoBean.DataBean.TuijianBean.ListBeanX> list;
    Context context;

    public ReXiaoZiAdapter(List<ReXiaoBean.DataBean.TuijianBean.ListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( context ).inflate( R.layout.rexiao_zi_item, null );
        View1Holder view1Holder = new View1Holder( view );
        return view1Holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String images = list.get( position ).getImages();
        String[] split = images.split( ".jpg" );
        Glide.with( context ).load( split[0] + ".jpg" ).into(((View1Holder) holder).vimage_rexiao);
        ((View1Holder) holder).tv_rexiao_name.setText( list.get( position ).getTitle() );
        ((View1Holder) holder).tv_rexiao_price.setText( list.get( position ).getPrice() + "" );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class View1Holder extends RecyclerView.ViewHolder {
        private final ImageView vimage_rexiao;
        private final TextView tv_rexiao_price, tv_rexiao_name;

        public View1Holder(View itemView) {
            super( itemView );
            vimage_rexiao = itemView.findViewById( R.id.image_rexiao );
            tv_rexiao_price = itemView.findViewById( R.id.tv_rexiao_price );
            tv_rexiao_name = itemView.findViewById( R.id.tv_rexiao_name );
        }
    }
}
