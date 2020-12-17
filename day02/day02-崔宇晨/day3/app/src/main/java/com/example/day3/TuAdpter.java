package com.example.day3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.day3.model.bean.DataInfo;

import java.util.ArrayList;

public class TuAdpter extends RecyclerView.Adapter {
    private ArrayList<DataInfo.DataBeanX.DataBean> mBean;
    private Context context;

    public TuAdpter(ArrayList<DataInfo.DataBeanX.DataBean> mBean, Context context) {
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
        holder1.txt.setText(mBean.get(position).getAuthor().getName());
        Glide.with(context).load(mBean.get(position).getAuthor().getAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder1.img);
        holder1.txt2.setText(mBean.get(position).getFeeds_text()+"");
        holder1.txt3.setText(mBean.get(position).getActivityText()+"");
        Glide.with(context).load(mBean.get(position).getCover()).into(holder1.img2);
        Glide.with(context).load(R.mipmap.ic_launcher).into(holder1.img3);
        Glide.with(context).load(R.mipmap.ic_launcher).into(holder1.img4);
        Glide.with(context).load(R.mipmap.ic_launcher).into(holder1.img5);
        Glide.with(context).load(R.mipmap.ic_launcher).into(holder1.img6);

    }

    @Override
    public int getItemCount() {
        return mBean.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView txt2;
        ImageView img2;
        TextView txt3;
        ImageView img3;
        ImageView img4;
        ImageView img5;
        ImageView img6;

        public Holder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            txt=itemView.findViewById(R.id.txt);
            txt2=itemView.findViewById(R.id.txt2);
            img2=itemView.findViewById(R.id.img2);
            txt3=itemView.findViewById(R.id.txt3);
            img3=itemView.findViewById(R.id.ll_img3);
            img4=itemView.findViewById(R.id.ll_img2);
            img5=itemView.findViewById(R.id.ll_img3);
            img6=itemView.findViewById(R.id.ll_img4);
        }
    }
}
