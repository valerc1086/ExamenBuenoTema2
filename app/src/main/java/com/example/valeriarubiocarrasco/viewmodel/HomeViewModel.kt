package com.example.valeriarubiocarrasco.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.valeriarubiocarrasco.model.Jugador
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow


class HomeViewModel: ViewModel(){
    private val db = Firebase.firestore

    private val jugadorCollection = db.collection("jugadores")

    private val _jugador = MutableStateFlow<List<Jugador>>(emptyList())

    val jugador = _jugador

    init{
        getJugador()
    }

    fun getJugador(){
        jugadorCollection.addSnapshotListener { snapshot, error ->
            if(error != null){
                return@addSnapshotListener
            }
            if(snapshot != null){
                val jugadoresList = snapshot.documents.mapNotNull{ doc ->
                    val jugador = doc.toObject(Jugador::class.java)
                    jugador?.id = doc.id
                    jugador
                }

                _jugador.value = jugadoresList
            }
        }
    }

    fun addJugador(nombre: String, numero: Int, posicion: String,
                   nacionalidad: String, urlimagen: String){
        val jugador = Jugador(nombre, numero, posicion, nacionalidad, urlimagen)

        jugadorCollection.add(jugador)
            .addOnFailureListener{e ->
                Log.e("Error firebase", "Error al guardar: ${e.message}",e)
            }
            .addOnSuccessListener {  }
            .addOnCompleteListener {  }
    }

    fun deleteJugador(idJugador: String){
        jugadorCollection.document(idJugador)
            .delete()
            .addOnSuccessListener {
                Log.i("Firebase", "Borrado correcto")
            }
            .addOnFailureListener { e ->
                Log.e("Error Firebase", "Error al eliminar: ${e.message}",e)
            }
    }


}