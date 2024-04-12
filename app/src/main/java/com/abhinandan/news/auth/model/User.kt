package com.abhinandan.news.auth.model

data class User(
    val email: String = "",
    val password: String = "",
    val name: String?= null,
    val phone: String? = null,
)
