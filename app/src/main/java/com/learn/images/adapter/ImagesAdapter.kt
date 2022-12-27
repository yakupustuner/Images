package com.learn.images.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.learn.images.R
import com.learn.images.databinding.RecyclerRowBinding

class ImagesAdapter(var imagesList:List<String>):RecyclerView.Adapter<ImagesAdapter.ImagesHolder>(){


    class ImagesHolder(v:RecyclerRowBinding):RecyclerView.ViewHolder(v.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesHolder {
        return ImagesHolder(RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ImagesHolder, position: Int) {
        val image = holder.itemView.findViewById<ImageView>(R.id.imageView)
        val id = imagesList[position]
        holder.itemView.apply {
          val glide = Glide.with(context).setDefaultRequestOptions(
                  RequestOptions().placeholder(R.drawable.ic_launcher_foreground)
                      .error(R.drawable.ic_launcher_foreground))
            glide.load(id).into(image)


        }
    }

    override fun getItemCount(): Int {
        return imagesList.size

    }
}
