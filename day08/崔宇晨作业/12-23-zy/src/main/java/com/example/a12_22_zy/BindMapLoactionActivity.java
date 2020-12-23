package com.example.a12_22_zy;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.a12_22_zy.clusterutil.clustering.ClusterItem;
import com.example.a12_22_zy.clusterutil.clustering.ClusterManager;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BindMapLoactionActivity extends AppCompatActivity {

    @BindView(R.id.map)
    MapView mMap;
    private BaiduMap baiduMap;
    private LocationClient mLocationClient;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_map_loaction);
        bind = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mMap = (MapView) findViewById(R.id.map);
        initPermission();
        baiduMap = mMap.getMap();
        //开启定位图层
        baiduMap.setMyLocationEnabled(true);

//定位初始化
        mLocationClient = new LocationClient(this);

//通过LocationClientOption设置LocationClient相关参数
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(1000);
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setIsNeedAddress(true);
        option.setIsNeedLocationDescribe(true);
        option.setNeedDeviceDirect(false);
        option.setLocationNotify(true);
        option.setIgnoreKillProcess(true);
        option.setIsNeedLocationDescribe(true);
        option.setIsNeedLocationPoiList(true);
        option.SetIgnoreCacheException(false);
        option.setOpenGps(true);

//设置locationClientOption
        mLocationClient.setLocOption(option);

//注册LocationListener监听器
        MyLocationListener myLocationListener = new MyLocationListener();
        mLocationClient.registerLocationListener(myLocationListener);
//开启地图定位图层
        mLocationClient.start();

        initCluster();

    }

    //ClusterItem接口的实现类
    public class MyItem implements ClusterItem {
        LatLng mPosition;
        public MyItem(LatLng position) {
            mPosition = position;
        }
        @Override
        public LatLng getPosition() {
            return mPosition;
        }
        @Override
        public BitmapDescriptor getBitmapDescriptor() {
            return BitmapDescriptorFactory
                    .fromResource(R.drawable.icon_gcoding);
        }
    }
    private void initCluster() {
//        初始化点聚合管理类
        ClusterManager<MyItem> mClusterManager = new ClusterManager<MyItem>(this, baiduMap);


        // 添加Marker点
        LatLng llA = new LatLng(39.963175, 116.400244);
        LatLng llB = new LatLng(39.942821, 116.369199);
        List<MyItem> items = new ArrayList<MyItem>();
        items.add(new MyItem(llA));
        items.add(new MyItem(llB));
        mClusterManager.addItems(items);
    }

    private void initPermission() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        },new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_FINE_LOCATION});
    }


    private class MyLocationListener extends BDAbstractLocationListener{
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (bdLocation == null || mMap == null){
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(bdLocation.getDirection()).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            Log.e("ii","定位的经度是:"+bdLocation.getLatitude()+"==="+"定位的纬度是:"+bdLocation.getLatitude());
            baiduMap.setMyLocationData(locData);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMap.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMap.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        bind.unbind();
        mLocationClient.stop();
        baiduMap.setMyLocationEnabled(false);
        mMap.onDestroy();
        mMap = null;
    }


}
