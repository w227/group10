package com.example.day09.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day09.R;
import com.example.day09.manager.ThreadPoolManager;

import java.util.concurrent.TimeUnit;

public class HomeActivity extends AppCompatActivity{


    private Button ok;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        init();
    }

    private void init() {


        ThreadPoolManager.getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL)
                .executeTimerTask(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(HomeActivity.this,ViewActivity.class));
                    }
                },2, TimeUnit.SECONDS);
    }




}