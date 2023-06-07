package com.example.urunapp.ui.register.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.urunapp.R
import com.example.urunapp.ui.login.ui.Login
@Preview
@Composable
fun RegisterScreen(){
    Box(
        Modifier
            .fillMaxSize()

            .background(Color(0xFF1E1E1E))) {
        Register(Modifier.align(Alignment.Center))

    }
}
@Composable
fun Register(modifier: Modifier) {
    Column(modifier= modifier) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier =Modifier.padding(16.dp) )
        UserField()
        Spacer(modifier =Modifier.padding(4.dp) )
        EmailField()
        Spacer(modifier =Modifier.padding(8.dp) )
        PasswordField()
        Spacer(modifier =Modifier.padding(8.dp) )
        PasswordConfirmField(modifier =Modifier.padding(8.dp) )
        Spacer(modifier =Modifier.padding(4.dp) )
        RegisterButton()
        Spacer(modifier =Modifier.padding(16.dp) )
        AccountHave(Modifier.align(Alignment.CenterHorizontally))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordConfirmField(modifier: Modifier) {
    TextField(value ="" , onValueChange ={},
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E)
        ))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField() {
    TextField(value ="" , onValueChange ={},
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E)
        ))
}

@Composable
fun AccountHave(modifier: Modifier) {
    Text(
        text = "Ya tienes una cuenta?Inicia sesión",
        modifier = Modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFCCFF00),
    )

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField() {
    TextField(value ="" , onValueChange ={},
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E)
        ))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField() {
    TextField(value = "", onValueChange ={}, modifier = Modifier.fillMaxWidth(), placeholder = { Text(text="Usuario") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E),



            ))

}

@Preview(showBackground = true,showSystemUi = true)
@Composable
fun HeaderImage(Modifier: Modifier) {
    Image(painter = painterResource(id = R.drawable.logo1), contentDescription = "Header",modifier=Modifier)
}

