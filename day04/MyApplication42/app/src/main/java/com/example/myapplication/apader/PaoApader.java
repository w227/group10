package com.example.myapplication.apader;

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
import com.example.myapplication.Main2Activity;
import com.example.myapplication.R;
import com.example.myapplication.bean.ListBean;

import java.util.List;

public class PaoApader extends RecyclerView.Adapter<PaoApader.ViewHolder> {


    private final Context context;
    private final List<ListBean.DataBean> list;

    public PaoApader(Context context, List<ListBean.DataBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju3, null, false );
        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tst1.setText ( "袍子" );
        Glide.with ( context ).load ( R.drawable.a3).into ( holder.imgs1 );
        holder.tst2.setText ( "社团" );
        Glide.with ( context ).load ( R.drawable.a4).into ( holder.imgs2 );
        holder.tst3.setText ( "排行榜" );
        Glide.with ( context ).load ( R.drawable.a6).into ( holder.imgs3 );

        holder.itemView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( context, Main2Activity.class );

                context.startActivity ( intent );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgs1;
        private TextView tst1;
        private ImageView imgs2;
        private TextView tst2;
        private ImageView imgs3;
        private TextView tst3;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            imgs1=itemView.findViewById ( R.id.imgs1 );
            imgs2=itemView.findViewById ( R.id.imgs2 );
            imgs3=itemView.findViewById ( R.id.imgs3 );
            tst1=itemView.findViewById ( R.id.tst1 );
            tst2=itemView.findViewById ( R.id.tst2 );
            tst3=itemView.findViewById ( R.id.tst3 );
        }
    }
}
