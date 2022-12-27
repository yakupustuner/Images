package com.learn.images.di

import com.learn.images.repository.ImagesRepository
import com.learn.images.repository.ImagesRepositoryInterFace
import com.learn.images.util.Util.BASE_URL
import com.learn.images.viewmodel.ImagesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.koin.dsl.module

val Module = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(com.learn.images.api.Retrofit::class.java)
    }
    single<ImagesRepositoryInterFace> {
        ImagesRepository(get())
    }
    viewModel{
        ImagesViewModel(get())
    }




}