package com.areeb.sekaisheet.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.areeb.sekaisheet.Repository.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepo:HomeRepo):ViewModel(){


    companion object{
        private const val DEFAULT_QUERY ="nature"
    }

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photo = currentQuery.switchMap { queryString ->
        homeRepo.getSearchResult(queryString).cachedIn(viewModelScope)

    }

//    fun searchPhoto(query:String){
//        currentQuery.value = query
//    }
}