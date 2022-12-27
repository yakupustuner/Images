package com.learn.images.repository

import com.learn.images.api.Retrofit
import com.learn.images.model.Image
import com.learn.images.util.Resource
import com.learn.images.util.Util.API_KEY

class ImagesRepository(private val retrofit: Retrofit):ImagesRepositoryInterFace {
    override suspend fun getAll(c: String): Resource<Image> {
        return try {
            val result = retrofit.Search(c, API_KEY,"photo")
            if (result.isSuccessful){
                result.body()?.let {
                    return@let Resource.Success(it)
                } ?: Resource.Error("Error",null)
            } else {
                Resource.Error("Error",null)
            }
        } catch (e:Exception){
            Resource.Error("Error",null)
        }
    }



}