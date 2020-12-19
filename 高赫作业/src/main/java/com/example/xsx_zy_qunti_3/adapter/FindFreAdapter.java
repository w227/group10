package com.example.xsx_zy_qunti_3.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.xsx_zy_qunti_3.R;
import com.example.xsx_zy_qunti_3.RankActivity;
import com.example.xsx_zy_qunti_3.TuanActivity;
import com.example.xsx_zy_qunti_3.bean.HotBean;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFreAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HotBean.DataBean> list = new ArrayList<>();

    public FindFreAdapter(Context context, List<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    private static final int rec_one = 1;
    private static final int rec_two = 2;

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return rec_one;
        } else  {
            return rec_two;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == rec_one) {
            View root = LayoutInflater.from(context).inflate(R.layout.item_rec_one, parent, false);
            return new RecOneViewHolder(root);
        } else {
            View root = LayoutInflater.from(context).inflate(R.layout.item_rec_two, parent, false);
            return new RecTwoViewHolder(root);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case rec_one:
                RecOneViewHolder holder1 = (RecOneViewHolder) holder;
                RequestOptions option = new RequestOptions();
                option.transform(new CircleCrop());
                Glide.with(context).load(R.drawable.a2).apply(option).into(holder1.img_one_paozi);
                Glide.with(context).load(R.drawable.a3).apply(option).into(holder1.img_one_tuan);
                Glide.with(context).load(R.drawable.a4).apply(option).into(holder1.img_one_rank);
                holder1.img_one_paozi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                holder1.img_one_tuan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.startActivity(new Intent(context, TuanActivity.class));
                    }
                });
                holder1.img_one_rank.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        context.startActivity(new Intent(context, RankActivity.class));
                    }
                });
                break;
            case rec_two:

                break;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public static
    class RecOneViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_one_paozi;
        public ImageView img_one_tuan;
        public ImageView img_one_rank;

        public RecOneViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_one_paozi = (ImageView) rootView.findViewById(R.id.img_one_paozi);
            this.img_one_tuan = (ImageView) rootView.findViewById(R.id.img_one_tuan);
            this.img_one_rank = (ImageView) rootView.findViewById(R.id.img_one_rank);
        }

    }

    public static
    class RecTwoViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv_two_title;
        public TextView tv_two_content;

        public RecTwoViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_two_title = (TextView) rootView.findViewById(R.id.tv_two_title);
            this.tv_two_content = (TextView) rootView.findViewById(R.id.tv_two_content);
        }

    }
}
