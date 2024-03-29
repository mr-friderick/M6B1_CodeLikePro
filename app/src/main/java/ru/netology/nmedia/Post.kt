package ru.netology.nmedia

data class Post(
    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    var likedByMe: Boolean = false,
    var likes: Long = 0,
    var shared: Long = 0,
    var views: Long = 0
)