package com.saurav.newsapp_mvvm_architecture.ui.theme.base

sealed class UiState<out T> {

    data class Success<out T>( val data: T): UiState<T>()
    data class Error(val message:String? = null): UiState<Nothing>()
    object Loading: UiState<Nothing>()
    object Initial : UiState<Nothing>()


}