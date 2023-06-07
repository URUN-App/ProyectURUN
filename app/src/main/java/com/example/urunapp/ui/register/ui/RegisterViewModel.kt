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


    fun onRegisterchanged(email: String, password: String,user:String,cpassword:String) {
        _email.value=email
        _password.value=password
        _user.value=user
        _cpassword.value=cpassword
    }

    private fun isValidPassword(password: String): Boolean=password.length>6

    private fun isValidEmail(email: String): Boolean= Patterns.EMAIL_ADDRESS.matcher(email).matches()
    fun onLoginSelected() {
        TODO("Not yet implemented")
    }






}