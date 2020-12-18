package com.example.dp7_12_18_zy.fragment;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dp7_12_18_zy.R;
import com.example.dp7_12_18_zy.model.bean.DataInfo;

import java.util.ArrayList;

public class LookAdpter extends RecyclerView.Adapter {
    private ArrayList<DataInfo.DataBean> mBean;
    private Context context;

    public LookAdpter(ArrayList<DataInfo.DataBean> mBean, Context context) {
        this.mBean = mBean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adpter_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        holder1.txt.setText(mBean.get(position).getEndTime());
        holder1.txt2.setText(mBean.get(position).getLocation());
        Glide.with(context).load(mBean.get(position).getCover())
                .into(holder1.img);
    }

    @Override
    public int getItemCount() {
        return mBean.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView txt2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.look_img);
            txt=itemView.findViewById(R.id.look_txt);
            txt2=itemView.findViewById(R.id.look_txt2);
        }
    }
}
