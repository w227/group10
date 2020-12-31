package com.example.xsx_zy_home_page.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.xsx_zy_home_page.R;
import com.example.xsx_zy_home_page.bean.HaiBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<HaiBean> list = new ArrayList<>();

    public MyAdapter(Context context, List<HaiBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_hai, null);
        return new HaiViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HaiViewHolder holder1 = (HaiViewHolder) holder;
        HaiBean haiBean = list.get(position);
        holder1.iv_hai.setImageResource(haiBean.getImgPath());
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static
    class HaiViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv_hai;

        public HaiViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_hai = (ImageView) rootView.findViewById(R.id.iv_hai);
        }

    }
}
