package com.banco.comercio.data.datasource.rest

import com.banco.comercio.data.datasource.rest.entities.UserRestEntity
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUserList(): Response<List<UserRestEntity>>
}