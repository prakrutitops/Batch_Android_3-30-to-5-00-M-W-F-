package com.example.e_greetingsapp.Adapter

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.e_greetingsapp.Activity.FullScreenActivity
import com.example.e_greetingsapp.Model.Category_Model
import com.example.e_greetingsapp.Model.Dashboard_Model
import com.example.e_greetingsapp.R
import com.squareup.picasso.Picasso

class Category_Adapter(var context: Context, var list: List<Category_Model>) :BaseAdapter()
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
        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.design_category,p2,false)
        var image:ImageView=view.findViewById(R.id.img_category)

         Picasso.get().load(list.get(p0).image_category).placeholder(R.mipmap.ic_launcher).into(image)
            image.setOnClickListener()
            {
                var i2 =Intent(context,FullScreenActivity::class.java)
                i2.putExtra("image_position",list.get(p0).image_category)
                i2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i2)
            }
        return view
    }


}