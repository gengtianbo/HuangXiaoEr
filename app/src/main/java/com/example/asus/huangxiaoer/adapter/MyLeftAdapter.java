package com.example.asus.huangxiaoer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.bean.DianCaiBean;

import java.util.List;

/**
 * author:Created by gengtianbo on 2018/7/2.
 */
public class MyLeftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<DianCaiBean.DataBean> data;
    Context context;

    public MyLeftAdapter(List<DianCaiBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from( context ).inflate( R.layout.item_left, null );
        final View1Holder view1Holder = new View1Holder( view );
        view.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewItemClick.recyclerViewItemClick( view1Holder.getAdapterPosition(), view, view1Holder );
            }
        } );
        return view1Holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((View1Holder)holder).textView.setText( data.get( position ).getName() );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class View1Holder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public View1Holder(View itemView) {
            super( itemView );
            textView = itemView.findViewById( R.id.tv_left_name );
        }
    }
    public RecyclerViewItemClick recyclerViewItemClick;

    public interface RecyclerViewItemClick {
        void recyclerViewItemClick(int position, View view, RecyclerView.ViewHolder viewHolder);
    }

    public void setRecyclerViewItemClick(RecyclerViewItemClick recyclerViewItemClick) {
        this.recyclerViewItemClick = recyclerViewItemClick;
    }
}
