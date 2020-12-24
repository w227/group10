package com.example.day09.engine.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.day09.R;
import com.example.day09.base.App;
import com.example.day09.mvp.ui.activity.DiAvtivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvApret extends RecyclerView.Adapter {


    //    private ArrayList<Integer> list;
    private Context context;

    public RvApret(Context context) {
//        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);

        return new ViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder1 viewHolder1 = (ViewHolder1) holder;
        Glide.with(context).load(R.drawable.fa).into(viewHolder1.ivRv);
        Glide.with(context).load(R.drawable.shang).into(viewHolder1.iv1Rv);
        Glide.with(context).load(R.drawable.shou).into(viewHolder1.iv2Rv);
        Glide.with(context).load(R.drawable.wo).into(viewHolder1.iv3Rv);

        viewHolder1.tvRv.setText("百度地图");

        viewHolder1.tvRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(context, DiAvtivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_rv)
        ImageView ivRv;
        @BindView(R.id.iv1_rv)
        ImageView iv1Rv;
        @BindView(R.id.iv2_rv)
        ImageView iv2Rv;
        @BindView(R.id.iv3_rv)
        ImageView iv3Rv;
        @BindView(R.id.tv_rv)
        TextView tvRv;
        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
