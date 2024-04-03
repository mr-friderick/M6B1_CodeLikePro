package ru.netology.nmedia.dto

data class Post(
    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    val likedByMe: Boolean = false,
    val likes: Long = 0,
    val shared: Long = 0,
    val views: Long = 0
)