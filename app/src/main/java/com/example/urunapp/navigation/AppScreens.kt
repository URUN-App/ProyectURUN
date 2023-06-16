package com.example.urunapp.navigation
import androidx.navigation.NavController
import com.example.urunapp.ui.login.ui.LoginScreen

sealed class AppScreens(val route:String){
    object SplashScreen: AppScreens("splash_screen")
    object StartScreen: AppScreens("start_screen")
    object LoginScreen: AppScreens("login_screen")
    object RegisterScreen: AppScreens("register_screen")




}
