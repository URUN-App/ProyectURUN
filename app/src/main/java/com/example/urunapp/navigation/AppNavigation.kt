package com.example.urunapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.urunapp.RetrofitApplication
import com.example.urunapp.SplashScreen
import com.example.urunapp.repository.CredentialsRepository
import com.example.urunapp.ui.login.ui.LoginScreen
import com.example.urunapp.ui.login.ui.LoginViewModel
import com.example.urunapp.ui.register.ui.RegisterScreen
import com.example.urunapp.ui.start.ui.StartScreen

@Composable
fun AppNavigation(app: RetrofitApplication, navController: NavHostController) {
    val viewModelFactory = viewModelFactory {
        initializer {
            LoginViewModel(app.credentialsRepository)
        }
    }

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreens.StartScreen.route) {
            StartScreen(navController)
        }
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(viewModel = ViewModelProvider(navController.getViewModelStoreOwner(AppScreens.LoginScreen.route.hashCode()), viewModelFactory).get(LoginViewModel::class.java))
        }
        composable(AppScreens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
    }
}