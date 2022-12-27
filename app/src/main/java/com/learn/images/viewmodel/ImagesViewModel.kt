package com.learn.images.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.images.model.Image
import com.learn.images.repository.ImagesRepositoryInterFace
import com.learn.images.util.Resource
import kotlinx.coroutines.*

class ImagesViewModel(
    private val imagesRepositoryInterFace: ImagesRepositoryInterFace
):ViewModel() {
    private val imagesList = MutableLiveData<Resource<Image>>()
    val images : LiveData<Resource<Image>>
        get() = imagesList


    private var job : Job? = null

    fun getData(c:String){
        job = CoroutineScope(Dispatchers.IO).launch {
            val result =imagesRepositoryInterFace.getAll(c)
            withContext(Dispatchers.Main){
                result.data?.let {
                    imagesList.value = result
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}
