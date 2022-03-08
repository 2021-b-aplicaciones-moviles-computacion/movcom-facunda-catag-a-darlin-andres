package com.example.examen2andresfacundav1



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
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore
    val disenadores = db.collection("Disenadores")
    var idItemSeleccionado = -1
    var adaptador: ArrayAdapter<ObjDisenador>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        super.onStart()

        updateDisenadoresList()

        val btn_agregar_disenador = findViewById<Button>(R.id.btn_agregar_disenador)
        btn_agregar_disenador.setOnClickListener {
            val intent = Intent(this, AgregarDisenador::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
        Log.i("context-menu", "ID ${id}")
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        var disenadorSelected: ObjDisenador = adaptador!!.getItem(idItemSeleccionado)!!
        return when(item.itemId){
            R.id.mi_editar_disenador -> {
                Log.i("context-menu","Edit position: ${disenadorSelected.disenadorId}")
                val openEditarDisenador = Intent(this, EditarDisenador::class.java)
                openEditarDisenador.putExtra("Disenador", disenadorSelected)
                startActivity(openEditarDisenador)
                return true
            }
            R.id.mi_eliminar_disenador -> {
                Log.i("context-menu", "Delete position: ${disenadorSelected.disenadorId}")

                disenadores.document("${disenadorSelected.disenadorId}").delete()
                    .addOnSuccessListener {
                        Log.i("DELETE-DISENADOR", "Success")
                    }
                    .addOnFailureListener {
                        Log.i("DELETE-DISENADOR","Failure")
                    }
                updateDisenadoresList()
                return true
            }
            R.id.mi_verdisenos -> {
                Log.i("context-menu","Disenos: ${idItemSeleccionado}")

                val openDisenosList = Intent(this, BVerDisenos::class.java)
                openDisenosList.putExtra("Disenador", disenadorSelected)
                startActivity(openDisenosList)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }


    fun updateDisenadoresList(){
        val lb_disenador = findViewById<ListView>(R.id.lv_list_view_disenador)

        disenadores.get().addOnSuccessListener { result ->
            var disenadoresList = arrayListOf<ObjDisenador>()

            for (document in result){
                disenadoresList.add(
                    ObjDisenador(
                        document.id.toString(),
                        document.get("nombre").toString(),
                        document.get("salario").toString()
                    )
                )
            }

            adaptador = ArrayAdapter(
                this,
                android.R.layout.simple_expandable_list_item_1,
                disenadoresList
            )
            lb_disenador.adapter = adaptador
            adaptador!!.notifyDataSetChanged()

            registerForContextMenu(lb_disenador)
        }.addOnFailureListener {
            Log.i("Error", "Failure retrieving disenadores")
        }
    }
}