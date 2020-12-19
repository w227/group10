package com.example.xsx_zy_qunti_3.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.xsx_zy_qunti_3.R;
import com.example.xsx_zy_qunti_3.bean.TuanBean;

import java.util.ArrayList;
import java.util.List;

public class RecTuanAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<TuanBean.DataBean.ListBean> list = new ArrayList<>();
    private static final String TAG = "RecTuanAdapter";

    public RecTuanAdapter(Context context, List<TuanBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;
    private static final int TYPE_THREE = 3;
    private static final int TYPE_REC = 4;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_ONE;
        } else if (position == 1) {
            return TYPE_TWO;
        } else if (position == 2) {
            return TYPE_THREE;
        } else {
            return TYPE_REC;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View root = LayoutInflater.from(context).inflate(R.layout.item_one_tuan, parent, false);
            return new OneTuanViewHolder(root);
        } else if (viewType == TYPE_TWO) {
            View root = LayoutInflater.from(context).inflate(R.layout.item_two_tuan, parent, false);
            return new TwoTuanViewHolder(root);
        } else if (viewType == TYPE_THREE) {
            View root = LayoutInflater.from(context).inflate(R.layout.item_three_tuan, parent, false);
            return new ThreeTuanViewHolder(root);
        } else {
            View root = LayoutInflater.from(context).inflate(R.layout.item_rec_duan, parent, false);
            return new RecTuanViewHolder(root);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.e(TAG, "onBindViewHolder: " + list.size());
        switch (getItemViewType(position)) {
            case TYPE_ONE:

                break;
            case TYPE_TWO:
//                TwoTuanViewHolder holder2 = (TwoTuanViewHolder) holder;
//                TuanBean.DataBean.ListBean listBean1 = list.get(position - 1);
//                Glide.with(context).load(listBean1.getAttachment()).into(holder2.img_tuan_rank);
                break;
            case TYPE_THREE:
                ThreeTuanViewHolder holder3 = (ThreeTuanViewHolder) holder;

                break;
            case TYPE_REC:
                RecTuanViewHolder holder1 = (RecTuanViewHolder) holder;
                TuanBean.DataBean.ListBean listBean = list.get(position - 3);
                holder1.tv_duan_title.setText(listBean.getFullName());
                holder1.tv_duan_mc.setText("成员：" + listBean.getCountUser());
                holder1.tv_duan_act.setText("活动：" + listBean.getCountActivity());
                holder1.tv_duan_desc.setText(listBean.getNote());
                RequestOptions option = new RequestOptions();
                option.transform(new CircleCrop());
                Glide.with(context).load(listBean.getLogo()).apply(option).into(holder1.img_icon_duan);
                break;
        }
    }

    @Override
    public int getItemCount() {
        Log.e(TAG, "getItemCount: " + list.size());
        return list.size() + 3;
    }

    public static
    class OneTuanViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public EditText et_search;

        public OneTuanViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.et_search = (EditText) rootView.findViewById(R.id.et_search);
        }

    }

    public static
    class TwoTuanViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_tuan_rank;

        public TwoTuanViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_tuan_rank = (ImageView) rootView.findViewById(R.id.img_tuan_rank);
        }

    }

    public static
    class RecTuanViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_icon_duan;
        public TextView tv_duan_title;
        public TextView tv_duan_mc;
        public TextView tv_duan_act;
        public TextView tv_duan_desc;

        public RecTuanViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_icon_duan = (ImageView) rootView.findViewById(R.id.img_icon_duan);
            this.tv_duan_title = (TextView) rootView.findViewById(R.id.tv_duan_title);
            this.tv_duan_mc = (TextView) rootView.findViewById(R.id.tv_duan_mc);
            this.tv_duan_act = (TextView) rootView.findViewById(R.id.tv_duan_act);
            this.tv_duan_desc = (TextView) rootView.findViewById(R.id.tv_duan_desc);
        }

    }

    public static
    class ThreeTuanViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_tuan_three;

        public ThreeTuanViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_tuan_three = (TextView) rootView.findViewById(R.id.tv_tuan_three);
        }

    }
}
