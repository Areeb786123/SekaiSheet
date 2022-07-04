package com.areeb.sekaisheet.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.areeb.sekaisheet.Models.PixaBeyModel
import com.areeb.sekaisheet.Network.RetrofitInterface
import com.areeb.sekaisheet.UnsplashModels.UnsplashModels
import com.example.quotesapp.Model.QuoteList

class HomeRepo(private val retroInterface: RetrofitInterface) {

    private val pixaImageMutableLiveData = MutableLiveData<UnsplashModels>()

    val pixaImageLiveDataRepo: LiveData<UnsplashModels>
        get() = pixaImageMutableLiveData

    suspend fun getImageFromInterface() {
        val pixaImages = retroInterface.getPixaBeyImage()
        if (pixaImages?.body() != null) {
            pixaImageMutableLiveData.postValue(pixaImages.body())
        }
    }


}