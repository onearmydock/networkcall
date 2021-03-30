package com.onearmy.networkcall.mainActivity

import com.onearmy.networkcall.MainActivity
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Servicebuilder {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun<T> buildService(service:Class<T>):T{
        return retrofit.create(service)
    }
}