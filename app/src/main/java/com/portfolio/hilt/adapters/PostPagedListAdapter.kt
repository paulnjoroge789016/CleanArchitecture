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
import javax.inject.Inject

/**
 * A good programmer writes code that can be understood
 * by humans
 */
class PostPagedListAdapter @Inject constructor(private val postViewModel: PostViewModel):
    PagedListAdapter<Post, ViewHolder>(PostDIffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            SinglePostLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = getItem(position)
    }

}