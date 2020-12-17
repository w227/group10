package com.example.data12_17homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.data12_17homework.R;
import com.example.data12_17homework.adapter.VpAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SofaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SofaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TabLayout mSofaTab;
    private ViewPager mSofaVp;

    public SofaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SofaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SofaFragment newInstance(String param1, String param2) {
        SofaFragment fragment = new SofaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_sofa, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(@NonNull final View itemView) {
        mSofaTab = (TabLayout) itemView.findViewById(R.id.tab_sofa);
        mSofaVp = (ViewPager) itemView.findViewById(R.id.vp_sofa);


        List<Fragment> fragments = new ArrayList<>();
        List<String> tabs = new ArrayList<>();
        fragments.add(new ImageFragment());
        fragments.add(new VideoFragment());
        fragments.add(new TextFragment());
        tabs.add("图片");
        tabs.add("视频");
        tabs.add("文本");

        VpAdapter vpAdapter = new VpAdapter(getChildFragmentManager(), fragments, tabs);

        mSofaVp.setAdapter(vpAdapter);

        mSofaTab.setupWithViewPager(mSofaVp);
    }
}