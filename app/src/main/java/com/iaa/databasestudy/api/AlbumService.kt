package com.iaa.databasestudy.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {

    @GET("/albums")
    fun getAll(): Call<List<AlbumResponse>>

    @GET("/albums/{id}")
    fun getById(@Path("id") id: Int) : Call<AlbumResponse>
}