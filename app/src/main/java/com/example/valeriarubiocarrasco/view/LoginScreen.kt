package com.example.valeriarubiocarrasco.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    Card(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Imagen logo unicaja"
            )
            Spacer(modifier = Modifier.width(25.dp))

            Text(text = "Inicia Sesión", fontSize = 25.sp)

            Spacer(modifier = Modifier.width(25.dp))

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
                onClick ={
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnSuccessListener{ user->
                            onLoginClick()
                        }
                        .addOnFailureListener { e ->
                            Log.e("Firebase", "Error en login ${e.message}",e)
                            onDialogoError = true
                        }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF27D21F)
                )

            ){
                Text("Login", fontSize = 18.sp, color = Color.White)
            }

            if(onDialogoError){
                AlertDialog(
                    onDismissRequest = {onDialogoError = false},
                    title = {Text("Login")},
                    text ={Text( "Usuario o contraseña incorrectos")},
                    confirmButton = {
                        TextButton(
                            onClick = {
                                onDialogoError = false
                            }
                        ){
                            Text("Aceptar")
                        }
                    }
                )
        }
    }
    }
}