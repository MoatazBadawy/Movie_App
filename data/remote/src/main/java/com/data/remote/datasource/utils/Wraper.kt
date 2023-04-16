package com.data.remote.datasource.utils

import retrofit2.Response

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
