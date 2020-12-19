package com.example.myapplication.fagment.fagment1;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.Shu;
import com.example.myapplication.apader.ChuApader;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuiFragment extends Fragment {


    private RecyclerView rec4;
    private List<Shu> shus;
    private ChuApader chuApader;

    public TuiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate ( R.layout.fragment_tui, container, false );
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated ( savedInstanceState );
        View view = getView ();
        initDiew();
        initView(view);
    }

    private void initDiew() {
        shus = App.getDaoSession ().getShuDao ().loadAll ();
        chuApader = new ChuApader (getActivity (),shus);
        if (rec4!=null){
            rec4.setAdapter ( chuApader );

        }

    }

    private void initView(View view) {
        rec4 = view.findViewById ( R.id.rec4 );
        rec4.setLayoutManager ( new LinearLayoutManager ( getContext () ) );


    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint ( isVisibleToUser );
        if (isVisibleToUser){
            initDiew ();
        }
    }
}
