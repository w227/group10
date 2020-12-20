package com.example.xsx_shipei_dp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xsx_shipei_dp.R;
import com.example.xsx_shipei_dp.bean.ShirenBean;

import java.util.ArrayList;
import java.util.List;

public class RecShirenAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<ShirenBean> list = new ArrayList<>();

    public RecShirenAdapter(Context context, List<ShirenBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_rec_shiren, parent, false);
        return new RecShirenViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecShirenViewHolder holder1 = (RecShirenViewHolder) holder;
        ShirenBean shirenBean = list.get(position);
        holder1.tv_shiren_title.setText(shirenBean.getName());
        holder1.tv_shiren_desc.setText(shirenBean.getDesc());
        Glide.with(context).load(shirenBean.getImgPath()).into(holder1.img_rec_shiren);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static
    class RecShirenViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView img_rec_shiren;
        public TextView tv_shiren_title;
        public TextView tv_shiren_desc;

        public RecShirenViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img_rec_shiren = (ImageView) rootView.findViewById(R.id.img_rec_shiren);
            this.tv_shiren_title = (TextView) rootView.findViewById(R.id.tv_shiren_title);
            this.tv_shiren_desc = (TextView) rootView.findViewById(R.id.tv_shiren_desc);
        }

    }


}
