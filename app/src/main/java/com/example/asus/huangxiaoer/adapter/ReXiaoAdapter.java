package com.example.asus.huangxiaoer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.bean.ReXiaoBean;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * author:Created by gengtianbo on 2018/7/9.
 */
public class ReXiaoAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {

    List<ReXiaoBean.DataBean.BannerBean> banner;
    Context context;
    static final int one = 1;
    static final int two = 2;
    ReXiaoBean bean;

    public ReXiaoAdapter(List<ReXiaoBean.DataBean.BannerBean> banner, Context context, ReXiaoBean bean) {
        this.banner = banner;
        this.context = context;
        this.bean = bean;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType) {
            case one:
                View view = LayoutInflater.from( context ).inflate( R.layout.item_rexiao_tou, null );
                View1Holder view1Holder = new View1Holder( view );
                return view1Holder;
            case two:
                View view1 = LayoutInflater.from( context ).inflate( R.layout.item_rexiao, null );
                View2Holder view2Holder = new View2Holder( view1 );
                return view2Holder;

        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        if (holder instanceof View1Holder) {
//            Glide.with( context ).load( R.drawable.ad1).into( ((View1Holder) holder).vimage_rexiao_tou );
        }
        if (holder instanceof View2Holder) {
            List<ReXiaoBean.DataBean.TuijianBean.ListBeanX> list = bean.getData().getTuijian().getList();
            ((View2Holder) holder).recyclerView.setLayoutManager( new GridLayoutManager( context, 2 ) );
            ReXiaoZiAdapter adapter = new ReXiaoZiAdapter( list, context );
            ((View2Holder) holder).recyclerView.setAdapter( adapter );
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return one;

        }
        if (position == 1) {
            return two;
        }
        return 0;
    }

    @Override
    public int getItemCount() {
        return banner.size();
    }

    class View1Holder extends XRecyclerView.ViewHolder {

        private final ImageView vimage_rexiao_tou;

        public View1Holder(View itemView) {
            super( itemView );
            vimage_rexiao_tou = itemView.findViewById( R.id.image_rexiao_tou );
        }
    }

    class View2Holder extends XRecyclerView.ViewHolder {


        private final RecyclerView recyclerView;

        public View2Holder(View itemView) {
            super( itemView );
            recyclerView = itemView.findViewById( R.id.recycler );
        }
    }
}
