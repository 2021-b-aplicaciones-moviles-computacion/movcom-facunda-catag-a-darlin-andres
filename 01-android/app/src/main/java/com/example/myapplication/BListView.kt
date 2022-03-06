package com.example.myapplication

import android.content.DialogInterface
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
import androidx.appcompat.app.AlertDialog

class BListView : AppCompatActivity() {
    var idItemSeleccionado = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blist_view)

    val ListView = findViewById<ListView>(R.id.lv_list_view)
    val arreglo: ArrayList<Int> = arrayListOf(1,2,3,4,5)

    val adaptador = ArrayAdapter(
        this, // Contexto
        android.R.layout.simple_list_item_1, // como se va a ver (xml)
        arreglo// arreglo
    )
    ListView.adapter = adaptador
    adaptador.notifyDataSetChanged()

    val botonAnadirListView = findViewById<Button>(R.id.btn_anadir_list_view)
    botonAnadirListView.setOnClickListener {
            anadirItem(adaptador,arreglo,1)
        }

        //1)Registrar menu contextual
        //this.register.ContextMenu(ListView)
        unregisterForContextMenu(ListView)

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

    }

    // 3) que opcion se selecciono


    override fun onContextItemSelected(
        item: MenuItem
    ): Boolean {
        return when(item.itemId){
            R.id.mi_editar -> {
                Log.i("context-menu","Editar posicion: ${idItemSeleccionado}")
                abrirDialogo()
                return true
            }
            R.id.mi_eliminar -> {
                Log.i("context-menu","Editar posicion : ${idItemSeleccionado}")
                return true
            }
            else -> return super.onContextItemSelected(item)
        }

    }

    fun abrirDialogo(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Titulo")
        //builder.setMessage("Descripcion") // el mensaje no deja visualizar los multiples chox
        val opciones = resources.getStringArray(
            R.array.string_array_opciones_dialogo
        )
        val seleccionPrevia = booleanArrayOf(
            true,
            false,
            false
        )
        builder.setMultiChoiceItems(
            opciones,
            seleccionPrevia,
            {
                dialog,
                which,
                isChecked -> Log.i("dialogo", "Dio clic en el item ${which}")
            }
        )

        builder.setPositiveButton(
            "Aceptar",
            DialogInterface.OnClickListener{ dialog, which ->
                Log.i("dialogo", "hola")
            }
        )

        builder.setNegativeButton(
            "Cancelar",
            null
        )

        val dialogo = builder.create()
        dialogo.show()
    }

    fun anadirItem(
        adaptador: ArrayAdapter<Int>,
        arreglo: ArrayList<Int>,
        valor: Int
    ){
        arreglo.add(valor)
        adaptador.notifyDataSetChanged()
    }
}