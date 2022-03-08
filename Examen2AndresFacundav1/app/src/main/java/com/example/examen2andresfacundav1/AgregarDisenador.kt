package com.example.examen2andresfacundav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class AgregarDisenador : AppCompatActivity() {
    val db = Firebase.firestore
    val disenadores = db.collection("Disenadores")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_disenador)
    }

    override fun onStart() {
        super.onStart()

        val txt_nombreDisenador = findViewById<TextInputEditText>(R.id.txt_nombreDisenador)
        val txt_cedulaDisenador = findViewById<TextInputEditText>(R.id.txt_cedulaDisenador)
        val txt_salariDisenador = findViewById<TextInputEditText>(R.id.txt_salarioDisenador)
        val btn_agregar_Disenador = findViewById<Button>(R.id.btn_guardar_disenador)

        btn_agregar_Disenador.setOnClickListener {
            var disenador = hashMapOf(
                "nombre" to txt_nombreDisenador.text.toString(),
                "salario" to txt_salariDisenador.text.toString()
            )
            disenadores.add(disenador).addOnSuccessListener {
                Toast.makeText(this, "Ingreso correcto de datos", Toast.LENGTH_SHORT).show()
                Log.i("Agregar disenador", "Success")
            }.addOnFailureListener {
                Log.i("Agregar disenador", "Failed")
            }

            val intentAddSucces = Intent(this, MainActivity::class.java)
            startActivity(intentAddSucces)
        }
    }
}