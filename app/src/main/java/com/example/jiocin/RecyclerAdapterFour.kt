package com.example.jiocin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapterFour (val context : Context, val arrContact : ArrayList<ModelFour>) : RecyclerView.Adapter<RecyclerAdapterFour.ViewHolder>() {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imgX)
        val centerText: TextView =itemView.findViewById(R.id.tvX)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return (ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_view_four,parent,false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //val temp : ContactModel=arrContact.get(position)
        Glide.with(context).load(arrContact[position].image).into(holder.image)
        holder.centerText.text=arrContact[position].dec

        //holder.image.setImageResource(arrContact[position].image)
        holder.image.setOnClickListener {
            val intent= Intent(context,MoreLikesHorizontal::class.java)
            ContextCompat.startActivity(context, intent, null)
        }

    }

    override fun getItemCount(): Int {
        return arrContact.size
    }
}