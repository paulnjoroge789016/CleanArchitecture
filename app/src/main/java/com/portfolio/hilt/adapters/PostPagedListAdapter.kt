package com.portfolio.hilt.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import com.portfolio.hilt.R
import com.portfolio.hilt.databinding.SinglePostLayoutBinding

import com.portfolio.hilt.models.Post
import com.portfolio.hilt.viewmodels.PostViewModel


/**
 * A good programmer writes code that can be understood
 * by humans
 */
class PostPagedListAdapter (private val postViewModel: PostViewModel):
    PagedListAdapter<Post, PostViewHolder>(PostDIffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            SinglePostLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)

    }

}