package com.example.dp7_12_18_zy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dp7_12_18_zy.model.bean.DataInfo2;
import com.example.dp7_12_18_zy.view.Viem;

import java.util.ArrayList;
import java.util.List;

public class AssociationActivity extends AppCompatActivity implements View.OnClickListener, Viem {

    /**
     * 返回
     */
    private Button mTbBtn;
    /**
     * 社团
     */
    private TextView mTbTxt;
    /**
     * 我的社团
     */
    private TextView mTbTxt2;
    /**
     * 搜索
     */
    private EditText mAocEt;
    private ImageView mAocImg;
    /**
     * 我的社团
     */
    private TextView mAocTxt;
    private RecyclerView mAocRel;
    private ArrayList<DataInfo2.DataBean.ListBean> mBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_association);
        initView();
        initData();
    }

    private void initData() {
        AocPresenter aocPresenter = new AocPresenter(this);
        aocPresenter.start();
    }

    private void initView() {
        mTbBtn = (Button) findViewById(R.id.tb_btn);
        mTbBtn.setOnClickListener(this);
        mTbTxt = (TextView) findViewById(R.id.tb_txt);
        mTbTxt2 = (TextView) findViewById(R.id.tb_txt2);
        mAocEt = (EditText) findViewById(R.id.aoc_et);
        mAocImg = (ImageView) findViewById(R.id.aoc_img);
        mAocTxt = (TextView) findViewById(R.id.aoc_txt);
        mAocRel = (RecyclerView) findViewById(R.id.aoc_rel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.tb_btn:
                finish();
                break;
        }
    }

    @Override
    public void showSucess(Object object) {
        if (object instanceof DataInfo2){
            DataInfo2 info2=(DataInfo2)object;
            List<DataInfo2.DataBean.ListBean> list = info2.getData().getList();
            mBean = new ArrayList<>();
            mBean.addAll(list);
            AocAdpter aocAdpter = new AocAdpter(mBean,this);
            mAocRel.setAdapter(aocAdpter);
            mAocRel.setLayoutManager(new LinearLayoutManager(this));
            mAocRel.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
            aocAdpter.notifyDataSetChanged();
        }
    }

    @Override
    public void showFaile(String msg) {

    }
}
