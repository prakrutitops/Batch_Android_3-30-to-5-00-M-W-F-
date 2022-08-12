package com.example.animationex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReceiverEx extends AppCompatActivity
{
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_ex);

      /*  btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
*/
        IntentFilter i =new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        MyReceiver m =new MyReceiver();
        registerReceiver(m,i);

       /* btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });*/

    }
}