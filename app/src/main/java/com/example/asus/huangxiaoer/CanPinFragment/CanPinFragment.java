package com.example.asus.huangxiaoer.CanPinFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.huangxiaoer.Iview.IMDianCaiActivity;
import com.example.asus.huangxiaoer.Iview.IMDianCairightActivity;
import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.adapter.MyLeftAdapter;
import com.example.asus.huangxiaoer.adapter.MyRightAdapter;
import com.example.asus.huangxiaoer.bean.DianCaiBean;
import com.example.asus.huangxiaoer.presenter.DianCaiPresenter;
import com.example.asus.huangxiaoer.presenter.DianCairightPresenter;

import java.util.List;

/**
 * author:Created by gengtianbo on 2018/7/9.
 */
public class CanPinFragment extends Fragment implements IMDianCaiActivity, IMDianCairightActivity {

    private RecyclerView left, right;
    private DianCairightPresenter presenter1;
    private DianCaiPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.canpin_fragment, container, false );
        presenter = new DianCaiPresenter( this );
        presenter.getUrl();
        presenter1 = new DianCairightPresenter( this );
        presenter1.getUrl( 1089 + "" );
        left = view.findViewById( R.id.left );
        left.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        right = view.findViewById( R.id.right );
        right.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        return view;
    }


    @Override
    public void diancai(DianCaiBean bean) {
        final List<DianCaiBean.DataBean> data = bean.getData();
        MyLeftAdapter adapter = new MyLeftAdapter( data, getActivity() );
        left.setAdapter( adapter );
        adapter.setRecyclerViewItemClick( new MyLeftAdapter.RecyclerViewItemClick() {
            @Override
            public void recyclerViewItemClick(int position, View view, RecyclerView.ViewHolder viewHolder) {
                int id = data.get( position ).getId();
                presenter1.getUrl( id + "" );
            }
        } );
    }

    @Override
    public void right(DianCaiBean bean) {
        List<DianCaiBean.DataBean> data = bean.getData();
        MyRightAdapter adapter = new MyRightAdapter( data, getActivity() );
        right.setAdapter( adapter );
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter1.data();
        presenter.data();
    }
}
