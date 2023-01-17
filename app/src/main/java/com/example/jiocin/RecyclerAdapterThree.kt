package com.example.jiocin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapterThree (val context : Context, val arrContactThree : ArrayList<ModelThree>) : RecyclerView.Adapter<RecyclerAdapterThree.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imgVieww)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_three,parent,false)))
    }

    override fun getItemCount(): Int {
        return arrContactThree.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(arrContactThree[position].image).into(holder.image)
        holder.image.setOnClickListener {

        }
    }
}