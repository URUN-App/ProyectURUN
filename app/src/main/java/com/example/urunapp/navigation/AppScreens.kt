package com.example.urunapp.navigation

sealed class AppScreens(val route:String){
    object SplashScreen: AppScreens("splash_screen")
    object StartScreen: AppScreens("start_screen")
    object LoginScreen: AppScreens("login_screen")
    object RegisterScreen: AppScreens("register_screen")

    object WelcomeScreen : AppScreens("welcome_screen")

}
