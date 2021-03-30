package com.onearmy.networkcall.mainActivity

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApi {
    @GET("posts")
    fun getlist():Call<List<Model>>
}