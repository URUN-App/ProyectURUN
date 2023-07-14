package com.example.urunapp.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.urunapp.BottomBarScreen
import com.example.urunapp.ui.hikemap.HikemapScreen
import com.example.urunapp.ui.progress.ProgressScreen
import com.example.urunapp.ui.user.ScreenUser

@Composable
fun  HomeNavGraph(navController: NavHostController){
    NavHost(navController = navController,
            route = Graph.HOME,
            startDestination = BottomBarScreen.Home.route){
        composable(route = BottomBarScreen.Home.route){
            HikemapScreen()
        }
        composable(route = BottomBarScreen.Progress.route){
            ProgressScreen()
        }
        composable(route = BottomBarScreen.User.route){
            ScreenUser()
        }
    }
}