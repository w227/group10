package com.example.myapplication.fagment.fagment1;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.apader.WenApader;
import com.example.myapplication.bean.WenBean;
import com.example.myapplication.mvp.HomePers;
import com.example.myapplication.mvp.IView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WenFragment extends Fragment implements IView {


    private RecyclerView rec2;
    private WenApader wenApader;

    public WenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_wen, container, false );
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        View view = getView ();
        initView(view);
        initDiew();
    }

    private void initDiew() {
        HomePers homePers = new HomePers ( this );
        homePers.stact3 ();
    }

    private void initView(View view) {
        rec2 = view.findViewById ( R.id.rec2 );
        rec2.setLayoutManager ( new LinearLayoutManager ( getContext () ) );

        wenApader = new WenApader (getActivity ());
        rec2.setAdapter ( wenApader );
    }

    @Override
    public void getChen1(Object object) {

    }

    @Override
    public void getChen2(Object object) {

    }

    @Override
    public void getChen3(Object object) {
        if (object instanceof List){
            List<WenBean.DataBeanX.DataBean> list= (List<WenBean.DataBeanX.DataBean>) object;
            wenApader.addlists ( list );
            wenApader.notifyDataSetChanged ();

        }

    }

    @Override
    public void getChen4(Object object) {

    }
}
