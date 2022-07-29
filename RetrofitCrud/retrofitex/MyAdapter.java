package com.example.retrofitex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myview>
{
    Context context;
    List<Model> dataList;
    Apiinterface api;

    public MyAdapter(Context context, List<Model> dataList)
    {
        this.context=context;
        this.dataList = dataList;
    }

    @Override
    public Myview onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false);

        return new Myview(view);
    }

    @Override
    public void onBindViewHolder(Myview holder, @SuppressLint("RecyclerView") int position) {
        holder.t1.setText(dataList.get(position).getName());
        holder.t2.setText(dataList.get(position).getPrice());
        holder.t3.setText(dataList.get(position).getDes());




        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert=new AlertDialog.Builder(v.getContext());
                alert.setTitle("select?");
                alert.setPositiveButton("update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent i=new Intent(context, UpdateActivity.class);

                        i.putExtra("id",dataList.get(position).getId());
                        i.putExtra("name",dataList.get(position).getName());
                        i.putExtra("price",dataList.get(position).getPrice());
                        i.putExtra("desc",dataList.get(position).getDes());

                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        v.getContext().startActivity(i);





                    }
                });
                alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        api = ApiClient.getapiclient().create(Apiinterface.class);
                        Call<Model> call = api.deletedata((dataList.get(position).getId()));
                        call.enqueue(new Callback<Model>() {
                            @Override
                            public void onResponse(Call<Model> call, Response<Model> response) {


                                Toast.makeText(v.getContext(), "deleted", Toast.LENGTH_SHORT).show();

                                Intent i =new Intent();
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            }

                            @Override
                            public void onFailure(Call<Model> call, Throwable t) {

                            }
                        });
                        v.getContext().startActivity(new Intent(v.getContext(),MainActivity2.class));
                    }
                });
                alert.show();



            }
        });


    }







    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Myview extends RecyclerView.ViewHolder {
        TextView t1, t2,t3;

        public Myview(View itemView) {
            super(itemView);
            t1=itemView.findViewById(R.id.txt1);
            t2=itemView.findViewById(R.id.txt2);
            t3=itemView.findViewById(R.id.txt3);

        }
    }
}