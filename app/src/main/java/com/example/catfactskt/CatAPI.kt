package com.example.catfactskt

import retrofit2.Response
import retrofit2.http.GET

interface CatAPI {
    @GET("facts")
    suspend fun getCatsFacts(): Response<CatHolder>
}