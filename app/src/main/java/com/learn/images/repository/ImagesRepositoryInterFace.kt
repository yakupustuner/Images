package com.learn.images.repository

import com.learn.images.model.Image
import com.learn.images.util.Resource

interface ImagesRepositoryInterFace {
    suspend fun getAll(c:String) : Resource<Image>
}