package com.example.valeriarubiocarrasco.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.valeriarubiocarrasco.R
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen(
    auth: FirebaseAuth,
    onLoginClick: () -> Unit
){
    var email by remember { mutableStateOf("") }
    var password by remember{mutableStateOf("")}
    var onDialogoError by remember{mutableStateOf(false)}


    Column(
        modifier = Modifier
            .fillMaxWidth()

    ){
        Image(
            painter = painterResource(R.drawable.logounicaja_background),
            contentDescription = "Imagen logo unicaja"
        )
        Spacer(modifier = Modifier.width(15.dp))

        Text(text = "Inicia Sesión", fontSize = 25.sp)

        Spacer(modifier = Modifier.width(15.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Email")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth()

        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label ={ Text("Constraseña")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()

        )

        Button(
            onClick ={ onLoginClick()}
        ){
            Text("Login")
        }
    }
}