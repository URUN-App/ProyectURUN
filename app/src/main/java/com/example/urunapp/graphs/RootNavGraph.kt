package com.example.urunapp.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.urunapp.RetrofitApplication


@Composable
fun RootNavigationGraph(navController:NavHostController){
    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION,
        route = Graph.ROOT

        // esto nos indica a donde queremos llegar
        //que en nuestro caso es la starscreen

    ){
        //aca implentaremos la ruta de autenticacion
        authNavGraph(navController = navController, app = RetrofitApplication())
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}