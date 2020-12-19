package com.example.xsx_zy_qunti_3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.example.xsx_zy_qunti_3.R;
import com.example.xsx_zy_qunti_3.bean.HotBean;

import java.util.ArrayList;
import java.util.List;

public class FindHengAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HotBean.DataBean> list = new ArrayList<>();

    public FindHengAdapter(Context context, List<HotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_heng, parent, false);
        return new RecHengViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecHengViewHolder holder1 = (RecHengViewHolder) holder;
        HotBean.DataBean dataBean = list.get(position);
        holder1.tv_heng.setText(dataBean.getTitle());
        holder1.tv_address_heng.setText(dataBean.getLocation());
        holder1.tv_date_heng.setText(dataBean.getEndTime());
        RequestOptions option = new RequestOptions();
        option.transform(new RoundedCorners(15));
        Glide.with(context).load(dataBean.getCover()).apply(option).into(holder1.img_heng);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class RecHengViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img_heng;
        public TextView tv_heng;
        public TextView tv_address_heng;
        public TextView tv_date_heng;

        public RecHengViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_heng = (ImageView) rootView.findViewById(R.id.img_heng);
            this.tv_heng = (TextView) rootView.findViewById(R.id.tv_heng);
            this.tv_address_heng = (TextView) rootView.findViewById(R.id.tv_address_heng);
            this.tv_date_heng = (TextView) rootView.findViewById(R.id.tv_date_heng);
        }

    }
}
