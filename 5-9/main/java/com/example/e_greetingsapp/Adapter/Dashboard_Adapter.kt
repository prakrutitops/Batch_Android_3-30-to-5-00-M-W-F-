package com.example.e_greetingsapp.Adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.e_greetingsapp.Model.Dashboard_Model
import com.example.e_greetingsapp.R
import com.squareup.picasso.Picasso

class Dashboard_Adapter(var context: Context, var list: List<Dashboard_Model>) :BaseAdapter()
{


    override fun getCount(): Int
    {
        return  list.size
    }

    override fun getItem(p0: Int): Any
    {
        return  p0
    }

    override fun getItemId(p0: Int): Long
    {
        return  p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        var inflater=LayoutInflater.from(context);
        var view=inflater.inflate(R.layout.design_dashboard,p2,false)
        var image:ImageView=view.findViewById(R.id.img_dashbaord)
        var txt:TextView=view.findViewById(R.id.txt_dashboard)

        Picasso.get().load(list.get(p0).image_dashboard).placeholder(R.mipmap.ic_launcher).into(image)
        //Glide.with(context).load(list.get(p0).image_dashboard).into(image)
        txt.setText(list.get(p0).title_board)
        return view
    }


}