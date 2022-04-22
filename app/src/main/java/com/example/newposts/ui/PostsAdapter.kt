package com.example.newposts.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newposts.databinding.PostsItemBinding
import com.example.newposts.network.Posts

class PostsAdapter:
    ListAdapter<Posts, PostsAdapter.PostsViewHolder>(DiffCallback) {


    class PostsViewHolder(
         var binding: PostsItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(posts: Posts) {
            binding.posts = posts
            binding.executePendingBindings()
        }
    }


    companion object DiffCallback: DiffUtil.ItemCallback<Posts>() {

        override fun areItemsTheSame(oldItem: Posts, newItem: Posts): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Posts, newItem: Posts): Boolean {
            return  oldItem == newItem
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PostsViewHolder(
            PostsItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }

}