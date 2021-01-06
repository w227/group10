package com.example.day09.mvp.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.day09.R;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;

public class SeekActivity extends BaseActivity {


    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_seek;
    }
}
