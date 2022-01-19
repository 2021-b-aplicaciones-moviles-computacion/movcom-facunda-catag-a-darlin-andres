package com.example.examenandresfacunda

class BaseDatosMemoria {

    companion object {

        val arrObjDisenador = arrayListOf<ObjDisenador>()
        val arrObjDisenos = arrayListOf<ObjDisenos>()

        init {

            arrObjDisenador
                .add(
                    ObjDisenador( 1, "Gabrielle Chanel", 30, false, 4.01 )
                )
            arrObjDisenador
                .add(
                    ObjDisenador( 2, "Christian Dior", 35, true, 4.51 )
                )
            arrObjDisenador
                .add(
                    ObjDisenador( 3, "Carolina Herrera", 29, true, 3.51 )
                )

            arrObjDisenos
                .add(
                    ObjDisenos( 1, "Peacoats", true, 2300.99, 1 )
                )
            arrObjDisenos
                .add(
                    ObjDisenos( 2, "Short, technical-cady peacoat", true, 1250.49, 2 )
                )
            arrObjDisenos
                .add(
                    ObjDisenos( 3, "Silk cady sheath dress", false, 900.19, 3 )
                )

        }

    }
}