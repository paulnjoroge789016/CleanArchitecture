package com.portfolio.hilt.adapters

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.hilt.databinding.SinglePostLayoutBinding


class PostViewHolder(binding: SinglePostLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    val binding = DataBindingUtil.bind<SinglePostLayoutBinding>(binding.root)
}