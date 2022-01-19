package com.example.examenandresfacunda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class AVerDisenador : AppCompatActivity(){
<<<<<<< HEAD

=======
>>>>>>> desarrollo
    var itemSelected = 0

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_verdisenador )
        val listView = findViewById<ListView>( R.id.lst_disenador )
<<<<<<< HEAD
        var arrlistaNombre = arrayListOf<String>()
        BaseDatosMemoria.arrObjDisenador.forEach { disenador: ObjDisenador ->
            arrlistaNombre.add(disenador.nombre.toString())
=======
        var arrDisenadorlistaNombre = arrayListOf<String>()
        BaseDatosMemoria.arrObjDisenador.forEach { disenador: ObjDisenador ->
            arrDisenadorlistaNombre.add(disenador.nombre.toString())
>>>>>>> desarrollo
        }
        val futAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
<<<<<<< HEAD
            arrlistaNombre
=======
            arrDisenadorlistaNombre
>>>>>>> desarrollo
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
        inflater.inflate( R.menu.menu_disenador, menu )
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        itemSelected = id
    }

    override fun onContextItemSelected( item: MenuItem ): Boolean {
        return when( item.itemId ) {
            R.id.disenador_editar -> {
                openActivityWithParameters( AEditarDisenador::class.java )
                return true
            }
            R.id.disenador_eliminar -> {
                delete( itemSelected )
                return true
            }
            R.id.disenador_verDisenios -> {
                openActivityWithParameters( BVerDiseno::class.java )
                return true
            }
            else -> return super.onContextItemSelected( item )
        }
    }

    fun openActivityWithParameters(
        clase: Class<*>
    ){
        val intentDisenadorlista = Intent(this,clase)
        intentDisenadorlista.putExtra( "posicion", itemSelected + 1)
        startActivity( intentDisenadorlista )
    }

    fun delete(
        itemSelected: Int
    ){
        val listViewFutbolistas = findViewById<ListView>( R.id.lst_disenador )
        BaseDatosMemoria.arrObjDisenador.removeAt( itemSelected )
        var arrDisenadorNombre = arrayListOf<String>()
        BaseDatosMemoria.arrObjDisenador.forEach { disenador: ObjDisenador ->
            arrDisenadorNombre.add(disenador.nombre.toString())
        }
        val futAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrDisenadorNombre
        )
        listViewFutbolistas.adapter = futAdapter
        futAdapter.notifyDataSetChanged()
    }
}