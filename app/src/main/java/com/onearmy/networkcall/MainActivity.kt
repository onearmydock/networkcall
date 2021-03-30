package com.onearmy.networkcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onearmy.networkcall.mainActivity.Adaptor
import com.onearmy.networkcall.mainActivity.Model

import com.onearmy.networkcall.mainActivity.RetrofitApi
import com.onearmy.networkcall.mainActivity.Servicebuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayout : LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycleview = findViewById<RecyclerView>(R.id.RecycleView)

        linearLayout = LinearLayoutManager(this)
        recycleview.layoutManager = linearLayout
        recycleview.hasFixedSize()



        Log.d("myerror", "onCreate: ")
        val request = Servicebuilder.buildService(RetrofitApi::class.java)
        val call = request.getlist()
        call.enqueue(object : Callback<List<Model>>{
            override fun onResponse(call: Call<List<Model>>?, response: Response<List<Model>>?) {
                if (response != null) {
                    if(response.isSuccess){
                        var data = response.body()
                        val myadapter =Adaptor(data)
                        recycleview.adapter = myadapter

                    }
                }
                else
                    Log.d("myerror", "onResponse: response is null")
            }

            override fun onFailure(call: Call<List<Model>>?, t: Throwable?) {
                Log.d("myerror", "onFailure: ")

            }

        })

    }

}