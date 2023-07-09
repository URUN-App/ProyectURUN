package com.example.urunapp.graphs

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

fun NavGraphBuilder.autNavGraph(navController: NavHostController){


}

sealed class AuthScreen(val route: String){
    object LoginScreen: AuthScreen("LOGIN")
    object RegisterScreen: AuthScreen("REGISTER")
    object SplashScreen: AuthScreen("splash_screen")
    object StartScreen: AuthScreen("start_screen")

}

