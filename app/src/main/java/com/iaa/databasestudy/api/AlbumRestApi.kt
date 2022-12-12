package com.iaa.databasestudy.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AlbumRestApi {

    companion object {

        private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        fun getService(): AlbumService {
            return retrofit.create(AlbumService::class.java)
        }

    }



}