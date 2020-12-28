package com.example.xsx_class_map_3.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

import com.example.xsx_class_map_3.R;
import com.example.xsx_class_map_3.clusterutil.clustering.Cluster;
import com.example.xsx_class_map_3.clusterutil.clustering.ClusterItem;
import com.example.xsx_class_map_3.clusterutil.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuggestFragment extends Fragment implements BaiduMap.OnMapLoadedCallback {


    private ClusterManager<MyItem> clusterManager;
    private BaiduMap mBaiduMap_suggest;
    private List<MyItem> items;
    private static final String TAG = "SuggestFragment";
    private MapView map_view_suggest;
    private MapStatus mapStatus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_suggest, container, false);
        map_view_suggest = view.findViewById(R.id.map_view_suggest);
        mBaiduMap_suggest = map_view_suggest.getMap();
        mBaiduMap_suggest.setOnMapLoadedCallback(this);
        mapStatus = new MapStatus.Builder().target(
                new LatLng(39.9876, 116.441319)).zoom(8).build();
        //初始化点聚合管理类
        clusterManager = new ClusterManager<>(getActivity(), mBaiduMap_suggest);
        mBaiduMap_suggest.setOnMapStatusChangeListener(clusterManager);
        mBaiduMap_suggest.setOnMarkerClickListener(clusterManager);
        clusterManager.setOnClusterClickListener(
                new ClusterManager.OnClusterClickListener<MyItem>() {
                    @Override
                    public boolean onClusterClick(Cluster<MyItem> cluster) {
                        Toast.makeText(getContext(), "有" + cluster.getSize()
                                + "个点", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
        clusterManager.setOnClusterItemClickListener(
                new ClusterManager.OnClusterItemClickListener<MyItem>() {
                    @Override
                    public boolean onClusterItemClick(MyItem item) {
                        Toast.makeText(getContext(), "点击单个item", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
        mBaiduMap_suggest.setMyLocationEnabled(true);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 添加Marker点
        LatLng llA = new LatLng(39.963172, 116.400044);
        LatLng llB = new LatLng(39.942833, 116.369100);
        items = new ArrayList<>();
        items.add(new MyItem(llA));
        items.add(new MyItem(llB));
//        Log.e(TAG, "onActivityCreated: "+items.size() );
        clusterManager.addItems(items);
//        Toast.makeText(getActivity(), "点总数是："+items.size(), Toast.LENGTH_SHORT).show();
    }

    //ClusterItem接口的实现类
    public class MyItem implements ClusterItem {
        LatLng mPosition;

        public MyItem(LatLng position) {
            Log.e(TAG, "getBitmapDescriptor000: "+position );
            mPosition = position;
        }

        @Override
        public LatLng getPosition() {
            Log.e(TAG, "getBitmapDescriptor111: "+mPosition );
            getBitmapDescriptor();
            return mPosition;
        }

        @Override
        public BitmapDescriptor getBitmapDescriptor() {
            Log.e(TAG, "getBitmapDescriptor222: "+R.drawable.icon_gcoding );
            return BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);
        }
    }
    @Override
    public void onMapLoaded() {
        // TODO Auto-generated method stub
        mapStatus = new MapStatus.Builder().zoom(9).build();
        mBaiduMap_suggest.animateMapStatus(MapStatusUpdateFactory.newMapStatus(mapStatus));
    }

}
