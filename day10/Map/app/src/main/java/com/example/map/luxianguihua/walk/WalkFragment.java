package com.example.map.luxianguihua.walk;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.route.BikingRouteResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.IndoorRouteResult;
import com.baidu.mapapi.search.route.MassTransitRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.example.map.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalkFragment extends Fragment {


    @BindView(R.id.start_et)
    EditText startEt;
    @BindView(R.id.end_et)
    EditText endEt;
    @BindView(R.id.start_et_cheng)
    EditText startEtCheng;
    @BindView(R.id.end_et_zhong)
    EditText endEtZhong;
    @BindView(R.id.btn_walik)
    Button btnWalik;
    @BindView(R.id.mMapView)
    MapView mMapView;
    private Unbinder bind;
    private BaiduMap mMap;
    private RoutePlanSearch mSearch;

    public WalkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_walk, container, false);
        bind = ButterKnife.bind(this, view);
        mMap = mMapView.getMap();
        mSearch = RoutePlanSearch.newInstance();
        mSearch.setOnGetRoutePlanResultListener(listener);
        return view;
    }

    OnGetRoutePlanResultListener listener = new OnGetRoutePlanResultListener() {
        @Override
        public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {
            //创建WalkingRouteOverlay实例
            WalkingRouteOverlay overlay = new WalkingRouteOverlay(mMap);
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

        }

        @Override
        public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {

        }

        @Override
        public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {

        }
    };

    @OnClick(R.id.btn_walik)
    public void onClick() {
        String mStartEt = startEt.getText().toString().trim();
        String mEndEt = endEt.getText().toString().trim();
        String mStartEtCheng = startEtCheng.getText().toString().trim();
        String mEndEtZhong = endEtZhong.getText().toString().trim();

        if (!TextUtils.isEmpty(mStartEt)
                && !TextUtils.isEmpty(mEndEt)
                && !TextUtils.isEmpty(mEndEtZhong)
                && !TextUtils.isEmpty(mStartEtCheng)){

            PlanNode stNode = PlanNode.withCityNameAndPlaceName("北京", "西二旗地铁站");
            PlanNode enNode = PlanNode.withCityNameAndPlaceName("北京", "百度科技园");

            mSearch.walkingSearch((new WalkingRoutePlanOption())
                    .from(stNode)
                    .to(enNode));
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mSearch.destroy();
        mMapView.onDestroy();
        bind.unbind();
    }
}
