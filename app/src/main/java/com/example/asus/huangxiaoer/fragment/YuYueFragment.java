package com.example.asus.huangxiaoer.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.asus.huangxiaoer.R;
import com.example.asus.huangxiaoer.adapter.MyYuYueAdpter;
import com.example.asus.huangxiaoer.bean.DianPuBean;
import com.example.asus.huangxiaoer.utils.RetrofitUtils2;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author:Created by gengtianbo on 2018/7/6.
 */
public class YuYueFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.yuyuefragment, container, false );

        EditText editText = view.findViewById( R.id.edit_sou );
        final XRecyclerView xRecyclerView = view.findViewById(  R.id.xrecycler );
        xRecyclerView.setLayoutManager( new LinearLayoutManager( getActivity() ) );
        xRecyclerView.setPullRefreshEnabled( true  );
        xRecyclerView.setLoadingMoreEnabled( false );
        Observable<DianPuBean> dianPuBean = RetrofitUtils2.getRetrofitUtils().getApi().getDianPuBean();
        dianPuBean.subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread())
                .subscribe( new Observer<DianPuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DianPuBean value) {
                        List<DianPuBean.DataBean> data = value.getData();
                        MyYuYueAdpter adpter = new MyYuYueAdpter( data,getActivity() );
                        xRecyclerView.setAdapter( adpter );
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                } );
        return view;
    }
}
