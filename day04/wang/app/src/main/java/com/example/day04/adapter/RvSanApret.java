package com.example.day04.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.day04.R;
import com.example.day04.activity.HomeActivity;
import com.example.day04.activity.ShowActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvSanApret extends RecyclerView.Adapter {
//    private ArrayList<Integer> list;
    private Context context;

    public RvSanApret( Context context) {
//        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv2, parent, false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder2 viewHolder2 = (ViewHolder2) holder;

        Glide.with(context).load(R.drawable.a)
                .apply(new RequestOptions().circleCrop())
                .into(viewHolder2.iv1);
        Glide.with(context).load(R.drawable.b)
                .apply(new RequestOptions().circleCrop())
                .into(viewHolder2.iv2);
        Glide.with(context).load(R.drawable.c)
                .apply(new RequestOptions().circleCrop())
                .into(viewHolder2.iv3);

        viewHolder2.iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, HomeActivity.class));

            }
        });

        viewHolder2.iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ShowActivity.class));

            }
        });
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.iv1)
        ImageView iv1;
        @BindView(R.id.iv2)
        ImageView iv2;
        @BindView(R.id.iv3)
        ImageView iv3;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
