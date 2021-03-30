package com.onearmy.networkcall.mainActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.onearmy.networkcall.R
import okhttp3.internal.http.hasBody

class Adaptor(private val list:List<Model>):RecyclerView.Adapter<Adaptor.MyViewHolder>() {
    class MyViewHolder( itemView: View) : RecyclerView.ViewHolder(itemView) {
        var body:TextView = itemView.findViewById(R.id.TextViewbody)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptor.MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: Adaptor.MyViewHolder, position: Int) {
        val item = list[position]
        holder.body.text =item.body
    }

    override fun getItemCount(): Int {
        return list.size
    }

}