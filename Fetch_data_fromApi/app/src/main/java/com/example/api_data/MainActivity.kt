package com.example.api_data

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val BASE_URL = "https://run.mocky.io/"

class MainActivity : AppCompatActivity() {
    lateinit var adapter: ChannelAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyData()

    }

    private fun getMyData() {
        val res = ApiService.instance.getUserData()
        res.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                val results = response.body()
                if (response.isSuccessful) {
                    if (results != null) {
                        Log.d("message", results.toString())
                        adapter = ChannelAdapter(this@MainActivity, results)
                        val channelList = findViewById<RecyclerView>(R.id.channelList)
                        channelList.layoutManager = LinearLayoutManager(this@MainActivity)
                        channelList.adapter = adapter

                    }
                }
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                Log.d("message", "Error in Fetching Data")

            }
        })


    }


}