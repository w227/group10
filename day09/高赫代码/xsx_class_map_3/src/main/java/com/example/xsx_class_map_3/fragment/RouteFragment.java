package com.example.xsx_class_map_3.fragment;


import android.Manifest;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

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
import com.example.xsx_class_map_3.overlayutil.DrivingRouteOverlay;
import com.example.xsx_class_map_3.overlayutil.WalkingRouteOverlay;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RouteFragment extends androidx.fragment.app.Fragment {
    @BindView(R.id.bmapView)
    MapView bmapView;
    @BindView(R.id.et_st_city)
    EditText etStCity;
    @BindView(R.id.et_st_str)
    EditText etStStr;
    @BindView(R.id.et_ed_city)
    EditText etEdCity;
    @BindView(R.id.et_ed_str)
    EditText etEdStr;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.ll)
    LinearLayout ll;
    private RoutePlanSearch mSearch;
    private BaiduMap mBaiduMap;
    private Unbinder mBind;
    private static final String TAG = "RouteFragment";

    public RouteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(mBind != null){
            mBind = ButterKnife.bind(getActivity());
        }

        initPermission();
        if(mBaiduMap != null){
            mBaiduMap = bmapView.getMap();
        }
        mSearch = RoutePlanSearch.newInstance();
        mSearch.setOnGetRoutePlanResultListener(listener);
        return inflater.inflate(R.layout.fragment_route, container, false);
    }

    private void initPermission() {
        PermissionsUtil.requestPermission(getActivity(), new PermissionListener() {
            @Override
            public void permissionGranted(@NonNull String[] permission) {

            }

            @Override
            public void permissionDenied(@NonNull String[] permission) {

            }
        }, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE});
    }

    @OnClick({R.id.btn_search})
    public void click() {
        String st_city = etStCity.getText().toString().trim();
        String st_str = etStStr.getText().toString().trim();
        String et_city = etEdCity.getText().toString().trim();
        String et_str = etEdStr.getText().toString().trim();
        Log.e(TAG, "click: " + et_str);
        PlanNode stNode = PlanNode.withCityNameAndPlaceName(st_city, st_str);
        PlanNode enNode = PlanNode.withCityNameAndPlaceName(et_city, et_str);
        if (!TextUtils.isEmpty(st_city) && !TextUtils.isEmpty(st_str) &&
                !TextUtils.isEmpty(et_city) && !TextUtils.isEmpty(et_str)) {
            mSearch.drivingSearch((new DrivingRoutePlanOption())
                    .from(stNode)
                    .to(enNode));
        } else {
            Toast.makeText(getActivity(), "内容不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        if(bmapView != null){
            bmapView.onDestroy();
        }
        if(mBind != null){
            mBind.unbind();
        }
        mSearch.destroy();
    }

    OnGetRoutePlanResultListener listener = new OnGetRoutePlanResultListener() {
        @Override
        public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {

        }

        @Override
        public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {

        }

        @Override
        public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {
//            创建WalkingRouteOverlay实例
            WalkingRouteOverlay overlay = new WalkingRouteOverlay(mBaiduMap);
            if (walkingRouteResult.getRouteLines() != null) {
                if (walkingRouteResult.getRouteLines().size() > 0) {
                    //获取路径规划数据,(以返回的第一条数据为例)
                    //为WalkingRouteOverlay实例设置路径数据
                    overlay.setData(walkingRouteResult.getRouteLines().get(0));
                    //在地图上绘制WalkingRouteOverlay
                    overlay.addToMap();
                }
            }
        }

        @Override
        public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {

        }

        @Override
        public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {

        }

        @Override
        public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {
            //创建DrivingRouteOverlay实例
            DrivingRouteOverlay overlay = new DrivingRouteOverlay(mBaiduMap);
            if (drivingRouteResult.getRouteLines() != null) {
                if (drivingRouteResult.getRouteLines().size() > 0) {
                    //获取路径规划数据,(以返回的第一条路线为例）
                    //为DrivingRouteOverlay实例设置数据
                    overlay.setData(drivingRouteResult.getRouteLines().get(0));
                    //在地图上绘制DrivingRouteOverlay
                    overlay.addToMap();
                }
            }
        }
    };
}
