package com.example.retrofitex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity
{
    EditText edt1,edt2,edt3;
    Button btn1,btn2;
    Apiinterface apiinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        edt1=findViewById(R.id.edt1);
        edt2=findViewById(R.id.edt2);
        edt3=findViewById(R.id.edt3);
        btn1=findViewById(R.id.btn1);

        Intent i =getIntent();

        int id=i.getIntExtra("id",404);
        String name=i.getStringExtra("name");
        String price=i.getStringExtra("price");
        String des=i.getStringExtra("desc");

        edt1.setText(name);
        edt2.setText(price);
        edt3.setText(des);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name=edt1.getText().toString();
                String price=edt2.getText().toString();
                String des=edt3.getText().toString();

                apiinterface=ApiClient.getapiclient().create(Apiinterface.class);
                Call<Model>call= apiinterface.updatedata(id,name,price,des);
                call.enqueue(new Callback<Model>() {
                    @Override
                    public void onResponse(Call<Model> call, Response<Model> response) {

                    }

                    @Override
                    public void onFailure(Call<Model> call, Throwable t) {

                    }
                });

                startActivity(new Intent(UpdateActivity.this,MainActivity2.class));

            }
        });



    }
}