package com.movieapp.core.remote.datasource.utils

import com.movieapp.core.remote.response.BaseResponse
import retrofit2.Response

suspend fun <T : Any> wrapList(function: suspend () -> Response<BaseResponse<T>>): List<T> {
    val response = function()
    return if (response.isSuccessful) {
        when (response.code()) {
            200 -> response.body()?.items
            else -> throw Throwable(response.errorBody().toString())
        } as List<T>
    } else {
        throw Throwable("Network Error")
    }
}

suspend fun <T : Any> wrap(function: suspend () -> Response<T>): T {
    val response = function()
    return if (response.isSuccessful) {
        when (response.code()) {
            200 -> response.body()
            else -> throw Throwable(response.errorBody().toString())
        } as T
    } else {
        throw Throwable("Network Error")
    }
}
