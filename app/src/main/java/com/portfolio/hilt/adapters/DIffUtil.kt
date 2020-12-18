package com.portfolio.hilt.adapters

import androidx.recyclerview.widget.DiffUtil
import com.portfolio.hilt.models.Post

/**
 * A good programmer writes code that can be understood
 * by humans
 */

object PostDIffUtil: DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return (oldItem.body == newItem.body
                && oldItem.title == newItem.title)
    }

}