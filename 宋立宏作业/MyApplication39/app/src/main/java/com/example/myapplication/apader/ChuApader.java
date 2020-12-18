package com.example.myapplication.apader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.Shu;

import java.util.List;

public class ChuApader extends RecyclerView.Adapter<ChuApader.ViewHolder> {
    private final Context context;
    private final List<Shu> shus;

    public ChuApader(Context context, List<Shu> shus) {

        this.context = context;
        this.shus = shus;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from ( context ).inflate ( R.layout.buju9, null, false );

        return new ViewHolder ( inflate );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ts91.setText ( shus.get ( position ).getTitle () );
        holder.ts92.setText ( shus.get ( position ).getIntro () );
        Glide.with ( context ).load (  shus.get ( position ).getIcon ()).into ( holder.img9 );


    }

    @Override
    public int getItemCount() {
        return shus.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img9;
        private TextView ts91;
        private TextView ts92;
        private Button bt2;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            img9=itemView.findViewById ( R.id.img9 );
            ts91=itemView.findViewById ( R.id.ts91 );
            ts92=itemView.findViewById ( R.id.ts92 );
            bt2=itemView.findViewById ( R.id.bt2 );
        }
    }
}
