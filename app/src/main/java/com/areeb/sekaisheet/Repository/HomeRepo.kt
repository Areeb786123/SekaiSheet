package com.areeb.sekaisheet.Repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.areeb.sekaisheet.Network.RetrofitInterface

import com.areeb.sekaisheet.PagingAdapter.UnsplashPagingSource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class HomeRepo @Inject constructor(
    private  val unsplashApi :RetrofitInterface) {
    fun getSearchResult(query:String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                UnsplashPagingSource(unsplashApi,query)
            }
        ).liveData

}