package com.example.valeriarubiocarrasco.viewmodel

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class HomeViewModel: ViewModel(){
    private val db = Firebase.firestore

    private val jugadorCollection = db.collection("jugadores")

    private val _jugador = MutableStateFlow<List<Jugador>>(emptyList<>())
    val jugador =


}