package com.example.data12_17homework.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.data12_17homework.R;
import com.example.data12_17homework.bean.TextBean;

import java.util.List;

public class RvTextAdapter extends RecyclerView.Adapter<RvTextAdapter.ViewHolder> {
    private final Context context;
    private final List<TextBean.DataBeanX.DataBean> dataBeanList;

    public RvTextAdapter(Context context, List<TextBean.DataBeanX.DataBean> dataBeanList) {

        this.context = context;
        this.dataBeanList = dataBeanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item_text, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextBean.DataBeanX.DataBean dataBean = dataBeanList.get(position);

        Glide.with(context).load(dataBean.getAuthor().getAvatar()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(holder.iv_avatar);

        holder.tv_name.setText(dataBean.getAuthor().getName());
        String feeds_text = (String) dataBean.getFeeds_text();

        holder.tv_feeds_text.setText(feeds_text);
    }

    @Override
    public int getItemCount() {
        return dataBeanList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv_avatar;
        public TextView tv_name;
        public TextView tv_feeds_text;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv_avatar = (ImageView) rootView.findViewById(R.id.iv_avatar);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_feeds_text = (TextView) rootView.findViewById(R.id.tv_feeds_text);
        }

    }
}
