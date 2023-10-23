package com.ashana.ui.model.cryptocurrency.common

sealed class Resource<T> (val data: T? = null, val message: String? = null) {
    data class Success<T>(val successData: T) : Resource<T>()
    data class Error<T>(val errorData: T? = null, val errorMessage: String? = null) : Resource<T>()
    data class Loading<T>(val loadingMessage: String? = null) : Resource<T>()
}
