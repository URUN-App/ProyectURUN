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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.urunapp.R
import com.example.urunapp.graphs.AuthScreen
import com.example.urunapp.repository.CredentialsRepository
import com.example.urunapp.ui.theme.Mycolors


@Preview(showBackground = true)
@Composable
fun ScreenWelcome(viewModel: WelcomeViewModel, navController: NavController) {
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
            , contentAlignment = Alignment.TopCenter
        ) {
            ImageLogo()
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart) {
            InfoUser(modifier = Modifier, viewModel = viewModel, navController = navController)

        }
    }
}
@Composable
fun rememberWelcomeViewModel(credentialsRepository: CredentialsRepository): WelcomeViewModel {
    val viewModel = remember { WelcomeViewModel(credentialsRepository) }
    val userEmail: String by viewModel.userEmail.observeAsState("")
    LaunchedEffect(userEmail) {
    }
    return viewModel
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
fun InfoUser(modifier: Modifier, viewModel: WelcomeViewModel, navController: NavController) {
    val userEmail: String by viewModel.userEmail.observeAsState("")
    val altura: Double by viewModel.altura.observeAsState(0.0)
    val peso: Double by viewModel.peso.observeAsState(0.0)
    val distancia: Double by viewModel.distancia.observeAsState(0.0)
    val calorias: Double by viewModel.calorias.observeAsState(0.0)
    val actividad: String by viewModel.actividad.observeAsState("")
    val periodo: String by viewModel.periodo.observeAsState("")

    Column(modifier = Modifier.padding(vertical = 5.dp)) {
        Text(
            text = "Hola $userEmail",
            color = Mycolors.greenUrun,
            modifier = Modifier.padding(start = 20.dp),
            fontSize = (25.sp)
        )

        Text(
            text = "Iniciemos este viaje a una vida saludable",
            color = Color.White,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Calculando Calorias
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

        Spacer(modifier = Modifier.height(16.dp))
        centimeters(altura) { viewModel.setAltura(it) }
        weight(peso) { viewModel.setPeso(it) }

        Spacer(modifier = Modifier.height(10.dp))

        // Creando un Objetivo
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

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 50.dp, end = 50.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { viewModel.setActividad("Correr") },
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
                    onClick = { viewModel.setActividad("Caminar") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                        .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                    colors = ButtonDefaults.buttonColors(Mycolors.backgroundUrun)
                ) {
                    Text(text = "Caminar", color = Mycolors.greenUrun)
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Periodo
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
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 50.dp, end = 50.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { viewModel.setPeriodo("Al día") },
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
                        onClick = { viewModel.setPeriodo("A la semana") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp)
                            .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                            .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                        colors = ButtonDefaults.buttonColors(Mycolors.backgroundUrun)
                    ) {
                        Text(text = "A la semana", color = Mycolors.greenUrun)
                    }
                }
            }

            Button(
                onClick = { viewModel.setPeriodo("Al mes") },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(200.dp)
                    .background(Mycolors.backgroundUrun, RoundedCornerShape(16.dp))
                    .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(Mycolors.backgroundUrun)
            ) {
                Text(text = "Al mes", color = Mycolors.greenUrun)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Fija un Objetivo
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
            modifier = Modifier.fillMaxWidth()
        ) {
            kilometers(distancia) { viewModel.setDistancia(it) }

            kilocals(calorias) { viewModel.setCalorias(it) }

            //Boton iniciar
            Button(
                onClick = { navController.navigate(AuthScreen.HikeMap.route) },
                modifier = Modifier
                    .padding(top = 8.dp)
                    .width(200.dp)
                    .background(Mycolors.greenUrun, RoundedCornerShape(16.dp))
                    .border(2.dp, Mycolors.greenUrun, RoundedCornerShape(16.dp)),
                colors = ButtonDefaults.buttonColors(Mycolors.greenUrun)
            ) {
                Text(
                    text = "iniciar",
                    color = Mycolors.backgroundUrun,
                    modifier = Modifier.scale(1.2f)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun centimeters(altura: Double, onTextFieldChanged: (Double) -> Unit) {
    val alturaText = altura.toString()
    OutlinedTextField(
        value = alturaText,
        onValueChange = { text ->
            val parsedValue = text.toDoubleOrNull() ?: 0.0
            onTextFieldChanged(parsedValue)
        },
        modifier = Modifier.padding(8.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        label = { Text(text = "cm") },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Mycolors.greenUrun,
            focusedLabelColor = Mycolors.greenUrun
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun weight(peso: Double, onTextFieldChanged: (Double) -> Unit) {
    val pesoText = peso.toString()
    OutlinedTextField(
        value = pesoText,
        onValueChange = { text ->
            val parsedValue = text.toDoubleOrNull() ?: 0.0
            onTextFieldChanged(parsedValue)
        },
        modifier = Modifier.padding(8.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        label = { Text(text = "kg") },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Mycolors.greenUrun,
            focusedLabelColor = Mycolors.greenUrun
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun kilometers(km: Double, onTextFieldChanged: (Double) -> Unit) {
    val kmText = km.toString()
    OutlinedTextField(
        value = kmText,
        onValueChange = { text ->
            val parsedValue = text.toDoubleOrNull() ?: 0.0
            onTextFieldChanged(parsedValue)
        },
        modifier = Modifier.padding(8.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        label = { Text(text = "km") },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Mycolors.greenUrun,
            focusedLabelColor = Mycolors.backgroundUrun
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun kilocals(kcal: Double, onTextFieldChanged: (Double) -> Unit) {
    val kcalText = kcal.toString()
    OutlinedTextField(
        value = kcalText,
        onValueChange = { text ->
            val parsedValue = text.toDoubleOrNull() ?: 0.0
            onTextFieldChanged(parsedValue)
        },
        modifier = Modifier.padding(8.dp),
        textStyle = androidx.compose.ui.text.TextStyle(color = Color.White),
        label = { Text(text = "kcal") },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Mycolors.greenUrun,
            focusedLabelColor = Mycolors.greenUrun
        )
    )
}