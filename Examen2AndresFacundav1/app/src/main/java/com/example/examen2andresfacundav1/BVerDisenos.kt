package com.example.examen2andresfacundav1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class BVerDisenos : AppCompatActivity() {
    var idItemSeleccionado = 0
    var disenadr_owner = ObjDisenador("", "", "")
    val db = Firebase.firestore
    val disenadores = db.collection("Disenadores")
    var adaptador: ArrayAdapter<ObjDiseno>? = null

    var resultAddNewDiseno = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            if (result.data != null) {
                val data = result.data
                disenadr_owner = intent.getParcelableExtra<ObjDisenador>("Disenador")!!
            }
        }
    }

    var resultEditarDiseno = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            if (result.data != null) {
                val data = result.data
                disenadr_owner = intent.getParcelableExtra<ObjDisenador>("Disenador")!!
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bver_disenos)
    }

    override fun onStart() {
        super.onStart()
        updateProyectosList()


        val btn_add_diseno = findViewById<Button>(R.id.btn_agregar_diseno)
        btn_add_diseno.setOnClickListener {
            val openAgregarDiseno = Intent(this, AgregarDiseno::class.java)
            openAgregarDiseno.putExtra("Disenadores", disenadr_owner)
            resultAddNewDiseno.launch(openAgregarDiseno)
        }

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menudiseno, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
        Log.i("id disenador por diseno", "ID ${idItemSeleccionado}")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var disenoSelected: ObjDiseno = adaptador!!.getItem(idItemSeleccionado)!!
        return when (item.itemId) {
            R.id.mi_editar_diseno -> {
                Log.i("context-menu", "Edit position: ${idItemSeleccionado}")
                val openEditarDiseno = Intent(this, EditarDiseno::class.java)
                openEditarDiseno.putExtra("Disenadores", disenadr_owner)
                openEditarDiseno.putExtra("Disenador", disenoSelected)
                resultEditarDiseno.launch(openEditarDiseno)
                return true
            }
            R.id.mi_eliminar_diseno -> {
                Log.i("context-menu", "Delete position: ${idItemSeleccionado}")
                val arquitectoSubCollection = disenadores.document("F68e1hSS7bzGYFDbU1C4")
                    .collection("Disenos")
                    .document("F68e1hSS7bzGYFDbU1C4")
                    .delete()
                    .addOnSuccessListener {
                        Log.i("DELETE-DISENO", "Success")
                    }
                    .addOnFailureListener {
                        Log.i("DELETE-DISENO", "Failure")
                    }
                updateProyectosList()
                return true
            }
            else -> super.onContextItemSelected(item)
        }

    }

    fun updateProyectosList() {
        Log.i("DELETE-DISENO", "ID = ${disenadr_owner.disenadorId}")
        val disenadorSubCollection = disenadores.document("${disenadr_owner.disenadorId}")
            .collection("Disenos")
            .whereEqualTo("disenadorDiseno", "${disenadr_owner.disenadorId}")

        val lv_diseno = findViewById<ListView>(R.id.lv_disenos)

        disenadorSubCollection.get().addOnSuccessListener { result ->
            var disenosList = arrayListOf<ObjDiseno>()

            for (document in result) {
                disenosList.add(
                    ObjDiseno(
                        document.id.toString(),
                        document.data.get("modeloDiseno").toString(),
                        document.data.get("precio").toString(),
                        document.data.get("disenadorDiseno").toString(),
                    )
                )
            }

            adaptador = ArrayAdapter(
                this,
                android.R.layout.simple_expandable_list_item_1,
                disenosList
            )

            lv_diseno.adapter = adaptador
            adaptador!!.notifyDataSetChanged()

            registerForContextMenu(lv_diseno)
        }
    }
}