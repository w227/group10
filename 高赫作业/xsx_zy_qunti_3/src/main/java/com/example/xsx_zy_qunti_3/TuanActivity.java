package com.example.xsx_zy_qunti_3;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xsx_zy_qunti_3.adapter.RecTuanAdapter;
import com.example.xsx_zy_qunti_3.bean.TuanBean;
import com.example.xsx_zy_qunti_3.mvp.presenter.FindPresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TuanActivity extends AppCompatActivity implements IView{

    private TextView tv_toolbar_tuan;
    private Toolbar toolbar_tuan;
    private RecyclerView rec_tuan;
    private RecTuanAdapter recTuanAdapter;
    private List<TuanBean.DataBean.ListBean> tList = new ArrayList<>();
    private static final String TAG = "TuanActivity";
    private FindPresenter findPresenter = new FindPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan);
        initView();
        initData();
    }

    private void initData() {
        Log.e(TAG, "initData: "+"====" );
        findPresenter.startTuan();
    }


    private void initView() {
        tv_toolbar_tuan = (TextView) findViewById(R.id.tv_toolbar_tuan);
        toolbar_tuan = (Toolbar) findViewById(R.id.toolbar_tuan);
        rec_tuan = (RecyclerView) findViewById(R.id.rec_tuan);
        rec_tuan.setLayoutManager(new LinearLayoutManager(this));
        rec_tuan.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recTuanAdapter = new RecTuanAdapter(this, tList);
        rec_tuan.setAdapter(recTuanAdapter);
    }

    @Override
    public void getSuccessData(Object object) {
        Log.e(TAG, "getSuccessData: "+"====" );
        if(object instanceof TuanBean){
            TuanBean tuanBean = (TuanBean) object;
            List<TuanBean.DataBean.ListBean> list = tuanBean.getData().getList();
            Log.e(TAG, "onNext: "+list.size());
            tList.addAll(list);
            recTuanAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getFaileMeg(String meg) {
        Log.e(TAG, "onError: "+meg );
    }
}
