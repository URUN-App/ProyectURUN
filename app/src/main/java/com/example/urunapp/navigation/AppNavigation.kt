package com.example.urunapp.navigation


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.urunapp.RetrofitApplication
import com.example.urunapp.SplashScreen
import com.example.urunapp.ui.login.ui.LoginScreen
import com.example.urunapp.ui.login.ui.LoginViewModel
import com.example.urunapp.ui.register.ui.RegisterScreen
import com.example.urunapp.ui.start.ui.StartScreen
import com.example.urunapp.ui.register.ui.RegisterViewModel

@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun AppNavigation(app: RetrofitApplication) {
    val loginViewModelFactory = viewModelFactory {
        initializer {
            LoginViewModel(app.credentialsRepository)
        }
    }

    val registerViewModelFactory = viewModelFactory {
        initializer {
            RegisterViewModel(app.credentialsRepository)
        }
    }

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = AppScreens.StartScreen.route) {
            StartScreen(navController)
        }
        composable(route = AppScreens.LoginScreen.route) {
            val backStackEntry = remember { navController.getBackStackEntry(route = AppScreens.LoginScreen.route) }
            LoginScreen(
                navController = navController,
                viewModel = ViewModelProvider(backStackEntry, loginViewModelFactory)[LoginViewModel::class.java]
            )
        }

        composable(route = AppScreens.RegisterScreen.route) {
            val backStackEntry = remember { navController.getBackStackEntry(route = AppScreens.RegisterScreen.route) }
            RegisterScreen(
                navController = navController,
                viewModel = ViewModelProvider(backStackEntry, registerViewModelFactory)[RegisterViewModel::class.java]
            )
        }
    }
}
