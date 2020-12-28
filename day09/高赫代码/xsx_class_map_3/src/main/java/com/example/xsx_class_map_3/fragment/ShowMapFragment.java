package com.example.xsx_class_map_3.fragment;


import android.Manifest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.example.xsx_class_map_3.R;
import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowMapFragment extends Fragment {

    private BaiduMap baiduMap_show;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_map, container, false);
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
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initPermission();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
