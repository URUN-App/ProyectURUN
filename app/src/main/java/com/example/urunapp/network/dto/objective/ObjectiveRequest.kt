package com.example.urunapp.network.dto.objective

import com.google.gson.annotations.SerializedName

data class ObjectiveRequest(
    @SerializedName("user")
    val user: String,
    @SerializedName("Altura")
    val altura: Double,
    @SerializedName("Peso")
    val peso: Double,
    @SerializedName("Actividad")
    val actividad: String,
    @SerializedName("Periodo")
    val periodo: String,
    @SerializedName("Distancia")
    val distancia: Double,
    @SerializedName("Calorias")
    val calorias: Double,
    @SerializedName("Veces")
    val veces: Int
)
