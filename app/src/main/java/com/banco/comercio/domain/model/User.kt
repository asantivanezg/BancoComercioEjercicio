package com.banco.comercio.domain.model

data class User(
    val id: Int,
    val nombre: String,
    val email: String,
    val telefono: String,
    val paginaWeb: String
)