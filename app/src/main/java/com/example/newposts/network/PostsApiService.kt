package com.example.newposts.network


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL_POSTS = "https://jsonplaceholder.typicode.com"



private val retrofitPosts = Retrofit.Builder()
    .baseUrl(BASE_URL_POSTS)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface PostsApiService {
    @GET("/comments")
    suspend fun getPosts(): List<Posts>

}

object PostApiService {
    val retrofitService: PostsApiService by lazy {
        retrofitPosts.create(PostsApiService::class.java)
    }
}
