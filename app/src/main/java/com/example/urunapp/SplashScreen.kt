package com.example.urunapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.urunapp.navigation.AppScreens
import com.example.urunapp.ui.login.ui.HeaderImage
import com.example.urunapp.ui.login.ui.UserField
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(NavController:NavHostController){
    LaunchedEffect(key1 = true){
        delay(5000)
        NavController.popBackStack()
        NavController.navigate(AppScreens.StartScreen.route )
    }

    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFFCCFF00))) {
        Splash(Modifier.align(Alignment.Center))

    }
}


@Composable
fun Splash(modifier: Modifier) {

    Column(modifier= modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier =Modifier.padding(16.dp) )
       }
}
@Preview(showBackground = true)
@Composable
fun HeaderImage(Modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "Header",modifier=Modifier)
}