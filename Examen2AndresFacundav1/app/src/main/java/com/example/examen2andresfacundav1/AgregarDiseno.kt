package com.example.examen2andresfacundav1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText


class AgregarDiseno : AppCompatActivity() {
    var nextID = 0
    var lastID = 0
    var modeloDiseno = ""
    var precio = ""
    var posicionDisenador = 0
    var idPropietarioDisenador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_diseno)
    }

    override fun onStart() {
        super.onStart()
        posicionDisenador = intent.getIntExtra("posicionArquitecto", -1)
        BBaseDatosMemoria.arregloDisenador.forEachIndexed { index: Int, disenadr: BDisenador ->
            if(index == posicionDisenador){
                idPropietarioDisenador = disenadr.cedulaDisenador
            }
        }

        var lengthListaDisenos = BBaseDatosMemoria.arregloDisenos.lastIndex
        BBaseDatosMemoria.arregloDisenos.forEachIndexed { index: Int, diseno: BDiseno ->
            if(index == lengthListaDisenos){
                lastID = diseno.codDiseno
            }
        }

        nextID = lastID + 1

        var txtmodeloDiseno = findViewById<TextInputEditText>(R.id.txt_nombreModelo)
        var txtPrecioDiseno = findViewById<TextInputEditText>(R.id.txt_precioModelo)

        var btn_Guardar_Diseno = findViewById<Button>(R.id.btn_guardar_modelo)
        btn_Guardar_Diseno.setOnClickListener {
            modeloDiseno = txtmodeloDiseno.text.toString()
            precio = txtPrecioDiseno.text.toString()
            BBaseDatosMemoria.arregloDisenos.add(
                BDiseno(nextID, modeloDiseno,precio)
            )
            BBaseDatosMemoria.arregloDisenador_Diseno.add(
                BDisenador_Diseno(idPropietarioDisenador, nextID)
            )
            devolverRespuesta()
        }
    }

    fun devolverRespuesta(){
        val intentDevolverParametros = Intent()
        intentDevolverParametros.putExtra("posicionDisenador", posicionDisenador)
        setResult(
            RESULT_OK,
            intentDevolverParametros
        )
        finish()
    }
}