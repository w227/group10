package com.example.a12_19_zy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SearchView mSearch;
    private ImageView mImg2;
    private TabLayout mTab;
    /**
     * 诗歌群PK
     */
    private TextView mTxt;
    /**
     * 事件
     */
    private TextView mTxt2;
    private ImageView mImg3;
    /**
     * 丁香诗社
     */
    private Button mBtn;
    /**
     * 月季诗社
     */
    private Button mBtn2;
    /**
     * 这两个社团你跟看好谁
     */
    private TextView mTxt3;
    /**
     * 荣誉诗人
     */
    private TextView mTxt4;
    private RecyclerView mRel;
    /**
     * 一起读诗
     */
    private TextView mTxt5;
    private RecyclerView mRel2;
    /**
     * 诗词佳句
     */
    private TextView mTxt6;
    private RecyclerView mRel3;
    /**
     * 每周佳作
     */
    private TextView mTxt7;
    private RecyclerView mRel4;
    private ArrayList<String> mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mSearch = (SearchView) findViewById(R.id.search);
        mImg2 = (ImageView) findViewById(R.id.img2);
        mTab = (TabLayout) findViewById(R.id.tab);
        mTxt = (TextView) findViewById(R.id.txt);
        mTxt2 = (TextView) findViewById(R.id.txt2);
        mImg3 = (ImageView) findViewById(R.id.img3);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
        mBtn2 = (Button) findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mTxt3 = (TextView) findViewById(R.id.txt3);
        mTxt4 = (TextView) findViewById(R.id.txt4);
        mRel = (RecyclerView) findViewById(R.id.rel);
        mTxt5 = (TextView) findViewById(R.id.txt5);
        mRel2 = (RecyclerView) findViewById(R.id.rel2);
        mTxt6 = (TextView) findViewById(R.id.txt6);
        mRel3 = (RecyclerView) findViewById(R.id.rel3);
        mTxt7 = (TextView) findViewById(R.id.txt7);
        mRel4 = (RecyclerView) findViewById(R.id.rel4);

        mTab.addTab(mTab.newTab().setText("每日推荐").setIcon(R.mipmap.qei1));
        mTab.addTab(mTab.newTab().setText("飞花令").setIcon(R.mipmap.pei2));
        mTab.addTab(mTab.newTab().setText("诗歌社群").setIcon(R.mipmap.pei3));
        mTab.addTab(mTab.newTab().setText("排行榜").setIcon(R.mipmap.pei4));
        mTab.addTab(mTab.newTab().setText("会员专区").setIcon(R.mipmap.pei5));
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        Toast.makeText(MainActivity.this, "点击了 每日推荐", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "点击了 飞花令", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "点击了 诗歌社群", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "点击了 排行榜", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "点击了 会员专区", Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mRel.setLayoutManager(new GridLayoutManager(this,2));
        mBean = new ArrayList<>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn:
                break;
            case R.id.btn2:
                break;
        }
    }
}
