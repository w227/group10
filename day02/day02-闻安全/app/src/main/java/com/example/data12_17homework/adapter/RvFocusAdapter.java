package com.example.data12_17homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.data12_17homework.R;
import com.example.data12_17homework.bean.CollectionDbBean;

import java.util.List;

public class RvFocusAdapter extends RecyclerView.Adapter<RvFocusAdapter.ViewHolder> {
    private final Context context;
    private final List<CollectionDbBean> dataBeanList;

    public RvFocusAdapter(Context context, List<CollectionDbBean> dataBeanList) {

        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_facus, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CollectionDbBean collectionDbBean = dataBeanList.get(position);
        Glide.with(context).load(collectionDbBean.getIcon()).apply(RequestOptions.bitmapTransform(new RoundedCorners(20))).into(holder.iv_icon);
        holder.tv_followNum.setText(collectionDbBean.getContent());

        holder.tv_title.setText(collectionDbBean.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_icon;
        public TextView tv_title;
        public TextView tv_followNum;
        public Button btn_focus;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_icon = (ImageView) rootView.findViewById(R.id.iv_icon);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
            this.tv_followNum = (TextView) rootView.findViewById(R.id.tv_followNum);
            this.btn_focus = (Button) rootView.findViewById(R.id.btn_focus);
        }

    }
}
