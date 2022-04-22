package com.example.newposts

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newposts.network.Posts
import com.example.newposts.ui.PostsAdapter
import com.example.newposts.ui.PostsApiStatus

@BindingAdapter("listData")
fun  bindRecyclerView(recyclerView: RecyclerView, data: List<Posts>?) {
    val adapter = recyclerView.adapter as PostsAdapter
    adapter.submitList(data)
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: PostsApiStatus?) {

    when (status) {
        PostsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }

        PostsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }

        PostsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
    }
}