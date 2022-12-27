package com.learn.images.model

data class Image(
    val hits: List<Image2>,
    val total: Int,
    val totalHits: Int
)

