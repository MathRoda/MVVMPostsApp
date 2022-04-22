package com.example.newposts.network

data class Posts(
    val body: String,
    val id: Int?,
    val email: String,
    val name: String,
    val userId: Int
)