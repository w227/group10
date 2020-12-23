package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MapView mmap;
    private LocationClient locationClient;
    private BaiduMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        mmap = findViewById ( R.id.ma );
        map = mmap.getMap ();
        map.setMapType ( BaiduMap.MAP_TYPE_SATELLITE );
        //定位初始化
        map.setMyLocationEnabled ( true );

        locationClient = new LocationClient ( this );

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption ();
        option.setOpenGps ( true ); // 打开gps
        option.setCoorType ( "bd09ll" ); // 设置坐标类型
        option.setScanSpan ( 1000 );

//设置locationClientOption
        locationClient.setLocOption ( option );

//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener ();
        locationClient.registerLocationListener ( myLocationListener );
//开启地图定位图层
        locationClient.start ();


    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || mmap == null) {
                return;
            }
            MyLocationData locData = new MyLocationData.Builder ()
                    .accuracy ( location.getRadius () )
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction ( location.getDirection () ).latitude ( location.getLatitude () )
                    .longitude ( location.getLongitude () ).build ();
            map.setMyLocationData ( locData );
        }
    }


    @Override
    protected void onResume() {
        super.onResume ();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mmap.onResume ();
    }

    @Override
    protected void onPause() {
        super.onPause ();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mmap.onPause ();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mmap.onDestroy ();
    }
}



