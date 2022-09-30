package com.example.foodmanagement.restaurant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodmanagement.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapterResto1 extends FirebaseRecyclerAdapter<RestaurantInfo,MyAdapterResto1.myViewHolder>{



    public MyAdapterResto1(@NonNull FirebaseRecyclerOptions<RestaurantInfo> options) {
        super(options);
    }


    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull RestaurantInfo model) {
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getQty());
        holder.t3.setText(model.getDatep());
        holder.t4.setText(model.getTimep());
        holder.t5.setText(model.getDatef());
        holder.t6.setText(model.getTimef());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row2, parent, false);
        return new myViewHolder(view);

    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, t3,t4,t5,t6;
        Button b1,b2;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.p1);
            t2 = itemView.findViewById(R.id.p2);
            t3 = itemView.findViewById(R.id.p3);
            t4 = itemView.findViewById(R.id.p4);
            t5 = itemView.findViewById(R.id.p5);
            t6 = itemView.findViewById(R.id.p6);
//            b1=itemView.findViewById(R.id.accept);
//            b2=itemView.findViewById(R.id.delete);

        }

    }

}
