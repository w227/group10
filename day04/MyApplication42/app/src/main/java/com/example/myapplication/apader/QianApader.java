package com.example.myapplication.apader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.bean.JingBean;

import java.util.ArrayList;
import java.util.List;

public class QianApader extends RecyclerView.Adapter<QianApader.ViewHolder> {
    private Context context;
    List<JingBean.DataBean.ExpTopBean.ListBean> listBeans=new ArrayList<> (  );

    public QianApader(Context context) {

        this.context = context;
    }
    public void addlist(List<JingBean.DataBean.ExpTopBean.ListBean> listBeans){
        this.listBeans.addAll ( listBeans );
        notifyDataSetChanged ();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju6, null, false );
        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.ts61.setText ( listBeans.get ( position ).getNickName () );
            holder.ts62.setText ( listBeans.get ( position ).getProvince () );
            holder.ts63.setText ( "连续签到"+listBeans.get ( position ).getTongQian () +"天");
        RequestOptions requestOptions = new RequestOptions ();
        requestOptions.transform ( new CircleCrop () );
        Glide.with ( context ).load ( listBeans.get ( position ).getHeadUrl () ).apply (requestOptions  ).into ( holder.img61 );

    }

    @Override
    public int getItemCount() {
        return listBeans.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img61;
        private TextView ts61;
        private TextView ts62;
        private TextView ts63;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            img61=itemView.findViewById ( R.id.img61 );
            ts61=itemView.findViewById ( R.id.ts61 );
            ts62=itemView.findViewById ( R.id.ts62 );
            ts63=itemView.findViewById ( R.id.ts63 );
        }
    }
}
