package com.example.api_data

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fasterxml.jackson.module.kotlin.*
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
                val data = response.body()

//                val mapper = jacksonObjectMapper()
//                var personMap: Map<String, Any> = mapper.readValue(data!!.result)

//                val gson = Gson()
//                val mapData: Map<String, Any> = gson.fromJson<String, Any>(data!!.result, Result::class.java)
//                Log.d("data", mapData.toString())


                if (response.isSuccessful) {
                    if (data != null) {
                        Log.d("message", data.toString())
                        val mapKeys: ArrayList<String> = ArrayList<String> ()
                        val keySet = data.result.keys
                        mapKeys.addAll(keySet)
                        Log.d("keys", mapKeys.toString())
                        val showList: List<X20210730> = data.result["2021-07-30"]!!
                        adapter = ChannelAdapter(this@MainActivity, data, showList)
                       
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