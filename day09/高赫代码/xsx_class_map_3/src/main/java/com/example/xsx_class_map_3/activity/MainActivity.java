package com.example.xsx_class_map_3.activity;

import android.Manifest;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.example.xsx_class_map_3.R;
import com.example.xsx_class_map_3.fragment.NavFragment;
import com.example.xsx_class_map_3.fragment.PoiFragment;
import com.example.xsx_class_map_3.fragment.RouteFragment;
import com.example.xsx_class_map_3.fragment.ShowMapFragment;
import com.example.xsx_class_map_3.fragment.SuggestFragment;
import com.example.xsx_class_map_3.fragment.WeiFragment;
import com.example.xsx_class_map_3.overlayutil.DrivingRouteOverlay;
import com.example.xsx_class_map_3.overlayutil.WalkingRouteOverlay;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.baidu.mapapi.BMapManager.init;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;

    private static final String TAG = "MainActivity";
    private List<Fragment> fragments;
    private ShowMapFragment showMapFragment;
    private WeiFragment weiFragment;
    private PoiFragment poiFragment;
    private SuggestFragment suggestFragment;
    private RouteFragment routeFragment;
    private NavFragment navFragment;
    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        showMapFragment = new ShowMapFragment();
        weiFragment = new WeiFragment();
        poiFragment = new PoiFragment();
        suggestFragment = new SuggestFragment();
        routeFragment = new RouteFragment();
        navFragment = new NavFragment();

        fragments.add(showMapFragment);
        fragments.add(weiFragment);
        fragments.add(poiFragment);
        fragments.add(suggestFragment);
        fragments.add(routeFragment);
        fragments.add(navFragment);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("显示地图");
        tab.getTabAt(1).setText("显示定位");
        tab.getTabAt(2).setText("poi搜索");
        tab.getTabAt(3).setText("地点输入提示搜索");
        tab.getTabAt(4).setText("路线规划");
        tab.getTabAt(5).setText("导航");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
