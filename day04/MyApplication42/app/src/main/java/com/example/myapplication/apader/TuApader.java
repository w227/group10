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
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.bean.TuBean;

import java.util.ArrayList;
import java.util.List;

public class TuApader extends RecyclerView.Adapter<TuApader.ViewHolder> {
    private Context context;
    List<TuBean.DataBean.TongQianTopBean.ListBean> listBeans=new ArrayList<> (  );

    public TuApader(Context context) {

        this.context = context;
    }
    public void addlists(List<TuBean.DataBean.TongQianTopBean.ListBean> listBeans){
        this.listBeans.addAll ( listBeans );
        notifyDataSetChanged ();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju7, null, false );
        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ts71.setText ( listBeans.get ( position ).getNickName () );
        holder.ts72.setText ( listBeans.get ( position ).getProvince () );
        holder.ts73.setText ( ""+listBeans.get ( position ).getExpScore () +"铜");
        RequestOptions requestOptions = new RequestOptions ();
        requestOptions.transform ( new CircleCrop () );
        Glide.with ( context ).load ( listBeans.get ( position ).getHeadUrl () ).apply (requestOptions  ).into ( holder.img71 );

    }

    @Override
    public int getItemCount() {
        return listBeans.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img71;
        private TextView ts71;
        private TextView ts72;
        private TextView ts73;


        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            img71=itemView.findViewById ( R.id.img71 );
            ts71=itemView.findViewById ( R.id.ts71 );
            ts72=itemView.findViewById ( R.id.ts72 );
            ts73=itemView.findViewById ( R.id.ts73 );
        }
    }
}
