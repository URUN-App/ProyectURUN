package com.example.urunapp.ui.register.ui

import com.example.urunapp.ui.register.ui.RegisterViewModel
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.urunapp.R

@Preview
@Composable
fun   RegisterScreen(navController: NavController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF1E1E1E))
            .padding(horizontal = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Register(Modifier.align(Alignment.Center),
            viewModel = RegisterViewModel(), navController)

    }
}


@Composable
fun Register(modifier: Modifier, viewModel: RegisterViewModel, navController: NavController) {

    val email: String by viewModel.email.observeAsState(initial = "")
    val user: String by viewModel.user.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val cpassword: String by viewModel.cpassword.observeAsState(initial = "")
    val registerEnable: Boolean by viewModel.registerEnable.observeAsState(initial = false)
    Column(modifier = modifier,) {
        HeaderImage(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.padding(16.dp))
        EmailField(email) { viewModel.onEmailChanged(it) }
        Spacer(modifier = Modifier.padding(4.dp))
        UserField(user) { viewModel.onUserChanged(it) }
        Spacer(modifier = Modifier.padding(8.dp))
        PasswordField(password) { viewModel.onPasswordChanged(it) }
        Spacer(modifier = Modifier.padding(8.dp))
        PasswordConfirmField(cpassword) { viewModel.onCPasswordChanged(it) }
        Spacer(modifier = Modifier.padding(16.dp))
        RegisterButton(navController)
        Spacer(modifier = Modifier.padding(16.dp))
        AccountHave(Modifier.align(Alignment.CenterHorizontally), modifier.padding(PaddingValues(16.dp)) )


        Spacer(modifier = Modifier.padding(16.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordConfirmField(cpassword: String, onTextFieldChanged: (String) -> Unit) {
    var hidden by remember {mutableStateOf(true)}
    TextField(
        value = cpassword, onValueChange = { onTextFieldChanged(it) },
        placeholder = { Text(text = " Confirmar Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), singleLine = true,
        maxLines = 1,
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E)
        )
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    TextField(value = email,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E),


            )
    )

}

@Composable
fun AccountHave(modifier: Modifier, padding: Modifier) {
    Text(
        text = "Ya tienes una cuenta?Inicia sesión",
        modifier = Modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFFCCFF00),
    )

}

@Composable
fun RegisterButton(navController: NavController) {
    Log.d(TAG, "RegisterButton: Adentro")
    Button(
        onClick = { navController.navigate("register_screen") },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFCCFF00),
            disabledContainerColor = Color.Green,
            contentColor = Color(0xFF1E1E1E),
            disabledContentColor = Color(0xFFCCFF00)
        )
    ) {
        Text(
            text = "Registrarse",

            )
    }
}


@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onTextFieldChanged: (String) -> Unit) {
    var hidden by remember {mutableStateOf(true)}
    TextField(
        value = password, onValueChange = { onTextFieldChanged(it) },
        placeholder = { Text(text = "Contraseña") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), singleLine = true,
        maxLines = 1,
        visualTransformation =
        if (hidden) PasswordVisualTransformation() else VisualTransformation.None,//3

        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E)
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserField(user: String, onTextFieldChanged: (String) -> Unit) {
    TextField(
        value = user,
        onValueChange = { onTextFieldChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Usuario") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFCCFF00),
            containerColor = Color(0xFF1E1E1E),


            )
    )

}


@Composable
fun HeaderImage(Modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.logo1),
        contentDescription = "Header",
        modifier = Modifier
    )
}

