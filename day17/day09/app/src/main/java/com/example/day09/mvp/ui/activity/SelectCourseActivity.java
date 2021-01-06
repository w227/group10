package com.example.day09.mvp.ui.activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;
import com.example.day09.mvp.presenter.SelCourseActPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectCourseActivity extends BaseActivity {
    @BindView(R.id.tb_course_frg)
    Toolbar tbCourseFrg;
    @BindView(R.id.choose_rv)
    RecyclerView chooseRv;
    @BindView(R.id.btn_choose)
    Button btnChoose;

    @Override
    protected BasePresenter createPresenter() {
        return new SelCourseActPresenter(this);
    }

    @Override
    protected void init() {

        chooseRv.setLayoutManager(new LinearLayoutManager(App.context()));

    }

    @Override
    protected void initData() {
        super.initData();
        getmPresenter().start();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_select_course;
    }

}
