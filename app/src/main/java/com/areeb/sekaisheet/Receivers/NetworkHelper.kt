//package com.areeb.sekaisheet.Receivers
//
//import android.content.Context
//import android.icu.lang.UCharacter.GraphemeClusterBreak.L
//import android.net.ConnectivityManager
//import android.net.Network
//import android.os.Build
//
//object NetworkHelper {
//
//    fun isNetworkConnected(context: Context): Boolean {
//
//        var result = false
//        (context.getSystemService(Context.CONNECTIVITY_SERVICE)as ConnectivityManager).apply {
//             if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//                 result= checkNetworkConnection(this,this.activeNetwork)
//
//             }else{
//                 val networks =this.allNetworks
//                 for(network in networks){
//                     result = true
//                 }
//
//             }
//        }
//        return result
//
//    }
//
//
//    private  fun checkNetworkConnection(
//        connectivityManager: ConnectivityManager,
//        network: Network?
//
//    ):Boolean{
//
//
//        connectivityManager.getNetworkCapabilities((network)?.also{
////
////            if(it.hasTransport())
//        }
//    }
//}