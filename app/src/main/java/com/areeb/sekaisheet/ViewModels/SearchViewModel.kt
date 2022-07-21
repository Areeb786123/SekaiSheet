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
class SearchViewModel @Inject constructor(private val searchRepo:HomeRepo):ViewModel() {
    companion object{
        private const val DEFAULT_QUERY ="sea"
    }
    private val currentSearchQuery=MutableLiveData(DEFAULT_QUERY)

    val searchPhoto = currentSearchQuery.switchMap {
        searchRepo.getSearchResult(it).cachedIn(viewModelScope)
    }

    fun searchPhoto(query:String){
        currentSearchQuery.value=query
    }


}