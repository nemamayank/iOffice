package com.assignment.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignment.databinding.ImageListItemBinding
import com.assignment.data.models.Images
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageAdapter(private val onImageClickListener: OnImageClickListener) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    private var imageList = ArrayList<Images>()

    fun setImageList(imageList: List<Images>) {
        this.imageList = imageList as ArrayList<Images>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ImageListItemBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ImageListItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image: Images = imageList[position]
        Glide.with(holder.itemView.context)
            .load(image.link)
            .apply(RequestOptions().override(80, 80))
            .into(holder.binding.searchedImage)

        holder.binding.imageName.text = image.description?:"N/A"
        holder.itemView.setOnClickListener {
            onImageClickListener.onImageClick(image)
        }
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    interface OnImageClickListener {
        fun onImageClick(images: Images)
    }
}