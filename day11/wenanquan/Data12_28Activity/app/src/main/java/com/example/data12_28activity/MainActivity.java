package com.example.data12_28activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.data12_28activity.adapter.HomeRvGuoAdapter;
import com.example.data12_28activity.adapter.HomeRvHaiAdapter;
import com.example.data12_28activity.bean.GuoBean;
import com.example.data12_28activity.bean.HaiBean;
import com.example.data12_28activity.necessary.LocalBroadcastManager;
import com.example.data12_28activity.utils.DeviceUtil;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jpush.android.api.JPushInterface;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;
    @BindView(R.id.banner_main)
    Banner bannerMain;
    @BindView(R.id.rv_hai)
    RecyclerView rvHai;
    @BindView(R.id.rv_guo)
    RecyclerView rvGuo;
    @BindView(R.id.cl_guo)
    ConstraintLayout clGuo;




    //for receive customer msg from jpush server
    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "cn.jiguang.demo.jpush.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    public static boolean isForeground = false;
    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);

        registerMessageReceiver();  // used for receive msg

        init();

        initView();

        initData();
    }

    private void initData() {


        List<String> bannerList = new ArrayList<>();
        bannerList.add("https://wanandroid.com/blogimgs/45251caf-79aa-4a35-89e1-99a5454a21aa.png");
        bannerList.add("https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png");
        bannerList.add("https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png");

        bannerMain.setImages(bannerList).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                String url = (String) path;
                Glide.with(context).load(url).into(imageView);
            }
        }).start();


        haiData();
        guoData();


    }

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver, filter);
    }

    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private void init() {
        JPushInterface.init(getApplicationContext());
    }

    private void initView() {
        //获取Apk
        String appKey = DeviceUtil.getAppKey(getApplicationContext());

        //获取包名
        String packageName = getPackageName();

        //获取deviceId
        String deviceId = DeviceUtil.getDeviceId(getApplicationContext());

        Log.e(TAG, "initView: " + "deviceId" + deviceId);

        toolbarMain.setTitle(" ");
        setSupportActionBar(toolbarMain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void guoData() {
        ArrayList<GuoBean> guolist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            guolist.add(new GuoBean(R.drawable.iv_guo, "大理 DALI"));
        }
        rvGuo.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        HomeRvGuoAdapter guoAdapter = new HomeRvGuoAdapter(guolist, this);
        rvGuo.setAdapter(guoAdapter);
    }

    private void haiData() {
        ArrayList<HaiBean> haiBeans = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            haiBeans.add(new HaiBean(R.drawable.iv_hai));
        }
        rvHai.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        HomeRvHaiAdapter haiAdapter = new HomeRvHaiAdapter(haiBeans, this);
        rvHai.setAdapter(haiAdapter);
    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
        if (mBind != null) {
            mBind.unbind();
        }
        super.onDestroy();
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                    String messge = intent.getStringExtra(KEY_MESSAGE);
                    String extras = intent.getStringExtra(KEY_EXTRAS);
                    StringBuilder showMsg = new StringBuilder();
                    showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                    if (!DeviceUtil.isEmpty(extras)) {
                        showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                    }
                    Log.e(TAG, "onReceive: " + showMsg.toString());
                }
            } catch (Exception e) {
            }
        }
    }

}