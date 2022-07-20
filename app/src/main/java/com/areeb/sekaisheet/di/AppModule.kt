package com.areeb.sekaisheet.di

import android.content.Context
import com.areeb.sekaisheet.HomeApp
import com.areeb.sekaisheet.Network.RetrofitInterface
import com.areeb.sekaisheet.Repository.HomeRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBaseApp(@ApplicationContext context : Context): HomeApp {
        return context as HomeApp

    }
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =

        Retrofit.Builder()
            .baseUrl(RetrofitInterface.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideRetrofitInterface(retrofit: Retrofit): RetrofitInterface =
        retrofit.create(RetrofitInterface::class.java)

//    @Provides
//    @Singleton
//    fun provideHomeRepo(reto :RetrofitInterface): HomeRepo {
//        return HomeRepo(reto)
//
//
//    }


}