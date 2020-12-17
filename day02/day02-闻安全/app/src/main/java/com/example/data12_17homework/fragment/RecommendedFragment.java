package com.example.data12_17homework.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.data12_17homework.CollectionDbBeanDao;
import com.example.data12_17homework.DbUtil;
import com.example.data12_17homework.R;
import com.example.data12_17homework.adapter.RvImageAdapter;
import com.example.data12_17homework.adapter.RvRecommentAdapter;
import com.example.data12_17homework.api.ApiServer;
import com.example.data12_17homework.bean.CollectionBean;
import com.example.data12_17homework.bean.CollectionDbBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecommendedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecommendedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecommentRv;
    private List<CollectionBean.DataBeanX.DataBean> dataBeanList;
    private RvRecommentAdapter rvRecommentAdapter;
    private DbUtil dbUtil;

    public RecommendedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecommendedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecommendedFragment newInstance(String param1, String param2) {
        RecommendedFragment fragment = new RecommendedFragment();
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
        View inflate = inflater.inflate(R.layout.fragment_recommended, container, false);
        dbUtil = DbUtil.getDbUtil();
        initView(inflate);
        initData();
        initListener();
        return inflate;
    }

    private void initListener() {
        rvRecommentAdapter.setOnClick(new RvRecommentAdapter.IOnClick() {
            @Override
            public void onClick(int pos, boolean isCollection) {
                CollectionBean.DataBeanX.DataBean dataBean = dataBeanList.get(pos);
                CollectionDbBean collectionDbBean = new CollectionDbBean();
                collectionDbBean.setContent(dataBean.getFollowNum() + "条热门内容");
                collectionDbBean.setIcon(dataBean.getIcon());
                collectionDbBean.setTitle(dataBean.getTitle());
                if (isCollection) {
                    dbUtil.insert(collectionDbBean);
                } else {
                    dbUtil.delete(collectionDbBean);
                }
            }
        });
    }

    private void initData() {
        new Retrofit.Builder()
                .baseUrl(ApiServer.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServer.class)
                .getCollectionBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CollectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CollectionBean collectionBean) {
                        dataBeanList.addAll(collectionBean.getData().getData());
                        rvRecommentAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void initView(@NonNull final View itemView) {
        mRecommentRv = (RecyclerView) itemView.findViewById(R.id.rv_recomment);

        mRecommentRv.setLayoutManager(new LinearLayoutManager(getContext()));

        mRecommentRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        dataBeanList = new ArrayList<>();

        rvRecommentAdapter = new RvRecommentAdapter(getActivity(), dataBeanList);

        mRecommentRv.setAdapter(rvRecommentAdapter);
    }
}