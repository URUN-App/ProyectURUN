package com.example.urunapp.ui.hikemap

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.urunapp.R
import com.example.urunapp.ui.progress.ImageLogo
import com.example.urunapp.ui.theme.Mycolors
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.urunapp.graphs.AuthScreen

@Preview
@Composable
fun HikemapScreen(navController: NavHostController) {
    // Este Column contiene toda las vistas y esta divido en box

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Mycolors.backgroundUrun)
            .verticalScroll(rememberScrollState())


    ) {
        // Dentro de este box esta la imagen del logo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            contentAlignment = Alignment.Center
        ) {
            ImageLogo()
        }

        Box(modifier = Modifier.fillMaxWidth()) {
            resume()
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Buttons(navController)
        }


    }
}
@Composable
fun resume() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Resumen",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (30.sp)
        )
        Row(modifier = Modifier
            .width(400.dp)
            .padding(start = 20.dp), Arrangement.SpaceBetween) {
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = "0",
                    color = Mycolors.greenUrun,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (40.sp)
                )
                Text(
                    text = "Calorias(kcal)",
                    color = Color.White,
                    modifier = Modifier.padding(start = 30.dp),
                    fontSize = (15.sp),
                )
            }
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = "0",
                    color = Mycolors.greenUrun,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (40.sp)
                )
                Text(
                    text = "Distancia(km)",
                    color = Color.White,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (15.sp),
                )
            }
            Column(modifier = Modifier.width(200.dp)) {
                Text(
                    text = "0.0",
                    color = Mycolors.greenUrun,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (40.sp)
                )
                Text(
                    text = "Ritmo Medio",
                    color = Color.White,
                    modifier = Modifier.padding(start = 20.dp),
                    fontSize = (15.sp),
                )
            }


        }
    }

}



@Composable
fun ImageLogo() {
    Image(
        painter = painterResource(id = R.drawable.logotextohorizontal),
        contentDescription = "Logo",
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
    )
}






@Composable
fun Buttons(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { navController.navigate(AuthScreen.User.route) },
            modifier = Modifier
                .weight(1f)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFCCFF00),
                disabledContainerColor = Color(0xFFCCFF00),
                contentColor = Color(0xFF1E1E1E),
                disabledContentColor = Color(0xFF1E1E1E)
            )
        ) {
            Text(text = "User")
        }
        Button(
            onClick = { navController.navigate(AuthScreen.Progress.route) },
            modifier = Modifier
                .weight(1f)
                .height(45.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFCCFF00),
                disabledContainerColor = Color(0xFFCCFF00),
                contentColor = Color(0xFF1E1E1E),
                disabledContentColor = Color(0xFF1E1E1E)
            )
        ) {
            Text(text = "Progress")
        }
    }
}
