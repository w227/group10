package com.example.dp7_12_18_zy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.dp7_12_18_zy.model.bean.DataInfo2;

import java.util.ArrayList;

public class AocAdpter extends RecyclerView.Adapter {
    private ArrayList<DataInfo2.DataBean.ListBean> mBean;
    private Context context;

    public AocAdpter(ArrayList<DataInfo2.DataBean.ListBean> mBean, Context context) {
        this.mBean = mBean;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adpter2_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1= (ViewHolder) holder;
        holder1.adpter2_txt.setText(mBean.get(position).getFullName());
        holder1.adpter2_txt2.setText("成员"+mBean.get(position).getIntegralnumber());
        holder1.adpter2_txt3.setText("活动"+mBean.get(position).getCountActivity());
        holder1.adpter2_txt4.setText(mBean.get(position).getNote());
        Glide.with(context).load(mBean.get(position).getAttachment()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder1.adpter2_img);
    }

    @Override
    public int getItemCount() {
        return mBean.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView adpter2_img;
        public TextView adpter2_txt;
        public TextView adpter2_txt2;
        public TextView adpter2_txt3;
        public TextView adpter2_txt4;
        public Button adpter_btn;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.adpter2_img = (ImageView) rootView.findViewById(R.id.adpter2_img);
            this.adpter2_txt = (TextView) rootView.findViewById(R.id.adpter2_txt);
            this.adpter2_txt2 = (TextView) rootView.findViewById(R.id.adpter2_txt2);
            this.adpter2_txt3 = (TextView) rootView.findViewById(R.id.adpter2_txt3);
            this.adpter2_txt4 = (TextView) rootView.findViewById(R.id.adpter2_txt4);
            this.adpter_btn = (Button) rootView.findViewById(R.id.adpter_btn);
        }

    }
}
