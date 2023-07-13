package com.example.urunapp.ui.welcome

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.urunapp.repository.CredentialsRepository
import com.example.urunapp.ui.login.ui.LoginViewModel

class WelcomeViewModel(private val credentialsRepository: CredentialsRepository) {

    private val _userEmail = MutableLiveData<String>()
    val userEmail: LiveData<String>
        get() = _userEmail

    private val _altura = MutableLiveData<Double>()
    val altura: LiveData<Double>
        get() = _altura

    private val _peso = MutableLiveData<Double>()
    val peso: LiveData<Double>
        get() = _peso

    private val _distancia = MutableLiveData<Double>()
    val distancia: LiveData<Double>
        get() = _distancia

    private val _calorias = MutableLiveData<Double>()
    val calorias: LiveData<Double>
        get() = _calorias

    private val _actividad = MutableLiveData<String>()
    val actividad: LiveData<String>
        get() = _actividad

    private val _periodo = MutableLiveData<String>()
    val periodo: LiveData<String>
        get() = _periodo

    private val _veces = MutableLiveData<Int>()
    val veces: LiveData<Int>
        get() = _veces

    init {
        // Inicializa los valores iniciales de los LiveData según sea necesario
    }

    fun setUserEmail(email: String) {
        _userEmail.value = email
    }

    fun setAltura(altura: Double) {
        _altura.value = altura
    }

    fun setPeso(peso: Double) {
        _peso.value = peso
    }

    fun setDistancia(distancia: Double) {
        _distancia.value = distancia
    }

    fun setCalorias(calorias: Double) {
        _calorias.value = calorias
    }

    fun setActividad(actividad: String) {
        _actividad.value = actividad
    }

    fun setPeriodo(periodo: String) {
        _periodo.value = periodo
    }

    fun setVeces(veces: Int) {
        _veces.value = veces
    }

    suspend fun saveObjective() {
        val userEmail = _userEmail.value ?: return
        val altura = _altura.value ?: return
        val peso = _peso.value ?: return
        val distancia = _distancia.value ?: return
        val calorias = _calorias.value ?: return
        val actividad = _actividad.value ?: return
        val periodo = _periodo.value ?: return
        val veces = _veces.value ?: return

        val response = credentialsRepository.createObjective(userEmail, altura, peso, actividad, periodo, distancia, calorias, veces)
    }
}

