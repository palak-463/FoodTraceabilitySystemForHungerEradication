package com.example.foodmanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MyAdapter extends FirebaseRecyclerAdapter<DisplayInfo,MyAdapter.myViewHolder> {

    public MyAdapter(@NonNull FirebaseRecyclerOptions<DisplayInfo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull DisplayInfo model) {
          holder.t1.setText(model.getGname());
          holder.t2.setText(model.getQty());
          holder.t3.setText(model.getPrice());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
            return new myViewHolder(view);

    }


    class myViewHolder extends RecyclerView.ViewHolder {
        TextView t1, t2, t3;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.p1);
            t2 = itemView.findViewById(R.id.p2);
            t3 = itemView.findViewById(R.id.p3);
        }

    }
}