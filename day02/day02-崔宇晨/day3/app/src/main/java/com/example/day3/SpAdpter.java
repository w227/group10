package com.example.day3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day3.model.bean.DataInfo2;

import java.util.ArrayList;

public class SpAdpter extends RecyclerView.Adapter {
    private ArrayList<DataInfo2.DataBeanX.DataBean> mBean;
    private Context context;

    public SpAdpter(ArrayList<DataInfo2.DataBeanX.DataBean> mBean, Context context) {
        this.mBean = mBean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adpter2_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Holder holder1= (Holder) holder;
        holder1.txt.setText(mBean.get(position).getAuthor().getName());
        Glide.with(context).load(mBean.get(position).getAuthor().getAvatar()).into(holder1.img);
        Glide.with(context).load(R.mipmap.ic_launcher).into(holder1.img2);
    }

    @Override
    public int getItemCount() {
        return mBean.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        ImageView img2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.sp_img);
            txt=itemView.findViewById(R.id.sp_txt);
            img2=itemView.findViewById(R.id.sp_img2);
        }
    }
}
