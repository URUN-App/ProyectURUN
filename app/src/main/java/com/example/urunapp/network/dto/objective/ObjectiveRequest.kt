package com.example.urunapp.network.dto.objective

import com.google.gson.annotations.SerializedName

data class ObjectiveRequest(
    @SerializedName("user")
    val user: String,
    @SerializedName("Altura")
    val altura: String,
    @SerializedName("Peso")
    val peso: String,
    @SerializedName("Actividad")
    val actividad: String,
    @SerializedName("Periodo")
    val periodo: String,
    @SerializedName("Distancia")
    val distancia: String,
    @SerializedName("Calorias")
    val calorias: Double,
    @SerializedName("Veces")
    val veces: Int
)
