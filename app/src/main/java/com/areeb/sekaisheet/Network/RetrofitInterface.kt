package com.areeb.sekaisheet.Network

import com.areeb.sekaisheet.Models.PixaBeyModel
import com.areeb.sekaisheet.UnsplashModels.UnsplashModels
import com.areeb.sekaisheet.Utils.Constant.Companion.KEY_QUERY
import com.areeb.sekaisheet.Utils.Constant.Companion.PAGE_LIMIT
import com.areeb.sekaisheet.Utils.Constant.Companion.PAGE_QUERY
import com.example.quotesapp.Model.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitInterface {


    @GET("photos/?client_id=gW1zZrWSsEQ_nKXBOgJNuU36q4XuLFpAHt-SnOLoCIA")
    suspend fun getPixaBeyImage(): Response<UnsplashModels>




}