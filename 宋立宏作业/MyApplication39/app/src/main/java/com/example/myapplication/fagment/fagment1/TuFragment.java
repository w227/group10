package com.example.myapplication.fagment.fagment1;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.apader.HoneApader;
import com.example.myapplication.bean.ListBnea;
import com.example.myapplication.mvp.HomePers;
import com.example.myapplication.mvp.IView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuFragment extends Fragment implements IView {


    private RecyclerView rec;
    private HoneApader honeApader;

    public TuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_tu, container, false );
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
        homePers.stact1();

    }

    private void initView(View view) {
        rec = view.findViewById ( R.id.rec );
        rec.setLayoutManager ( new LinearLayoutManager ( getContext () ) );
        honeApader = new HoneApader (getActivity ());
        rec.setAdapter ( honeApader );
    }

    @Override
    public void getChen1(Object object) {
        if (object instanceof List){

            List<ListBnea.DataBeanX.DataBean> list1= (List<ListBnea.DataBeanX.DataBean>) object;


            honeApader.addlist1 ( list1 );
            honeApader.notifyDataSetChanged ();

        }

    }

    @Override
    public void getChen2(Object object) {

    }

    @Override
    public void getChen3(Object object) {

    }

    @Override
    public void getChen4(Object object) {

    }
}
