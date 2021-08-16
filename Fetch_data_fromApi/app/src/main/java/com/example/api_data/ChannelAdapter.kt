package com.example.api_data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChannelAdapter (val context: Context, val myDatas: MyData, val movieDate: List<X20210730>) : RecyclerView.Adapter<ChannelAdapter.ChannelDataViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelDataViewHolder {
        val view : View? = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false)
        return ChannelDataViewHolder(view!!)
    }

    override fun onBindViewHolder(holder: ChannelDataViewHolder, position: Int) {



        holder.programId.text = movieDate[position].id.toString()
        holder.programName.text = movieDate[position].programme_name
       
    }

    override fun getItemCount(): Int {
        return myDatas.result.size

    }
    class ChannelDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val programId = itemView.findViewById<TextView>(R.id.programId)
        val programName = itemView.findViewById<TextView>(R.id.programName)

    }
}