package com.example.newposts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newposts.network.PostApiService
import com.example.newposts.network.Posts
import kotlinx.coroutines.launch
import java.io.IOException

enum class PostsApiStatus {LOADING, ERROR, DONE}

class PostsViewModel : ViewModel() {

    private var _status = MutableLiveData<PostsApiStatus>()
    val status: LiveData<PostsApiStatus> = _status

    private var _posts = MutableLiveData<List<Posts>>()
    val posts: LiveData<List<Posts>> = _posts


    fun getPostsList() {
        viewModelScope.launch {
            _status.value = PostsApiStatus.LOADING
            try {
                _posts.value = PostApiService.retrofitService.getPosts()
                _status.value = PostsApiStatus.DONE
            } catch (e: IOException) {
                _status.value = PostsApiStatus.ERROR
                _posts.value = listOf()
            }
        }
    }
}