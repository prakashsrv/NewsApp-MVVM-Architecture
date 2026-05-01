package com.saurav.newsapp_mvvm_architecture.data.model

data class Language(
    val code: String,
    val name: String,
    val nativeName: String = "",
    val flag: String = ""
)
