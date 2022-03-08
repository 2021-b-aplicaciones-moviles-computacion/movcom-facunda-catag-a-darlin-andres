package com.example.examen2andresfacundav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText


class EditarDiseno : AppCompatActivity() {
    var index_Disenador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_diseno)
    }

    override fun onStart() {
        super.onStart()


        val idDiseno = intent.getIntExtra("codDiseno",1)
        index_Disenador = intent.getIntExtra("posicionDisenadorEditar",1)

        val txt_modeloEditarDiseno = findViewById<TextInputEditText>(R.id.txt_newNombreModelo)
        val txt_precioEditarDiseno = findViewById<TextInputEditText>(R.id.txt_newPrecioModelo)

        BBaseDatosMemoria.arregloDisenos.forEachIndexed { index: Int, diseno: BDiseno ->
            if(idDiseno == diseno.codDiseno){
                txt_modeloEditarDiseno.setText(diseno.modeloDiseno)
                txt_precioEditarDiseno.setText(diseno.precioDiseno)
            }
        }

        val btn_GuardarCambiosDiseno = findViewById<Button>(R.id.btn_guardar_editar_proyecto)
        btn_GuardarCambiosDiseno.setOnClickListener {
            BBaseDatosMemoria.arregloDisenos.forEachIndexed { index: Int, diseno: BDiseno ->
                if(idDiseno == diseno.codDiseno){
                    diseno.modeloDiseno = txt_modeloEditarDiseno.text.toString()
                    diseno.precioDiseno = txt_precioEditarDiseno.text.toString()
                }
            }
            devolverRespuesta()
        }

    }
    fun devolverRespuesta(){
        val intentDevolverParametros = Intent()
        intentDevolverParametros.putExtra("posicionDIsenadorEditar", index_Disenador)
        setResult(
            RESULT_OK,
            intentDevolverParametros
        )
        finish()
    }
}