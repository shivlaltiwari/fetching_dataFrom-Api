package com.example.api_data

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_url ="https://run.mocky.io/"
interface ApiInterface {
    // Request method and URL specified in the annotation
    @GET("v3/78d355ea-c65e-4734-8b77-aa3b583c22b8")

    fun getUserData() : Call<MyData>
}
//retrofit object i.e singleton object
object ApiService{
    lateinit var instance : ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        instance = retrofit.create(ApiInterface :: class.java)
    }

}