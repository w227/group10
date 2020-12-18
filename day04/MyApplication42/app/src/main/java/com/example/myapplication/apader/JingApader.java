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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.R;
import com.example.myapplication.bean.JingBean;

import java.util.ArrayList;
import java.util.List;

public class JingApader extends RecyclerView.Adapter<JingApader.ViewHolder> {
    private Context context;
    List<JingBean.DataBean.ExpTopBean.ListBean> listBeans=new ArrayList<> (  );

    public JingApader(Context context) {

        this.context = context;
    }
    public void addslist( List<JingBean.DataBean.ExpTopBean.ListBean> listBeans){
        this.listBeans.addAll ( listBeans );
        notifyDataSetChanged ();

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju5, null, false );

        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions ();
        requestOptions.transform ( new CircleCrop () );
        Glide.with ( context ).load ( listBeans.get ( position ).getHeadUrl () ).apply ( requestOptions ).into ( holder.img51 );
        holder.ts51.setText ( listBeans.get ( position ).getNickName () );
        holder.ts52.setText ( listBeans.get ( position ).getProvince () );
        holder.ts53.setText ( ""+listBeans.get ( position ).getExpScore ()+"经验" );

    }

    @Override
    public int getItemCount() {
        return listBeans.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img51;
        private TextView ts51;
        private TextView ts52;
        private TextView ts53;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            img51=itemView.findViewById ( R.id.img51 );
            ts51=itemView.findViewById ( R.id.ts51 );
            ts52=itemView.findViewById ( R.id.ts52 );
            ts53=itemView.findViewById ( R.id.ts53 );
        }
    }
}
