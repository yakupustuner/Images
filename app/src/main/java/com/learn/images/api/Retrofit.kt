package com.learn.images.api

import com.learn.images.model.Image
import com.learn.images.util.Util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Retrofit {
    @GET("api/")
    suspend fun Search(
        @Query("q") Query:String,
        @Query("key") Key : String = API_KEY,
        @Query("image_type") imageType:String
    ): Response<Image>
}