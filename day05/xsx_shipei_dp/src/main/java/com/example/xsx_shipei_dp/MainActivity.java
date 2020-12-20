package com.example.xsx_shipei_dp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xsx_shipei_dp.adapter.RecDushiAdapter;
import com.example.xsx_shipei_dp.adapter.RecShirenAdapter;
import com.example.xsx_shipei_dp.bean.ShirenBean;
import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabItem tabs_one;
    private TabItem tabs_two;
    private TabItem tabs_three;
    private TabItem tabs_four;
    private SearchView search_view;
    private RecyclerView rec_shiren;
    private RecyclerView rec_dushi;
    private RecyclerView rec_jiaju;
    private RecyclerView rec_jiazuo;
    private TabItem tabs_five;
    private RecShirenAdapter recShirenAdapter;
    private List<ShirenBean> list = new ArrayList<>();
    private static final String TAG = "MainActivity";
    private RecDushiAdapter recDushiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }


    private void initView() {

        tabs_one = (TabItem) findViewById(R.id.tabs_one);
        tabs_two = (TabItem) findViewById(R.id.tabs_two);
        tabs_three = (TabItem) findViewById(R.id.tabs_three);
        tabs_four = (TabItem) findViewById(R.id.tabs_four);
        search_view = (SearchView) findViewById(R.id.search_view);

        rec_shiren = (RecyclerView) findViewById(R.id.rec_shiren);
        rec_dushi = (RecyclerView) findViewById(R.id.rec_dushi);
        rec_jiaju = (RecyclerView) findViewById(R.id.rec_jiaju);
        rec_jiazuo = (RecyclerView) findViewById(R.id.rec_jiazuo);
        tabs_five = (TabItem) findViewById(R.id.tabs_five);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        rec_shiren.setLayoutManager(manager);
        list.add(new ShirenBean("露易丝；格里克","2020年获诺贝尔文学奖",R.drawable.gong));
        list.add(new ShirenBean("托马斯；爱迪生","2011年获诺贝尔文学奖",R.drawable.shu));
        list.add(new ShirenBean("泰戈尔","1968年获诺贝尔文学奖",R.drawable.sou));
        list.add(new ShirenBean("露易丝；格里克","2020年获诺贝尔文学奖",R.drawable.gong));
        list.add(new ShirenBean("托马斯；爱迪生","2011年获诺贝尔文学奖",R.drawable.shu));
        list.add(new ShirenBean("泰戈尔","1968年获诺贝尔文学奖",R.drawable.sou));
        Log.e(TAG, "initView: "+list.size() );
        recShirenAdapter = new RecShirenAdapter(this,list);
        rec_shiren.setAdapter(recShirenAdapter);
        recShirenAdapter.notifyDataSetChanged();
        rec_dushi.setLayoutManager(new LinearLayoutManager(this));

        recDushiAdapter = new RecDushiAdapter();
        rec_dushi.setAdapter(recDushiAdapter);
    }
}
