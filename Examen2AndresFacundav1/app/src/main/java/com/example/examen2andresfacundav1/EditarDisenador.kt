package com.example.examen2andresfacundav1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class EditarDisenador : AppCompatActivity() {

    var disenadores_update = ObjDisenador("","","")
    val db = Firebase.firestore
    val disenadores = db.collection("Disenadores")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_disenador)
    }

    override fun onStart() {
        super.onStart()

        disenadores_update = intent.getParcelableExtra<ObjDisenador>("Disenador")!!

        val in_disenador_nombre = findViewById<EditText>(R.id.txt_newNombreDisenador)
        in_disenador_nombre.setText(disenadores_update.disenadorNombre.toString())

        val in_disenador_salario = findViewById<EditText>(R.id.txt_newSalarioDisenador)
        in_disenador_salario.setText(disenadores_update.salario.toString())


        val btnGuardarCambiosDisenador = findViewById<Button>(R.id.btn_guardar_editar_disenador)
        btnGuardarCambiosDisenador.setOnClickListener {
            disenadores.document("${disenadores_update.disenadorId}").update(
                "nombre", in_disenador_nombre.text.toString(),
                "salario",in_disenador_salario.text.toString()
            )
            Toast.makeText(this, "Cambios guardados", Toast.LENGTH_SHORT).show()
        }
    }
}