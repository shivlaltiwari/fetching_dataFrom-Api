package com.example.api_data

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class ChannelAdapter (val context: Context, val movieDate: List<X20210730>, val mapKeys: List<String>,val myData: MyData, val isDetailView: Boolean) : RecyclerView.Adapter<ChannelAdapter.ChannelDataViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelDataViewHolder {
        val view : View? = LayoutInflater.from(context).inflate(R.layout.item_layout, parent,false)
//        view?.setOnClickListener {
//            if(!isDetailView)
//            {
//                val intent = Intent(context, DetailsActivity::class.java)
//                intent.putExtra("date", mapKeys[0])
//                intent.putExtra("programStr", movieDate[0].programme_name)
//                context.startActivity(intent)
//            }
//
//        }
        return ChannelDataViewHolder(view!!)
    }
    override fun onBindViewHolder(holder: ChannelDataViewHolder, position: Int) {
        if(isDetailView)
        {
            val currentData = movieDate[position].id

            holder.programId.text = movieDate[position].id.toString()
            holder.programName.text  = movieDate[position].programme_name
            holder.programId.visibility = View.VISIBLE
            holder.programName.visibility = View.VISIBLE
            holder.programDate.visibility = View.GONE
        }
        else
        {
           // Log.d("AjDebug", "keys $position and ${mapKeys[position]}")
            holder.programDate.text = mapKeys[position]
            holder.programDate.setOnClickListener {
                if(!isDetailView)
                {val intent = Intent(context, DetailsActivity::class.java)
                    intent.putExtra("date", mapKeys[position])
                    intent.putExtra("programStr", Gson().toJson(myData.result[mapKeys[position]]))
                    context.startActivity(intent)
                }

            }
        }

//        holder.programId.text = movieDate[position].id.toString()
//        holder.programName.text = movieDate[position].programme_name
    }

    override fun getItemCount(): Int {
        if(isDetailView)
        {
            return movieDate.size
        }
        else
        {
            return mapKeys.size
        }
       // return movieDate.size

    }
    class ChannelDataViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val programDate = itemView.findViewById<TextView>(R.id.ProgramDate)
        val programId = itemView.findViewById<TextView>(R.id.programId)
        val programName = itemView.findViewById<TextView>(R.id.programName)


    }
}


//data.result.get(mapKeys.get(index=1))[1]
//mapKeys.get(index=1)