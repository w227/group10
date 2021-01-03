package com.example.day09.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.manager.ContainManager;
import com.example.day09.manager.ThreadPoolManager;
import com.example.day09.thread.SpUtils;

import java.util.concurrent.TimeUnit;

public class HomeActivity extends AppCompatActivity {


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
                        Boolean user = SpUtils.getInstance().getBoolean("user");
                        if (user) {
                            startActivity(new Intent(App.context(), UniteActivity.class));
                            finish();
                        } else {
                            startActivity(new Intent(App.context(), ViewActivity.class));
                            finish();
                            SpUtils.getInstance().setValue("user", true);

                        }
                    }
                }, 2, TimeUnit.SECONDS);
    }

}