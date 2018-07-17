package com.example.asus.huangxiaoer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
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
public class MyRightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    List<DianCaiBean.DataBean> data;
    Context context;
    private MyRightZiAdapter adapter;

    public MyRightAdapter(List<DianCaiBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( context ).inflate( R.layout.item_right, null );
        return new View1Holder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((View1Holder) holder).tv_right_name.setText( data.get( position ).getName() );
        List<DianCaiBean.DataBean.SpusBean> spus = data.get( position ).getSpus();
        adapter = new MyRightZiAdapter( spus, context );
        ((View1Holder) holder).recyclerView.setLayoutManager( new LinearLayoutManager( context ) );
        ((View1Holder) holder).recyclerView.setAdapter( adapter );
    }

    @Override
    public int getItemCount() {
        return data.size();
    }







    class View1Holder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;
        private final TextView tv_right_name;

        public View1Holder(View itemView) {
            super( itemView );

            tv_right_name = itemView.findViewById( R.id.tv_right_name );
            recyclerView = itemView.findViewById( R.id.recycler );

        }
    }
}
