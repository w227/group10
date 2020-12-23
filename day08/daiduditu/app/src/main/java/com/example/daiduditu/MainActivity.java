package com.example.daiduditu;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;

import androidx.annotation.NonNull;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

public class MainActivity extends Activity {

    private MapView mMapView = null;
    private RadioButton pu;
    private RadioButton wei;
    private RadioButton lu;
    private RadioButton bai;
    private BaiduMap mMap;
    private LocationClient mLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);

        mMap = mMapView.getMap();
        mMap.setMyLocationEnabled(true);


        //定位初始化
        mLocationClient = new LocationClient(this);

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);

//设置locationClientOption
        mLocationClient.setLocOption(option);

//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
//开启地图定位图层
        mLocationClient.start();
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mMap.setMyLocationData(locData);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();

        mLocationClient.stop();
        mMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }


    private void initView() {
        pu = (RadioButton) findViewById(R.id.pu);
        wei = (RadioButton) findViewById(R.id.wei);
        lu = (RadioButton) findViewById(R.id.lu);
        bai = (RadioButton) findViewById(R.id.bai);

        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        }, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION});

    }



//    @Override
//    public void onClick(View v) {
//        cleanMap();
//        switch (v.getId()) {
//            case R.id.pu:
//                map.setMapType(BaiduMap.MAP_TYPE_NONE);
//
//                break;
//               case R.id.wei:
//                   map.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
//                   break;
//               case R.id.lu:
//                   map.setTrafficEnabled(true);
//
//                break;
//               case R.id.bai:
//                   map.setMapType(BaiduMap.MAP_TYPE_NONE);
//
//                break;
//
//
//        }
//    }
//
//    private void cleanMap() {
//        map.setMapType(BaiduMap.MAP_TYPE_NONE);
//        map.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
//        map.setTrafficEnabled(true);
//        map.setMapType(BaiduMap.MAP_TYPE_NONE);
//
//    }
}
