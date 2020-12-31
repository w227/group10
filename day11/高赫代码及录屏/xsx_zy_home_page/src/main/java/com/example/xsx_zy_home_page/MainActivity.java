package com.example.xsx_zy_home_page;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xsx_zy_home_page.adapter.MyAdapter;
import com.example.xsx_zy_home_page.bean.HaiBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView img_show;
    private TextView tv_bibei;
    private RecyclerView rec_hai;
    private MyAdapter myAdapter;
    private List<HaiBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        img_show = (ImageView) findViewById(R.id.img_show);
        tv_bibei = (TextView) findViewById(R.id.tv_bibei);
        rec_hai = (RecyclerView) findViewById(R.id.rec_hai);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        rec_hai.setLayoutManager(manager);
        list = new ArrayList<>();
        list.add(new HaiBean(R.drawable.ba1));
        list.add(new HaiBean(R.drawable.fan));
        list.add(new HaiBean(R.drawable.mo1));
        myAdapter = new MyAdapter(this, list);
        rec_hai.setAdapter(myAdapter);

    }
}
