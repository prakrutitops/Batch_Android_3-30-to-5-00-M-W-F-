package com.example.e_greetings.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_greetings.Model.Dashboard_Model
import com.example.e_greetings.MyAdapter
import com.example.e_greetings.Other.ApiClient
import com.example.e_greetings.Other.Apiinterface
import com.example.e_greetings.R
import com.example.e_greetings.databinding.ActivityDashboardBinding
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class DashboardActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityDashboardBinding
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<Dashboard_Model>
    lateinit var apiinterface: Apiinterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        Toast.makeText(applicationContext,
            "Welcome " + sharedPreferences.getString("mob", "error"),
            Toast.LENGTH_LONG).show()

        recyclerView = findViewById(R.id.recycler)
        list = ArrayList<Dashboard_Model>()

        val rl: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = rl

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        val call = apiinterface!!.viewdata

        call!!.enqueue(object : Call<List<Dashboard_Model?>>, Callback<List<Dashboard_Model?>?> {
            /*  override fun onResponse(call: Call<List<Model?>>, response: Response<List<Model?>>) {

              }

              override fun onFailure(call: Call<List<Model?>>, t: Throwable) {}*/
            override fun onResponse(call: Call<List<Dashboard_Model?>?>, response: Response<List<Dashboard_Model?>?>) {
                list = response.body() as MutableList<Dashboard_Model>
                val customAdapter = MyAdapter(applicationContext, list!!)
                recyclerView.adapter = customAdapter
            }

            override fun onFailure(call: Call<List<Dashboard_Model?>?>, t: Throwable) {
                Toast.makeText(applicationContext, "Error", Toast.LENGTH_LONG).show()
            }

            override fun clone(): Call<List<Dashboard_Model?>> {
                TODO("Not yet implemented")
            }

            override fun execute(): Response<List<Dashboard_Model?>> {
                TODO("Not yet implemented")
            }

            override fun enqueue(callback: Callback<List<Dashboard_Model?>>) {
                TODO("Not yet implemented")
            }

            override fun isExecuted(): Boolean {
                TODO("Not yet implemented")
            }

            override fun cancel() {
                TODO("Not yet implemented")
            }

            override fun isCanceled(): Boolean {
                TODO("Not yet implemented")
            }

            override fun request(): Request {
                TODO("Not yet implemented")
            }


        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(this, LoginActivity::class.java))
            }

        }


        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        finishAffinity()
    }
}