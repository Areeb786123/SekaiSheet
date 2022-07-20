package com.areeb.sekaisheet.Network

import com.areeb.sekaisheet.Models.PixaBeyModel
import com.areeb.sekaisheet.UnsplashModels.UnsplashResponse

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
    companion object{
        const val BASE_URL = "https://api.unsplash.com/"
//        const val CLIENT_ID =  "563492ad6f9170000100000103ce2c7ab62e45ee843bc8a14a478d71"
        const val CLIENT_ID = "GVcyqnDgVfwbXvnkSUBIi1D-WnJ6QLhXg-fZKeqlyvY"

    }
    @Headers("Accept-Version: v1","Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query")
        query:String,
        @Query("page")
        page:Int,
        @Query("per_page")
        per_page:Int

    ): UnsplashResponse








}