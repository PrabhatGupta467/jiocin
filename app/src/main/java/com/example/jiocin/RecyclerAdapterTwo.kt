package com.example.jiocin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

 class RecyclerAdapterTwo(val context : Context, val arrContactTwo : ArrayList<ModelTwo>) : RecyclerView.Adapter<RecyclerAdapterTwo.ViewHolder>() {

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imgView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_two,parent,false)))
    }

     override fun getItemCount(): Int {
        return arrContactTwo.size
    }



     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         Glide.with(context).load(arrContactTwo[position].image).into(holder.image)
         holder.image.setOnClickListener {

         }
     }
 }