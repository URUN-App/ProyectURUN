package com.example.urunapp.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urunapp.R
import com.example.urunapp.ui.theme.Mycolors
import java.time.format.TextStyle

@Preview(showBackground = true)
@Composable
fun ScreenWelcome() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Mycolors.backgroundUrun)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)

            , contentAlignment = Alignment.TopCenter,

            ) {
            ImageLogo()
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            InfoUser()

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoUser() {
    Column(modifier = Modifier.padding(vertical = 5.dp)) {
        Text(
            text = "Hola, Aida",
            color = Mycolors.greenUrun,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (25.sp)
        )

        Text(
            text = "Inciemos este viaje a una vida saludable",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        //Calculando Calorias
        Text(
            text = "Calculo de calorías",
            color = Mycolors.greenUrun,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (25.sp)
        )
        Text(
            text = "Ayúdanos a calcular con mayor precisión las calorías que quemas con cada ejercicio que realices, por favor ingresa tu altura y tu peso.",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            textAlign = TextAlign.Justify
        )
        //Botones de cm y kg
        Spacer(modifier = Modifier.height(16.dp))
        Row(verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 50.dp, end = 50.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {/*Actualizar datos para darle la funcionalida*/},
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
                    label ={ Text(text = "cm")} ,
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Mycolors.greenUrun,
                        focusedLabelColor = Mycolors.greenUrun

                    )

                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {/*Actualizar datos para darle la funcionalida*/},
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
                    label ={ Text(text = "kg")} ,
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Mycolors.greenUrun,
                        focusedLabelColor = Mycolors.greenUrun

                    )

                )
            }
        }


        Spacer(modifier = Modifier.height(10.dp))

        //Creando un Objetivo
        Text(
            text = "Crea un objetivo",
            color = Mycolors.greenUrun,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (25.sp)
        )
        Text(
            text = "Actividad",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            textAlign = TextAlign.Justify,
            fontSize = (20.sp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        //Botones de corre y caminar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 50.dp, end = 50.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { /* Acción del primer botón */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                        .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                    colors = ButtonDefaults.buttonColors(Mycolors.backgroundUrun)
                ) {
                    Text(text = "Correr", color = Mycolors.greenUrun)
                }

                Button(
                    onClick = { /* Acción del segundo botón */ },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                        .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                    colors = ButtonDefaults.buttonColors( Mycolors.backgroundUrun)
                ) {
                    Text(text = "Caminar", color = Mycolors.greenUrun)
                }
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        //periodo
        Text(
            text = "Periodo",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            textAlign = TextAlign.Justify,
            fontSize = (20.sp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 50.dp, end = 50.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /* Acción del primer botón */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                            .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(Mycolors.backgroundUrun)
                    ) {
                        Text(text = "Al día", color = Mycolors.greenUrun)
                    }

                    Button(
                        onClick = { /* Acción del segundo botón */ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                            .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors( Mycolors.backgroundUrun)
                    ) {
                        Text(text = "A la semana", color = Mycolors.greenUrun)
                    }
                }

            }

            Button(
                onClick = { /* Acción del segundo botón */ },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(200.dp)
                    .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                    .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors( Mycolors.backgroundUrun)
            ) {
                Text(text = "Al mes", color = Mycolors.greenUrun)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        //Fija un Objetivo
        Text(
            text = "Fija un Objetivo",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            textAlign = TextAlign.Justify,
            fontSize = (20.sp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 50.dp, end = 50.dp)
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = {/*Actualizar datos para darle la funcionalida*/},
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
                    label ={ Text(text = "km")} ,
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Mycolors.greenUrun,
                        focusedLabelColor = Mycolors.backgroundUrun

                    )

                )

                OutlinedTextField(
                    value = "",
                    onValueChange = {/*Actualizar datos para darle la funcionalida*/},
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
                    label ={ Text(text = "kcal")} ,
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Mycolors.greenUrun,
                        focusedLabelColor = Mycolors.greenUrun

                    )

                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {/*Actualizar datos para darle la funcionalida*/},
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
                    label ={ Text(text = "kcal")} ,
                    shape = RoundedCornerShape(16.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Mycolors.greenUrun,
                        focusedLabelColor = Mycolors.greenUrun

                    )

                )
            }
            //Boton iniciar
            Button(
                onClick = { /* Acción del segundo botón */ },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(200.dp)
                    .background(Mycolors.greenUrun, RoundedCornerShape(16.dp))
                    .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors( Mycolors.greenUrun)
            ) {
                Text(text = "iniciar", color = Mycolors.backgroundUrun,modifier = Modifier.scale(1.2f) )
            }

        }


    }


}


