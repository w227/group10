package com.example.day09.mvp.ui.activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.base.BaseActivity;
import com.example.day09.base.BasePresenter;
import com.example.day09.manager.ContainManager;
import com.example.day09.manager.ThreadPoolManager;
import com.example.day09.mvp.ui.fragment.HomeFragment;
import com.example.day09.mvp.ui.fragment.MyFragment;
import com.example.day09.mvp.ui.fragment.CourseFragment;
import com.example.day09.mvp.ui.fragment.StudyFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;

public class UniteActivity extends BaseActivity {
    @BindView(R.id.fl_act)
    FrameLayout flAct;
    @BindView(R.id.tl_act)
    TabLayout tlAct;
    @BindView(R.id.tb_home_frg)
    Toolbar tbHomeFrg;
    private HomeFragment homeFragment;
    private CourseFragment xuanFragment;
    private StudyFragment xueFragment;
    private MyFragment myFragment;
    private FragmentTransaction transaction;

    private boolean mIsExit;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void init() {


        setSupportActionBar(tbHomeFrg);
        tbHomeFrg.setNavigationIcon(R.drawable.services);
        tbHomeFrg.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(App.context(),ConsultActivity.class));
            }
        });
        homeFragment = new HomeFragment();
        xuanFragment = new CourseFragment();
        xueFragment = new StudyFragment();
        myFragment = new MyFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fl_act, homeFragment)
                .add(R.id.fl_act, xuanFragment)
                .add(R.id.fl_act, xueFragment)
                .add(R.id.fl_act, myFragment)
                .hide(xuanFragment)
                .hide(xueFragment)
                .hide(myFragment)
                .commit();

        tlAct.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:
                        getSupportFragmentManager().beginTransaction().show(homeFragment)
                                .hide(xuanFragment)
                                .hide(xueFragment)
                                .hide(myFragment)
                                .commit();

                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .show(xuanFragment)
                                .hide(homeFragment)
                                .hide(xueFragment)
                                .hide(myFragment)
                                .commit();

                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .show(xueFragment)
                                .hide(homeFragment)
                                .hide(xuanFragment)
                                .hide(myFragment)
                                .commit();


                        break;
                    case 3:
                        getSupportFragmentManager().beginTransaction()
                                .show(myFragment)
                                .hide(homeFragment)
                                .hide(xueFragment)
                                .hide(xuanFragment)
                                .commit();

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

        tlAct.addTab(tlAct.newTab().setIcon(R.drawable.select1).setText("首页"));
        tlAct.addTab(tlAct.newTab().setIcon(R.drawable.select2).setText("选课"));
        tlAct.addTab(tlAct.newTab().setIcon(R.drawable.select3).setText("学习"));
        tlAct.addTab(tlAct.newTab().setIcon(R.drawable.select4).setText("我的"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
                startActivity(new Intent(App.context(),SeekActivity.class));
                break;
            case R.id.menu2:
                startActivity(new Intent(App.context(),SeekActivity.class));
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    //监听返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //TODO  2秒内连续点击两次 退出程序，  如果第二次点击超过2秒了，会Toast提示再按一次退出程序
            if (!mIsExit) {
                mIsExit = true;
                Toast.makeText(App.context(), "再按一次退出程序", Toast.LENGTH_LONG).show();
                //2秒之后把变量值改成true
                ThreadPoolManager.
                        getThreadPool(ThreadPoolManager.SCHDULE_THREADPOOL).
                        executeTimerTask(new Runnable() {
                            @Override
                            public void run() {
                                mIsExit = false;
                            }
                        }, 2, TimeUnit.SECONDS);
            } else {
                ContainManager.getmManager().clearActivity();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.zong_activity;
    }


}
