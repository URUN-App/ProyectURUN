package com.example.urunapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.urunapp.SplashScreen
import com.example.urunapp.ui.login.ui.LoginScreen
import com.example.urunapp.ui.login.ui.LoginViewModel
import com.example.urunapp.ui.register.ui.RegisterScreen



@Composable
fun AppNavigation() {
    val NavController = rememberNavController()
    NavHost(navController = NavController, startDestination = AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(NavController)
        }

        composable(AppScreens.LoginScreen.route){
            LoginScreen(viewModel = LoginViewModel())
        }
        composable(AppScreens.RegisterScreen.route){
            RegisterScreen(NavController)
        }

    }
}