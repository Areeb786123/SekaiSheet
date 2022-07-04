package com.areeb.sekaisheet.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.sekaisheet.Models.PixaBeyModel
import com.areeb.sekaisheet.Repository.HomeRepo
import com.areeb.sekaisheet.UnsplashModels.UnsplashModels
import com.example.quotesapp.Model.QuoteList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class homeViewModel( val homerepo : HomeRepo) :ViewModel(){


    init{
        viewModelScope.launch (Dispatchers.IO){
            homerepo.getImageFromInterface()
        }
    }
    val PixaImageLiveData :LiveData<UnsplashModels>
    get() = homerepo.pixaImageLiveDataRepo


}