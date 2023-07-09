package com.example.urunapp.graphs

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.urunapp.RetrofitApplication
import com.example.urunapp.SplashScreen
import com.example.urunapp.navigation.AppScreens
import com.example.urunapp.ui.login.ui.LoginScreen
import com.example.urunapp.ui.login.ui.LoginViewModel
import com.example.urunapp.ui.register.ui.RegisterScreen
import com.example.urunapp.ui.register.ui.RegisterViewModel
import com.example.urunapp.ui.start.ui.StartScreen
import com.example.urunapp.ui.start.ui.start


@SuppressLint("UnrememberedGetBackStackEntry")
@Composable
fun NavGraphBuilder.authNavGraph(app: RetrofitApplication) {
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

    NavHost(navController = navController, startDestination = AuthScreen.SplashScreen.route) {
        composable(route = AuthScreen.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(route = AuthScreen.StartScreen.route) {
            StartScreen(navController)
        }
        composable(route = AuthScreen.LoginScreen.route) {
            val backStackEntry = remember { navController.getBackStackEntry(route = AuthScreen.LoginScreen.route) }
            LoginScreen(
                navController = navController,
                viewModel = ViewModelProvider(backStackEntry, loginViewModelFactory)[LoginViewModel::class.java]
            )
        }

        composable(route = AuthScreen.RegisterScreen.route) {
            val backStackEntry = remember { navController.getBackStackEntry(route = AuthScreen.RegisterScreen.route) }
            RegisterScreen(
                navController = navController,
                viewModel = ViewModelProvider(backStackEntry, registerViewModelFactory)[RegisterViewModel::class.java]
            )
        }
        composable(route = AuthScreen.WelcomeScreen.route) {
            AuthScreen.WelcomeScreen
        }
    }
}


sealed class AuthScreen(val route: String){
    object SplashScreen:  AuthScreen("splash_screen")
    object StartScreen:  AuthScreen("start_screen")
    object LoginScreen:  AuthScreen("login_screen")
    object RegisterScreen:  AuthScreen("register_screen")
    object WelcomeScreen :  AuthScreen("welcome_screen")

}

