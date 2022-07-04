package com.areeb.sekaisheet.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val  baseUrl ="https://api.unsplash.com/"
//    var baseUrl ="https://quotable.io/"
    var retrofit: Retrofit?=null


    fun getImageFromClient():Retrofit{

        if(retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit!!
    }


}