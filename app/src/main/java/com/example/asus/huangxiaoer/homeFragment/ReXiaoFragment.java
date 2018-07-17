package com.example.asus.huangxiaoer.homeFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.huangxiaoer.Iview.IMReXiaoActivity;
import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.adapter.ReXiaoAdapter;
import com.example.asus.huangxiaoer.bean.ReXiaoBean;
import com.example.asus.huangxiaoer.presenter.ReXiaoPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * author:Created by gengtianbo on 2018/7/9.
 */
public class ReXiaoFragment extends Fragment implements IMReXiaoActivity {

    private XRecyclerView xRecyclerView;
    private ReXiaoPresenter presenter;

    int anInt = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate( R.layout.rexiao_fragment, container, false );


        xRecyclerView = inflate.findViewById( R.id.xrecycler );
        xRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        presenter = new ReXiaoPresenter( this );
        presenter.getUrl();
        return inflate;
    }

    @Override
    public void rexiao(ReXiaoBean bean) {
        List<ReXiaoBean.DataBean.BannerBean> banner = bean.getData().getBanner();
        final ReXiaoAdapter adapter = new ReXiaoAdapter( banner, getActivity(), bean );
        xRecyclerView.setAdapter( adapter );
        xRecyclerView.setPullRefreshEnabled( true );
        xRecyclerView.setLoadingMoreEnabled( false );
        xRecyclerView.setLoadingListener( new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                anInt = 1;
                xRecyclerView.refreshComplete();
                presenter.getUrl();
            }

            @Override
            public void onLoadMore() {
                anInt++;
                xRecyclerView.loadMoreComplete();
                presenter.getUrl();
            }
        } );
    }
}
