package com.example.urunapp.ui.register.ui

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RegisterViewModel {

    private val _email= MutableLiveData<String>()
    val email: LiveData<String> =_email

    private val _user= MutableLiveData<String>()
    val user: LiveData<String> =_user

    private val _password= MutableLiveData<String>()
    val password: LiveData<String> =_password

    private val _cpassword= MutableLiveData<String>()
    val cpassword: LiveData<String> =_cpassword



    private val _registerEnable= MutableLiveData<Boolean>()
    val registerEnable: LiveData<Boolean> =_registerEnable



    private fun isValidPassword(password: String): Boolean=password.length>8

    private fun isValidEmail(email: String): Boolean= Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun onLoginSelected() {
        TODO("Not yet implemented")
    }

    fun onEmailChanged(email: String) {
        _email.value = email

    }
    fun onUserChanged(user:String){
        _user.value = user

    }
    fun onPasswordChanged(password: String){
        _password.value=password
    }
    fun onCPasswordChanged(cpassword:String){
        _cpassword.value= cpassword
    }


}