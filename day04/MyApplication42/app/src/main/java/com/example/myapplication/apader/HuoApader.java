package com.example.myapplication.apader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.bean.ListBean;

import java.util.List;

public class HuoApader extends RecyclerView.Adapter<HuoApader.ViewHolder> {
    private final Context context;
    private final List<ListBean.DataBean> list;

    public HuoApader(Context context, List<ListBean.DataBean> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju4, null, false );
        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ts2.setText ( list.get ( position ).getNickName () );
        holder.ts22.setText ( list.get ( position ).getSocialTitle () );
        RequestOptions requestOptions = new RequestOptions ();
        requestOptions.transform ( new RoundedCorners ( 15 ) );
        Glide.with ( context ).load ( list.get ( position ).getHeadUrl () ).apply ( requestOptions ).into ( holder.img2 );

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ts2;
        private TextView ts22;
        private ImageView img2;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            ts2=itemView.findViewById ( R.id.ts2 );
            ts22=itemView.findViewById ( R.id.ts22 );
            img2=itemView.findViewById ( R.id.img2 );
        }
    }
}
