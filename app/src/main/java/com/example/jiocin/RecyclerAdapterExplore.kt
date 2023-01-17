package com.example.jiocin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapterExplore (val context : Context, val arrContactExplore : ArrayList<ModelExplore>) : RecyclerView.Adapter<RecyclerAdapterExplore.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imgViewExplore)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_explore,parent,false)))
    }

    override fun getItemCount(): Int {
        return arrContactExplore.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(arrContactExplore[position].image)
        holder.image.setOnClickListener {

        }
    }
}