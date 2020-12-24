package com.example.demo_mvp_2.mvp.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.sug.OnGetSuggestionResultListener;
import com.baidu.mapapi.search.sug.SuggestionResult;
import com.baidu.mapapi.search.sug.SuggestionSearch;
import com.baidu.mapapi.search.sug.SuggestionSearchOption;
import com.example.demo_mvp_2.R;
import com.example.demo_mvp_2.engine.adapter.HomeActRlAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PoiSugSearchActivity extends AppCompatActivity {

    @BindView(R.id.et_city)
    EditText etCity;
    @BindView(R.id.et_poi)
    EditText etPoi;
    @BindView(R.id.bmapView)
    MapView mMapView;
    @BindView(R.id.rl_suggest)
    RecyclerView mRl;
    private InfoWindow mInfoWindow;

    private BitmapDescriptor mBitmap = BitmapDescriptorFactory.fromResource(R.drawable.icon_marka);

    private Unbinder mBind;
    private SuggestionSearch mSuggestionSearch;
    private List<SuggestionResult.SuggestionInfo> allSuggestions;
    private HomeActRlAdapter actRlAdapter;
    private BaiduMap mBaiduMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poi_sug_search);
        mBind = ButterKnife.bind(this);

        mBaiduMap = mMapView.getMap();

        mSuggestionSearch = SuggestionSearch.newInstance();
        mSuggestionSearch.setOnGetSuggestionResultListener(listener);
        String cityName = etCity.getText().toString();


        etPoi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mRl.setVisibility(View.VISIBLE);
                mSuggestionSearch.requestSuggestion(new SuggestionSearchOption()
                        .city(cityName)
                        .keyword(s + ""));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


    }

    /**
     * 更新到子节点的位置
     *
     * @param latLng 子节点经纬度
     */
    private void addPoiLoction(LatLng latLng) {
        mBaiduMap.clear();
        OverlayOptions markerOptions = new MarkerOptions().position(latLng).icon(mBitmap).clickable(true);
        mBaiduMap.addOverlay(markerOptions);
        MapStatus.Builder builder = new MapStatus.Builder();
        builder.target(latLng);
        builder.zoom(18.0f);
        mBaiduMap.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));

    }


    private void infoWindows(String desc, LatLng point) {
        //用来构造InfoWindow的Button
        Button button = new Button(getApplicationContext());
        button.setBackgroundResource(R.drawable.popup);
        button.setText(desc);

        //构造InfoWindow
        //point 描述的位置点
        //-100 InfoWindow相对于point在y轴的偏移量
        InfoWindow infoWindow = new InfoWindow(button, point, -20);
        //使InfoWindow生效
        mBaiduMap.showInfoWindow(infoWindow);
    }


    private OnGetSuggestionResultListener listener = new OnGetSuggestionResultListener() {
        @Override
        public void onGetSuggestionResult(SuggestionResult suggestionResult) {
            //处理sug检索结果
            allSuggestions = suggestionResult.getAllSuggestions();
            if (allSuggestions != null && allSuggestions.size() > 0) {
                mRl.setLayoutManager(new LinearLayoutManager(PoiSugSearchActivity.this));
                mRl.addItemDecoration(new DividerItemDecoration(PoiSugSearchActivity.this, DividerItemDecoration.VERTICAL));
                actRlAdapter = new HomeActRlAdapter(PoiSugSearchActivity.this, allSuggestions);
                mRl.setAdapter(actRlAdapter);

                actRlAdapter.setiOnClick(new HomeActRlAdapter.IOnClick() {
                    @Override
                    public void click(int pos) {
                        mRl.setVisibility(View.GONE);
                        if (allSuggestions != null && allSuggestions.size() > 0) {
                            SuggestionResult.SuggestionInfo suggestionInfo = allSuggestions.get(pos);
                            LatLng pt = suggestionInfo.pt;

                            addPoiLoction(pt);

//                            initListener(suggestionInfo.address);

//                        PoiInfo poiInfo = suggestionInfo;
//                        MapStatusUpdate status = MapStatusUpdateFactory.newLatLng(poiInfo.location);
//                        mBaiduMap.setMapStatus(status);

                            infoWindows(suggestionInfo.address, pt);
                        }
                    }
                });
            }
        }
    };

    private void initListener(String address) {
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            public boolean onMarkerClick(final Marker marker) {
                Button button = new Button(getApplicationContext());
                button.setBackgroundResource(R.drawable.popup);
                InfoWindow.OnInfoWindowClickListener listener = null;

                button.setText(address);
                button.setTextColor(Color.BLACK);
                button.setWidth(300);
                // InfoWindow点击事件监听接口
                listener = new InfoWindow.OnInfoWindowClickListener() {
                    public void onInfoWindowClick() {
                        LatLng latLng = marker.getPosition();
                        LatLng latLngNew = new LatLng(latLng.latitude + 0.005, latLng.longitude + 0.005);
                        marker.setPosition(latLngNew);
                        // 隐藏地图上的所有InfoWindow
                        mBaiduMap.hideInfoWindow();
                    }
                };
                LatLng latLng = marker.getPosition();
                // 创建InfoWindow
                mInfoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(button), latLng, -47, listener);
                // 显示 InfoWindow, 该接口会先隐藏其他已添加的InfoWindow, 再添加新的InfoWindow
                mBaiduMap.showInfoWindow(mInfoWindow);

                return true;
            }
        });
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
        mBind.unbind();
        mSuggestionSearch.destroy();
        mBaiduMap.clear();
        mBitmap.recycle();
    }


}