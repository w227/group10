package com.example.map.mvp.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.map.R;
import com.example.map.base.App;
import com.example.map.base.BaseActivity;
import com.example.map.base.BasePresenter;
import com.example.map.engine.adapter.VpApret;
import com.example.map.manager.ContainManager;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tl)
    TabLayout tl;
    private boolean mEt;

    private Handler handler = new Handler();

    @Override
    protected BasePresenter createPersenter() {


        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new HomeYeFragment());
        list.add(new FaFragment());
        list.add(new PickFragment());
        list.add(new ShangFragment());
        list.add(new MyFragment());

        VpApret vpApret = new VpApret(getSupportFragmentManager(),list);
        vp.setAdapter(vpApret);
        tl.setupWithViewPager(vp);
        tl.getTabAt(0).setIcon(R.drawable.d).setText(R.string.home);
        tl.getTabAt(1).setIcon(R.drawable.c).setText(R.string.fa);
        tl.getTabAt(2).setIcon(R.drawable.a);
        tl.getTabAt(3).setIcon(R.drawable.b).setText(R.string.shang);
        tl.getTabAt(4).setIcon(R.drawable.a).setText(R.string.me);
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }

//    监听返回键

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!mEt) {
                mEt = true;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mEt = false;
                    }
                }, 2000);
            } else {
                ContainManager.manager().clearActivity();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
