package com.example.map.luxianguihua.driving;


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
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
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
import com.example.map.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class DirvingFragment extends Fragment {


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

    public DirvingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dirving, container, false);
        bind = ButterKnife.bind(this, view);
        mMap = mMapView.getMap();
        mSearch = RoutePlanSearch.newInstance();
        mSearch.setOnGetRoutePlanResultListener(listener);
        return view;
    }

    OnGetRoutePlanResultListener listener = new OnGetRoutePlanResultListener() {
        @Override
        public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {

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
            DrivingRouteOverlay overlay = new DrivingRouteOverlay(mMap);
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

            PlanNode stNode = PlanNode.withCityNameAndPlaceName(mStartEt, mEndEt);
            PlanNode enNode = PlanNode.withCityNameAndPlaceName(mStartEtCheng, mEndEtZhong);

            mSearch.drivingSearch((new DrivingRoutePlanOption())
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
