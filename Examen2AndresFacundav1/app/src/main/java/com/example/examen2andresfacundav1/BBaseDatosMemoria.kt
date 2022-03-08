package com.example.examen2andresfacundav1

class BBaseDatosMemoria {
    companion object{
        var arregloDisenador = arrayListOf<BDisenador>()
        var arregloDisenos = arrayListOf<BDiseno>()
        var arregloDisenador_Diseno = arrayListOf<BDisenador_Diseno>()

        init {
            //Disenadores
            arregloDisenador.add(
                BDisenador(1713990602,"Miguel Cardenas","100.0")
            )
            arregloDisenador.add(
                BDisenador(1729482119,"Diana Gales","2500.0")
            )
            arregloDisenador.add(
                BDisenador(1711299584,"Samantha Galarza","1850.0")
            )
            arregloDisenador.add(
                BDisenador(1799433221,"Esteban Guerrero","1000.0")
            )
            arregloDisenador.add(
                BDisenador(1872237463,"Julian Venegas","1399.0")
            )

            //Diseños
            arregloDisenos.add(
                BDiseno(1,"SOHO NY","17800200.0")
            )
            arregloDisenos.add(
                BDiseno(2,"YOO UIO","8600590.40")
            )
            arregloDisenos.add(
                BDiseno(3,"Calibur LIM","239000.12")
            )
            arregloDisenos.add(
                BDiseno(4,"One Tower NY","37000000.0")
            )
            arregloDisenos.add(
                BDiseno(5,"Square NY","68900400.0")
            )
            arregloDisenos.add(
                BDiseno(6,"Flex LIM","3200380.0")
            )
            arregloDisenos.add(
                BDiseno(7,"Unique UIO","4000230.0")
            )
            arregloDisenos.add(
                BDiseno(8,"Torre Bellavista BOG","2000370.16")
            )
            arregloDisenos.add(
                BDiseno(9,"Torre Centenario STG","22890000.0")
            )
            arregloDisenos.add(
                BDiseno(10,"La Bordadora LAX", "5900345.12")
            )

            //Diseñadores con sus diseños
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1713990602,1)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1713990602,2)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1729482119,3)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1729482119,4)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1711299584,5)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1711299584,6)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1799433221,7)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1799433221,8)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1872237463,9)
            )
            arregloDisenador_Diseno.add(
                BDisenador_Diseno(1872237463,10)
            )
        }
    }
}