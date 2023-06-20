package com.example.urunapp.ui.hikemap

import android.icu.text.Transliterator.Position
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import com.example.urunapp.R
import com.example.urunapp.ui.login.ui.Login
import com.example.urunapp.ui.progress.Activities
import com.example.urunapp.ui.progress.ImageAvatar
import com.example.urunapp.ui.progress.ImageLogo
import com.example.urunapp.ui.progress.Objectives
import com.example.urunapp.ui.theme.Mycolors
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.currentCameraPositionState
import com.google.maps.android.compose.rememberCameraPositionState
import kotlin.concurrent.timer

@Composable
fun HikemapScreen() {
    // Este Column contiene toda las vistas y esta divido en box
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Mycolors.backgroundUrun)
    ) {
        // Dentro de este box esta la imagen del logo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            ImageLogo()
        }
        //Dentro de este Box esta la seccion de actividades

        //Dentro de este Box esta la seccion de Objetivo
        // val progress controla como se va formando el circulo

        Spacer(modifier = Modifier.height(10.dp))
        //Dentro de aca van los avatares
        Box(modifier = Modifier.fillMaxWidth()) {
            MyGoogleMaps()

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
fun MyGoogleMaps(){

    GoogleMap(Modifier.padding(start =30.dp, end = 30.dp, top = 300.dp ))
    {
        val sansalvador=LatLng(13.68935,-89.18718)
        val defaultCameraPosition= CameraPosition.fromLatLngZoom(sansalvador,11f)
        val CameraPositionState= rememberCameraPositionState(){
            position=defaultCameraPosition
        }
    }
}