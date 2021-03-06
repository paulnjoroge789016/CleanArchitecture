package com.portfolio.hilt.adapters

import androidx.recyclerview.widget.DiffUtil
import com.portfolio.hilt.models.Post


object PostDIffUtil: DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return (oldItem == newItem)
    }

}