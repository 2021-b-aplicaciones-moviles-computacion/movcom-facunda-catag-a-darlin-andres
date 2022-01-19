package com.example.examenandresfacunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class AEditarDiseno : AppCompatActivity() {
    var idDiseno = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editardiseno)
        idDiseno = intent.getIntExtra("posicion",1)
        val txtExclusivo = findViewById<TextInputEditText>(R.id.txt_editar_exclusivo)
        val txtCosto = findViewById<TextInputEditText>(R.id.txt_editar_costo)
        val txtModelo = findViewById<TextView>(R.id.txt_editar_modelo)
        BaseDatosMemoria.arrObjDisenos.forEachIndexed { index: Int, disenos: ObjDisenos ->
            if(index == idDiseno){
                txtModelo.setText(disenos.modelo.toString())
                txtExclusivo.setText(disenos.exclusivo.toString())
                txtCosto.setText(disenos.costo.toString())
            }
        }
        val btnSave = findViewById<Button>(R.id.btn_save_diseno)
        btnSave.setOnClickListener {
            BaseDatosMemoria.arrObjDisenos.forEachIndexed { index: Int, disenos: ObjDisenos ->
                if(index == idDiseno){
                    disenos.modelo = txtModelo.text.toString()
                    disenos.exclusivo = txtExclusivo.text.toString().trim().toBoolean()
                    disenos.costo = txtCosto.text.toString().trim().toDouble()
                }
            }
            val intentDiseno = Intent(this, BVerDiseno::class.java)
            startActivity(intentDiseno)
        }
    }
}