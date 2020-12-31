package com.example.mvp.mvp.ui.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp.R;
import com.example.mvp.apader.MyApader;
import com.example.mvp.base.BaseActivity;
import com.example.mvp.base.BasePresenter;
import com.example.mvp.bean.ListBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {
    @BindView(R.id.rec)
    RecyclerView rec;
    private boolean mIsExit;

    @Override
    protected void init() {
        List<ListBean> listBeans=new ArrayList<> (  );
        listBeans.add ( new ListBean ( R.drawable.ba1 ) );
        listBeans.add ( new ListBean ( R.drawable.deng ) );
        listBeans.add ( new ListBean ( R.drawable.deng1 ) );
        listBeans.add ( new ListBean ( R.drawable.fan ) );
        listBeans.add ( new ListBean ( R.drawable.gu ) );
        listBeans.add ( new ListBean ( R.drawable.kuan ) );
        listBeans.add ( new ListBean ( R.drawable.kuan1 ) );

        rec.setLayoutManager ( new LinearLayoutManager ( this ) );
        MyApader myApader = new MyApader (this,listBeans);
        rec.setAdapter ( myApader );


    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }



}
