package com.example.demo_mvp_2.mvp.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.example.demo_mvp_2.R;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.Unbinder;

public class BaiduMapActivity extends AppCompatActivity {

    private static final String TAG = BaiduMapActivity.class.getSimpleName();

    private MapView mMapView = null;

    //百度地图的数据操作
    private BaiduMap mBaiduMap;
    //百度地图定位的类
    private LocationClient mLocationClient;
    private RadioButton map_tb1;
    private RadioButton map_tb2;
    private RadioButton map_tb3;
    private RadioButton map_tb4;
    private RadioGroup baidu_map_rg;
    private Unbinder mBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_map);
        mBind = ButterKnife.bind(this);

        initView();

        initPermissions();
    }

    private void initPermissions() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {
                initMap();
            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {
                Toast.makeText(BaiduMapActivity.this, "用户拒绝授权", Toast.LENGTH_SHORT).show();
            }
        }, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION});
    }

    /**
     * 初始化地图
     */
    private void initMap() {
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);

        mBaiduMap = mMapView.getMap();

        //设置为普通类型的地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
    }


    private void initView() {
        map_tb1 = (RadioButton) findViewById(R.id.map_tb1);
        map_tb2 = (RadioButton) findViewById(R.id.map_tb2);
        map_tb3 = (RadioButton) findViewById(R.id.map_tb3);
        map_tb4 = (RadioButton) findViewById(R.id.map_tb4);
        baidu_map_rg = (RadioGroup) findViewById(R.id.baidu_map_rg);

//        //lambda表达式
//        map_tb1.setOnCheckedChangeListener((buttonView, isChecked) -> {
//
//        });
    }

    @OnCheckedChanged({R.id.map_tb1, R.id.map_tb2, R.id.map_tb3, R.id.map_tb4})
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        switch (button.getId()) {
            case R.id.map_tb1:
                //普通地图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.map_tb2:
                //卫星图
                mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.map_tb3:
                //交通图
                if (mBaiduMap.isTrafficEnabled()) {
                    mBaiduMap.setTrafficEnabled(false);
                } else {
                    mBaiduMap.setTrafficEnabled(true);
                    mBaiduMap.setCustomTrafficColor("#ffba0101", "#fff33131", "#ffff9e19", "#00000000");
                    //  对地图状态做更新，否则可能不会触发渲染，造成样式定义无法立即生效。
                    MapStatusUpdate u = MapStatusUpdateFactory.zoomTo(13);
                    mBaiduMap.animateMapStatus(u);
                }
                break;
            case R.id.map_tb4:
                //热力图
                if (mBaiduMap.isBaiduHeatMapEnabled()) {
                    mBaiduMap.setBaiduHeatMapEnabled(false);
                } else {
                    mBaiduMap.setBaiduHeatMapEnabled(true);
                }
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        if (mMapView != null) {
            mMapView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        if (mMapView != null) {
            mMapView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLocationClient != null) {
            mLocationClient.stop();
        }
        if (mMapView != null) {
            mMapView.onDestroy();
            mMapView = null;
            //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        }
        if (mBind != null) {
            mBind.unbind();
        }


    }
}