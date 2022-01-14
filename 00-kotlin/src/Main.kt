import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println("hola mundo"); // ;-> no es requerido
    // Tipo nombre=valor;
    // Int edad = 12;

    // Tipos de variables

    // INMUTABLES (val)


    val inmutable: String = "Adrian"
    // inmutable = "Vicente"; // x

    // MUTABLE (var)
    var mutable: String = "Vicente"
    mutable = "Adrian";

    // val -> var se prefiere lo inmutable sobre lo mutable

    // Sintaxis y Duck Typing

    val ejemploVarianle = "Nombre"
    var edadEjemplo = 12
    //edadEjemplo = 12.2

    // Tipos de variables JAVA
    val nombreProfesor: String = "Adrian Eguez"
    val sueldo: Double= 1.2
    val estadoCivil: Char = 'S'
    val fechaNacimiento: Date = Date()

    // Condicionales
    if (true){
        // verdadero
    } else {
        // falso
    }

    // switch Estado -> s -> C -> ::::::
    val estadoCivilWhen: String = "S"

    when (estadoCivilWhen){
        ("S")->{
            println("Acercarse")
        }
        "C"-> {
            println("HAlejarse")
        }
        "UN" -> println("Hablar")
        else -> println("No reconocido")
    }

    val conqueteo = if (estadoCivilWhen== "S") "SI" else "NO"
    // condicion ? bloque-true: bloque-false

    imprimirNombre("Adrian")
    calcularSueldo(100.00)
    calcularSueldo(100.00,14.00)
    calcularSueldo(100.00,14.00,25.00)

    // Named Parameters-> se puede mover los parametros
    calcularSueldo(
        bonoEspecial = 15.00,
        //tasa = 12.00,
        sueldo = 150.00,
    )


    // Tipos de Arreglos
    // arreglo Estatico
    val arregloEstatico: Array<Int> = arrayOf(1,2,3)
    println(arregloEstatico)

    // arreglo Dinámicos
    val arregloDinamico: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7)
    println(arregloDinamico)
    arregloDinamico.add(12)
    println(arregloDinamico)


    // Operadores -> Sirven para los arreglos estaticos y dinamicos

    // FOR EACH -> Unit
    // Iterar un archivo

    val respuestaForEach: Unit = arregloDinamico
        .forEach {  valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    arregloDinamico
        .forEachIndexed { indice: Int, valorActual: Int ->
            println("Valor ${valorActual} Indice: ${indice}")
        }
    println(respuestaForEach)

    // MAP -> Muta el arreglo ( cambia el arreglo)
    // 1) Enviemos el nuevo valor de la interacion
    // 2) Nos devuelve es un NUEVO  ARREGLO con los valores modificados
    val  respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }
    println(respuestaMap)

    val  respuestaMapDos = arregloDinamico.map { it.toDouble()+15.00  }
}

fun imprimirNombre (nombre: String): Unit{ // Unit es el void, y es opcional
    println("Nombre: ${nombre}")
}

fun calcularSueldo(
    sueldo: Double, // Requerido
    tasa: Double=12.00,//OPcional (Defecto)
    bonoEspecial: Double? = null, // Opcional (NULL) -> nullable
):Double {
    // String -> String
    // Int -> Int?
    // Date -> Date?
    if (bonoEspecial == null){
        return sueldo*(100/tasa)
    } else {
        return sueldo * (100 / tasa) + bonoEspecial
    }
}