package com.example.e_greetings.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.e_greetings.Other.ApiClient
import com.example.e_greetings.Other.Apiinterface
import com.example.e_greetings.R
import com.example.e_greetings.databinding.ActivityLoginBinding
import com.example.e_greetings.databinding.ActivitySignupBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity()
{
    private lateinit var binding: ActivitySignupBinding
    lateinit var apiinterface: Apiinterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivitySignupBinding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAlreadyAccount.setOnClickListener {

            startActivity(Intent(this,LoginActivity::class.java))
        }
        binding.btnRegister.setOnClickListener {

            var fname = binding.edtFirstName.text.toString()
            var lname = binding.edtLastName.text.toString()
            var mobile = binding.edtPhone.text.toString()
            var email = binding.edtEmail.text.toString()
            var pass = binding.edtPassword.text.toString()
            var cpass = binding.edtConfirmPassword.text.toString()

            if(pass.equals(cpass))
            {
                apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
                var registercall: Call<Void> = apiinterface.registerdetail(fname, lname, mobile, email, pass)
                registercall.enqueue(object : Callback<Void?> {
                    override fun onResponse(call: Call<Void?>, response: Response<Void?>, )
                    {



                    }

                    override fun onFailure(call: Call<Void?>, t: Throwable)
                    {


                        //Toast.makeText(applicationContext, "" + t, Toast.LENGTH_LONG).show()
                        Log.d("XyzError",t.message.toString())
                    }
                })
                startActivity(Intent(this, LoginActivity::class.java))
            }
            else
            {
                Toast.makeText(applicationContext,"Your Password and confirm password are not same",Toast.LENGTH_LONG).show()
            }
            }



    }
}