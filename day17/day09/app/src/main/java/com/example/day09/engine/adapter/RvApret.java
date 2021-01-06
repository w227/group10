package com.example.day09.engine.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day09.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RvApret extends RecyclerView.Adapter {

    private static final int RV1 = 1;
    private static final int RV2 = 2;
    private static final int RV3 = 3;
    private static final int RV4 = 4;
    private Context context;

    public RvApret(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 4 == 0) {
            return RV1;
        } else if (position % 4 == 1) {
            return RV2;
        } else if (position % 4 == 2) {
            return RV3;
        } else if (position % 4 == 3) {
            return RV4;
        }
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case RV1:
                View view1 = LayoutInflater.from(context).inflate(R.layout.adapter_rv1, parent, false);
                return new ViewHolder_RV1(view1);

            case RV2:
                View view2 = LayoutInflater.from(context).inflate(R.layout.adapter_rv2, parent, false);
                return new ViewHolder_RV2(view2);

            case RV3:
                View view3 = LayoutInflater.from(context).inflate(R.layout.adapter_rv3, parent, false);
                return new ViewHolder_RV3(view3);

            case RV4:
                View view4 = LayoutInflater.from(context).inflate(R.layout.adapter_rv4, parent, false);
                return new ViewHolder_RV4(view4);


        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 4;
    }


    static
    class ViewHolder_RV1 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_rv1)
        TextView tvRv1;

        ViewHolder_RV1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewHolder_RV2 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_rv2)
        TextView tvRv2;

        ViewHolder_RV2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static
    class ViewHolder_RV3 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_rv3)
        TextView tvRv3;

        ViewHolder_RV3(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    static
    class ViewHolder_RV4 extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_rv4)
        TextView tvRv4;

        ViewHolder_RV4(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
