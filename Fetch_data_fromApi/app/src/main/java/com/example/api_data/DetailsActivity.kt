package com.example.api_data

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class DetailsActivity : AppCompatActivity() {
    lateinit var adapter: ChannelAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bundle = intent.extras
        val date = bundle?.getString("date")
        val programStr = bundle?.getString("programStr")
        Log.d("data is ", date.toString())
        Log.d("programStr is ", programStr.toString())
        val gson = Gson()
        val listType: Type = object : TypeToken<ArrayList<X20210730?>?>() {}.type
        val prog: List<X20210730> = gson.fromJson<List<X20210730>>(programStr, listType)
        prog.forEach { it ->
            Log.d("Prog Data", "${it.id}, ${it.programme_name}")
        }
        adapter = ChannelAdapter(this, prog, ArrayList<String>(), MyData("", 0, mapOf()), true)
        val channelList = findViewById<RecyclerView>(R.id.channelList)
        channelList.adapter = adapter
        channelList.layoutManager = LinearLayoutManager(this)
    }
}