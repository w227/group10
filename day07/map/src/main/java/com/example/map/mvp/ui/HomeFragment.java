package com.example.map.mvp.ui;

import android.widget.TextView;

import com.example.map.mvp.presenter.HomePerten;
import com.example.map.R;
import com.example.map.base.BaseFragment;
import com.example.map.base.BasePresenter;

import butterknife.BindView;

public class HomeFragment extends BaseFragment {
    @BindView(R.id.tv)
    TextView tv;


    protected BasePresenter createPresenter(){
        return new HomePerten(this);
    }

    @Override
    protected BasePresenter createPerten() {
        return null;
    }

    @Override
    protected void initData() {

//        V 层向P 层发送请求数据的指令

    }




    @Override
    protected void initView() {



    }



    @Override
    protected int LayoutId() {
        return R.layout.fragment_home;
    }
}
