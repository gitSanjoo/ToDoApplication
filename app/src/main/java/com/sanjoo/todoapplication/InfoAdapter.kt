package com.sanjoo.todoapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.sanjoo.todoapplication.data.ItemInfoModel

class InfoAdapter(private val infolist:List<ItemInfoModel>):RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {



    class InfoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val image:ImageView=itemView.findViewById(R.id.rv_icon)
        val topic:TextView=itemView.findViewById(R.id.tv_topic)
        val description:TextView=itemView.findViewById(R.id.tv_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item,parent,false)
        return InfoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return infolist.size
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val ItemInfoModel=infolist[position]
        holder.image.setImageResource(ItemInfoModel.img)
        holder.topic.text=ItemInfoModel.topic
        holder.description.text=ItemInfoModel.description
    }
}