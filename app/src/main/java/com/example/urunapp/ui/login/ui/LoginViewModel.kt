package com.example.urunapp.ui.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.urunapp.RetrofitApplication
import com.example.urunapp.network.ApiResponse
import com.example.urunapp.repository.CredentialsRepository
import com.example.urunapp.ui.welcome.WelcomeViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel(private val repository: CredentialsRepository,
                     private val welcomeViewModel: WelcomeViewModel) : ViewModel() {

    var email = MutableLiveData("")
    var password = MutableLiveData("")

    private val _status = MutableLiveData<LoginUiStatus>(LoginUiStatus.Resume)
    val status: MutableLiveData<LoginUiStatus>
        get() = _status

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.login(email, password)) {
                    is ApiResponse.Error -> LoginUiStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> LoginUiStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Success -> LoginUiStatus.Success
                }
            )
        }
    }

    fun onLogin() {
        if (!validateData()) {
            _status.value = LoginUiStatus.ErrorWithMessage("Wrong Information")
            return
        }
        viewModelScope.launch {
            try {
                val loginResponse = repository.login(email.value!!, password.value!!)
                when (loginResponse) {
                    is ApiResponse.Success -> {
                        // Inicio de sesión exitoso
                        _status.value = LoginUiStatus.Success

                        val userInfoResponse = repository.getUserInfo()
                        when (userInfoResponse) {
                            is ApiResponse.Success -> {
                                val user = userInfoResponse.data.user
                                welcomeViewModel.setUserEmail(user.email)
                            }
                            is ApiResponse.ErrorWithMessage -> {
                                // Error al obtener la información del usuario
                                _status.value = LoginUiStatus.ErrorWithMessage(userInfoResponse.message)
                            }
                            is ApiResponse.Error -> {
                                // Error en la solicitud de información del usuario
                                _status.value = LoginUiStatus.Error(userInfoResponse.exception)
                            }
                        }
                    }
                    is ApiResponse.ErrorWithMessage -> {
                        // Error en el inicio de sesión (email no coincide)
                        _status.value = LoginUiStatus.ErrorWithMessage(loginResponse.message)
                    }
                    is ApiResponse.Error -> {
                        // Error en la solicitud (error de red, error del servidor, etc.)
                        _status.value = LoginUiStatus.Error(loginResponse.exception)
                    }
                }
            } catch (e: Throwable) {
                // Error en la solicitud (error de red, error del servidor, etc.)
                _status.value = LoginUiStatus.Error(e as Exception)
            }
        }

    }


    private fun validateData(): Boolean {
        when {
            email.value.isNullOrEmpty() -> return false
            password.value.isNullOrEmpty() -> return false
        }
        return true
    }

    fun clearData() {
        email.value = ""
        password.value = ""
    }

    fun clearStatus() {
        _status.value = LoginUiStatus.Resume
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as RetrofitApplication
                val welcomeViewModel = WelcomeViewModel(app.credentialsRepository)
                LoginViewModel(app.credentialsRepository, welcomeViewModel)
            }
        }
    }
                     }