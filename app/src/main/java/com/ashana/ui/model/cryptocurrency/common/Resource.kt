package com.ashana.ui.model.cryptocurrency.common

sealed class Resource<T> (val data: T? = null, val message: String? = null) {
    data class Success<T>(val successData: T) : Resource<T>()
    data class Error<T>(val errorData: T, val errorMessage: String) : Resource<T>()
    data class Loading<T>(val loadingMessage: String) : Resource<T>()
}
