package com.example.examenandresfacunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class AEditarDisenador : AppCompatActivity(){

    var idDisenador = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editardisenador)
        idDisenador = intent.getIntExtra("posicion",1)
        val txtAfiliado = findViewById<TextInputEditText>(R.id.txt_editar_afiliado)
        val txtPopularida = findViewById<TextInputEditText>(R.id.txt_editar_popularidad)
        val tvNombre = findViewById<TextView>(R.id.tv_editar_nombre)
        BaseDatosMemoria.arrObjDisenador.forEachIndexed { index: Int, disenador: ObjDisenador ->
            if(index == idDisenador){
                tvNombre.setText(disenador.nombre.toString())
                txtAfiliado.setText(disenador.afiliado.toString())
                txtPopularida.setText(disenador.popularidad.toString())
            }
        }
        val btnSave = findViewById<Button>(R.id.btn_save_disenador)
        btnSave.setOnClickListener {
            BaseDatosMemoria.arrObjDisenador.forEachIndexed { index: Int, disenador: ObjDisenador ->
                if(index == idDisenador){
                    disenador.afiliado = txtAfiliado.text.toString().trim().toBoolean()
                    disenador.popularidad = txtPopularida.text.toString().trim().toDouble()
                }
            }
            val intentDisenador = Intent(this, AVerDisenador::class.java)
            startActivity(intentDisenador)
        }
    }
}