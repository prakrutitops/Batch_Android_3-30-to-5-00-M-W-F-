package com.example.e_greetings.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_greetings.R
import com.example.e_greetings.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        var binding: ActivityLoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNewUser.setOnClickListener {

            startActivity(Intent(this,SignupActivity::class.java))

        }


    }
}