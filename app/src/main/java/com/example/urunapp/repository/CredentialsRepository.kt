package com.example.urunapp.repository

import com.example.urunapp.network.ApiResponse
import com.example.urunapp.network.dto.infouser.User
import com.example.urunapp.network.dto.infouser.UserInfoResponse
import com.example.urunapp.network.dto.login.LoginRequest
import com.example.urunapp.network.dto.objective.ObjectiveRequest
import com.example.urunapp.network.dto.objective.ObjectiveResponse
import com.example.urunapp.network.dto.register.RegisterRequest
import com.example.urunapp.network.service.AuthService
import com.google.gson.annotations.SerializedName
import retrofit2.HttpException
import java.io.IOException

class CredentialsRepository(private val api: AuthService) {

    suspend fun login(email: String, password: String): ApiResponse<String> {

        try {
            val response = api.login(LoginRequest(email, password))
            return ApiResponse.Success(response.token)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    suspend fun register(name: String, email: String, password: String): ApiResponse<String> {

        try {
            val response = api.register(RegisterRequest(name, email, password))
            return ApiResponse.Success(response.message)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid name, email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    suspend fun getUserInfo(): ApiResponse<UserInfoResponse> {
        try {
            val response = api.getUserInfo()
            return ApiResponse.Success(response)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("No info for USER")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }

    suspend fun createObjective(user: String, altura: Double, peso: Double, actividad: String,
    periodo: String, distancia: Double, calorias: Double, veces: Int): ApiResponse<String> {

        try {
            val response = api.createObjective(ObjectiveRequest(
                user, altura, peso, actividad, periodo, distancia, calorias, veces))
            return ApiResponse.Success(response.message)
        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("create objective failed")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }





}