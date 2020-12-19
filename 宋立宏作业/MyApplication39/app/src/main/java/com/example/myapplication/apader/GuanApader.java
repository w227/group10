package com.example.myapplication.apader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.App;
import com.example.myapplication.R;
import com.example.myapplication.Shu;
import com.example.myapplication.bean.GuanBean;

import java.util.ArrayList;
import java.util.List;

public class GuanApader extends RecyclerView.Adapter<GuanApader.ViewHolder>{


    private Context context;
    List<GuanBean.DataBeanX.DataBean> list=new ArrayList<> (  );

    public GuanApader(Context context) {

        this.context = context;
    }
    public void addlisys(List<GuanBean.DataBeanX.DataBean> list){
        this.list.addAll ( list );
        notifyDataSetChanged ();

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju8, null, false );
        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions ();
        requestOptions.transform ( new CircleCrop () );
        Glide.with ( context ).load ( list.get ( position ).getIcon () ).apply ( requestOptions ).into ( holder.img8 );
        holder.ts81.setText ( list.get ( position ).getTitle () );
        holder.ts82.setText ( list.get ( position ).getIntro () );
        holder.bt1.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Shu shu = new Shu ();
                shu.setTitle ( list.get ( position ).getTitle () );
                shu.setIcon ( list.get ( position ).getIcon () );
                shu.setIntro ( list.get ( position ).getIntro () );
                long insert = App.getDaoSession ().getShuDao ().insert ( shu );
                if (insert>0){
                    Toast.makeText ( context, "成功", Toast.LENGTH_SHORT ).show ();
                }else {
                    Toast.makeText ( context, "失败", Toast.LENGTH_SHORT ).show ();
                }
            }
        } );

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img8;
        private TextView ts81;
        private TextView ts82;
        private Button bt1;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            img8=itemView.findViewById ( R.id.img8 );
            ts81=itemView.findViewById ( R.id.ts81 );
            ts82=itemView.findViewById ( R.id.ts82 );
            bt1=itemView.findViewById ( R.id.bt1 );
        }
    }
}
