package com.example.capstone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Member> list;

    public MyAdapter(Context context, ArrayList<Member> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(context).inflate(R.layout.object,parent,false);
       return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull  MyAdapter.MyViewHolder holder, int position) {
    Member member=list.get(position);
    holder.tvsymp.setText(member.getSymptoms());
    holder.tvtrig.setText(member.getTriggers());
    holder.tvmed.setText(member.getMed());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvsymp,tvtrig,tvmed;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);

            tvsymp=itemView.findViewById(R.id.tvsymp);
            tvtrig=itemView.findViewById(R.id.tvtrig);
            tvmed=itemView.findViewById(R.id.tvmed);

        }
    }


}
