package com.example.xsx_class_map_3.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.example.xsx_class_map_3.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeiFragment extends Fragment {

    private BaiduMap mBaiduMap_wei;
    private static final String TAG = "WeiFragment";
    private RadioButton radioButton;
    private RadioButton rb_normal;
    private RadioButton rb_satellite;
    private RadioButton rb_none;
    private RadioGroup rg;
    @BindView(R.id.map_view_wei)
    MapView map_view_wei;
    private Unbinder mBind;
    private LocationClient mLocationClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wei, container, false);
        mBind = ButterKnife.bind(this, view);
//        map_view_wei = (MapView) getActivity().findViewById(R.id.map_view_wei);
        rb_normal = (RadioButton) getActivity().findViewById(R.id.rb_normal);
        rb_satellite = (RadioButton) getActivity().findViewById(R.id.rb_satellite);
        rb_none = (RadioButton) getActivity().findViewById(R.id.rb_none);
        rg = getActivity().findViewById(R.id.rg);
//        rg.check(R.id.rb_normal);
        //定位初始化
        mLocationClient = new LocationClient(getContext());

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
//        mLocationClient.start();
        Log.e(TAG, "onCreateView: " + "=====");
        return view;
    }

    @OnCheckedChanged({R.id.rb_normal,R.id.rb_satellite,R.id.rb_none})
    public void onRadioClick(RadioButton view){
        mBaiduMap_wei = map_view_wei.getMap();
        mBaiduMap_wei.setMyLocationEnabled(true);
        mBaiduMap_wei.clear();
        switch (view.getId()){
            case R.id.rb_normal:
                mBaiduMap_wei.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                break;
            case R.id.rb_satellite:
                mBaiduMap_wei.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.rb_none:
                mBaiduMap_wei.setMapType(BaiduMap.MAP_TYPE_NONE);
                break;
        }
    }
    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation location) {
            //mapView 销毁后不在处理新接收的位置
            if (location == null || map_view_wei == null){
                return;
            }
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap_wei.setMyLocationData(locData);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mBind != null){
            mBind.unbind();
        }
    }
}
