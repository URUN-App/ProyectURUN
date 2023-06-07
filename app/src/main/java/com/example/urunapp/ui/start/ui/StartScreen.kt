package com.example.urunapp.ui.start.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.urunapp.R
import com.example.urunapp.ui.login.ui.LoginButton
import com.example.urunapp.ui.register.ui.HeaderImage
import com.example.urunapp.ui.register.ui.RegisterButton


@Preview
@Composable
fun StartScreen(){
    Box(
        Modifier
            .fillMaxSize()

            .background(Color(0xFF1E1E1E))) {
        start(Modifier.align(Alignment.Center))

    }
}
@Composable
fun start(modifier: Modifier) {
    Column(modifier= modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier =Modifier.padding(12.dp) )
        RegisterButton()
        Spacer(modifier =Modifier.padding(12.dp) )
        LoginButton()
        Spacer(modifier =Modifier.padding(12.dp) )

    }
}


@Preview(showBackground = true,showSystemUi = true)
@Composable
fun HeaderImage(Modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.logo1), contentDescription = "Header",modifier=Modifier)
}


@Composable
fun RegisterButton() {
    Button(onClick = {},modifier = Modifier
        .fillMaxWidth()
        .height(48.dp),colors= ButtonDefaults.buttonColors(containerColor = Color(0xFFCCFF00), disabledContainerColor = Color.Green, contentColor = Color(0xFF1E1E1E), disabledContentColor = Color(0xFFCCFF00))) {
        Text(text = "Registrarse",

            )
    }
}

@Composable
fun LoginButton() {
    Button(onClick = {},modifier = Modifier
        .fillMaxWidth()
        .height(48.dp),colors=ButtonDefaults.buttonColors(containerColor = Color(0xFFCCFF00), disabledContainerColor = Color.Green, contentColor = Color(0xFF1E1E1E), disabledContentColor = Color(0xFFCCFF00))) {
        Text(text = "Iniciar Sesion",

            )
    }
}
