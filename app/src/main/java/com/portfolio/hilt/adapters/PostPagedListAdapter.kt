package com.portfolio.hilt.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portfolio.hilt.databinding.SinglePostLayoutBinding

import com.portfolio.hilt.models.Post
import com.portfolio.hilt.viewmodels.PostViewModel

class PostPagedListAdapter  (private val postViewModel: PostViewModel,private val posts: ArrayList<Post>): RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding =
            SinglePostLayoutBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)

        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.binding!!.post = post
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}