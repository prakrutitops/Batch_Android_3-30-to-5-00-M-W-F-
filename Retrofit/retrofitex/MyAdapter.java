package com.example.retrofitex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myview>
{
    Context context;
    List<Model>list;

    MyAdapter(  Context context, List<Model>list)
    {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.design,parent,false);
        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position)
    {
        holder.t1.setText(list.get(position).name);
        holder.t2.setText(list.get(position).price);
        holder.t3.setText(list.get(position).des);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class Myview extends RecyclerView.ViewHolder
    {
        TextView t1,t2,t3;

        public Myview(@NonNull View itemView)
        {
            super(itemView);

            t1=itemView.findViewById(R.id.txt1);
            t2=itemView.findViewById(R.id.txt2);
            t3=itemView.findViewById(R.id.txt3);
        }
    }
}
