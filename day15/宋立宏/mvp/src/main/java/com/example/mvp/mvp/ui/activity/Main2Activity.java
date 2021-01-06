package com.example.mvp.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mvp.R;
import com.example.mvp.apader.HomeVpApader;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ViewPager vp;
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        List<View> list=new ArrayList<>();
        View shouye = LayoutInflater.from(this).inflate(R.layout.shouye, null, false);
        View zhibo = LayoutInflater.from(this).inflate(R.layout.zhibo, null, false);
        View wode = LayoutInflater.from(this).inflate(R.layout.wode , null, false);
        list.add(shouye);
        list.add(zhibo);
        list.add(wode);

        bt1 = wode.findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,Home1Activity.class));

            }
        });
        HomeVpApader homeVpApader = new HomeVpApader(this,list);
        vp.setAdapter(homeVpApader);


    }
}
