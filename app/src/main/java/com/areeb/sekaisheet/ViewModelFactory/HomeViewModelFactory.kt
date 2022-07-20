//package com.areeb.sekaisheet.ViewModelFactory
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.areeb.sekaisheet.Repository.HomeRepo
//import com.areeb.sekaisheet.ViewModels.HomeViewModel
//
//class HomeViewModelFactory(private val homerepo: HomeRepo):ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//       return HomeViewModel(homerepo) as T
//    }
//
//}