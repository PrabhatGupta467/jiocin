package com.example.jiocin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RecyclerAddapter( val context : Context, val arrContact : ArrayList<ContactModel>) : RecyclerView.Adapter<RecyclerAddapter.ViewHolder>() {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
      val image: ImageView = itemView.findViewById(R.id.imgV)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //val temp : ContactModel=arrContact.get(position)
        Glide.with(context).load(arrContact[position].image).into(holder.image)
        //holder.image.setImageResource(arrContact[position].image)
        holder.image.setOnClickListener {
            
        }

    }

    override fun getItemCount(): Int {
        return arrContact.size
    }
}