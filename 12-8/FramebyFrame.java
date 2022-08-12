package com.example.animationex;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class FramebyFrame extends AppCompatActivity
{
    private ImageView imageView;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frameby_frame);

        imageView=findViewById(R.id.imageView);
        animationDrawable=(AnimationDrawable)(imageView.getBackground());

        if(animationDrawable.isRunning()){
            animationDrawable.stop();
        }
        else{
            animationDrawable.start();
        }
    }
}