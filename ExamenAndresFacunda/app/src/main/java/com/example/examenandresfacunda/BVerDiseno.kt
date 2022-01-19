package com.example.examenandresfacunda


import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class BVerDiseno : AppCompatActivity() {

    var itemSelected = 0
    var idDisenador = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idDisenador = intent.getIntExtra("posicion",1)
        setContentView(R.layout.activity_verdisenio)
        val txtNombre = findViewById<TextView>(R.id.txt_nombreDisenador)
        val listView = findViewById<ListView>( R.id.lst_disenio )
        var arrDisenioModelo = arrayListOf<String>()
        BaseDatosMemoria.arrObjDisenador.forEachIndexed { index: Int, disenador: ObjDisenador ->
            if(index == idDisenador){
                txtNombre.setText(disenador.nombre.toString())
            }
        }
        BaseDatosMemoria.arrObjDisenos.forEach { disenio: ObjDisenos ->
            if ( disenio.id == idDisenador )
                arrDisenioModelo.add(disenio.modelo.toString())
        }
        val futAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,

            arrDisenioModelo
        )
        listView.adapter = futAdapter
        futAdapter.notifyDataSetChanged()
        registerForContextMenu( listView )
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu( menu, v, menuInfo )
        var inflater = menuInflater
        inflater.inflate( R.menu.menu_disenios, menu )
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        itemSelected = id
    }

    override fun onContextItemSelected( item: MenuItem): Boolean {
        return when( item.itemId ) {
            R.id.disenio_editar -> {
                openActivityWithParameters( AEditarDiseno::class.java )
                return true
            }
            R.id.disenio_eliminar -> {
                delete( itemSelected )
                return true
            }
            else -> return super.onContextItemSelected( item )
        }
    }

    fun openActivityWithParameters(
        clase: Class<*>
    ){
        val intentDisenio = Intent(this,clase)
        intentDisenio.putExtra( "posicion", itemSelected )
        startActivity( intentDisenio )
    }

    fun delete(
        itemSelected: Int
    ){
        val listViewGoles = findViewById<ListView>( R.id.lst_disenio )
        BaseDatosMemoria.arrObjDisenos.removeAt( itemSelected )
        var arrDisenosModelo = arrayListOf<String>()
        BaseDatosMemoria.arrObjDisenos.forEach { disenios: ObjDisenos ->
            if ( disenios.id == idDisenador )
                arrDisenosModelo.add(disenios.modelo.toString())
        }
        val futAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrDisenosModelo
        )
        listViewGoles.adapter = futAdapter
        futAdapter.notifyDataSetChanged()
    }
}