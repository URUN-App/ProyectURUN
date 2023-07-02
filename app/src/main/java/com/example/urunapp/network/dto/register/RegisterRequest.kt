package com.example.urunapp.network.dto.register

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
)