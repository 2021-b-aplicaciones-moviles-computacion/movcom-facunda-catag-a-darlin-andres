package com.example.examenandresfacunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDisenador = findViewById<Button>(R.id.ir_disenador)
        btnDisenador.setOnClickListener {
            openActivity(AVerDisenador::class.java)
        }
    }
    fun openActivity(
        clase: Class<*>,
    ) {
        val intent = Intent( this,clase )
        startActivity( intent )
    }
}