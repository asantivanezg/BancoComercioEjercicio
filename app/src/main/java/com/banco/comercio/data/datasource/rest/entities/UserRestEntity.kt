package com.banco.comercio.data.datasource.rest.entities

import com.google.gson.annotations.SerializedName

data class UserRestEntity(
    val id: Int,

    @SerializedName("name")
    val nombre: String,

    val email: String,

    @SerializedName("phone")
    val telefono: String,

    @SerializedName("website")
    val paginaWeb: String
)
