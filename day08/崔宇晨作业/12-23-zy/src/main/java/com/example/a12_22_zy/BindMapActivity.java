package com.example.a12_22_zy;

import android.Manifest;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

public class BindMapActivity extends AppCompatActivity {

    private MapView mMapview = null;
    /**
     * 普通图
     */
    private RadioButton mRb;
    /**
     * 卫星图
     */
    private RadioButton mRb2;
    /**
     * 空白地图
     */
    private RadioButton mRb3;
    private RadioGroup mRg;
    private BaiduMap mBaidMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MapView mapView = new MapView(this);
//        setContentView(mapView);
//        BaiduMapOptions baiduMapOptions = new BaiduMapOptions();
//        baiduMapOptions.mapType(BaiduMap.MAP_TYPE_SATELLITE);
//        MapView mapView1 = new MapView(this, baiduMapOptions);
//        setContentView(mapView1);
        setContentView(R.layout.activity_bind_map);
        initView();
    }

    private void initView() {
        initPremission();
        mMapview = (MapView) findViewById(R.id.mapview);
        mRb = (RadioButton) findViewById(R.id.rb);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
        mRg = (RadioGroup) findViewById(R.id.rg);
        //创建对象 生成的全局便变量，只限于吃方法中
        mBaidMap = mMapview.getMap();
        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb:
                        Toast.makeText(BindMapActivity.this, "普通图", Toast.LENGTH_SHORT).show();
                   //  mBaidMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                        //实时路况图
//                        mBaidMap.setTrafficEnabled(true);
                        //热力图

                        mBaidMap.setBaiduHeatMapEnabled(true);
                        break;
                    case  R.id.rb2:
                        Toast.makeText(BindMapActivity.this, "卫星图", Toast.LENGTH_SHORT).show();
                        mBaidMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
                        mBaidMap.setBuildingsEnabled(true);
                        break;
                    case R.id.rb3:
                        Toast.makeText(BindMapActivity.this, "空白地图", Toast.LENGTH_SHORT).show();
                        mBaidMap.setMapType(BaiduMap.MAP_TYPE_NONE);
                        break;
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapview.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapview.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapview.onResume();
    }

    private void initPremission() {
        PermissionsUtil.requestPermission(this, new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        }, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE
                , Manifest.permission.WRITE_EXTERNAL_STORAGE});
    }



}
