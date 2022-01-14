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
    // Filtrar -> Filtra el arreglo
    // 1) Devolver una expresion (true o false)
    // 2) Nuevo arreglo filtrado
    val respuestaFiltrar: List<Int> = arregloDinamico
        .filter { valorActual: Int ->
            val mayoresACinco: Boolean = valorActual > 5
            return@filter mayoresACinco
        }
    val respuestaFiltrarDos = arregloDinamico.filter { it <= 5 }
    println(respuestaFiltrar)
    println(respuestaFiltrarDos)

    // OR AND
    // OR -> ANY (Alguno cumple?)
    // AND -> ALL (Todos cumplen?)
    val respuestaAny: Boolean = arregloDinamico
        .any { valorActual: Int ->
        return@any (valorActual>5)
    }
    println(respuestaAny) // true

    val respuestaAll: Boolean = arregloDinamico
        .all { valorActual: Int ->
            return@all (valorActual>5)
        }
    println(respuestaAll) // false

    // REDUCE -> Valor acumulado
    // Valor acumulado = 0 (Siempre en lenguaje Kotlin )
    // [1,2,3,4,5] -> Sumeme todos los valores del arreglo
    // valorIteracion1 = valorEmpieza +1 = 0 +1 = 1 ->iteración 1
    // valorIteracion2 = valorEmpieza1 +2 = 1 +2 = 3 ->iteración 2
    // valorIteracion3 = valorEmpieza2 +3 = 3 +3 = 6 ->iteración 3
    // valorIteracion4 = valorEmpieza3 +4 = 6 +4 = 10 ->iteración 4
    // valorIteracion5 = valorEmpieza4 +5 = 10 +5 = 15 ->iteración 5


    val respuestaReduce: Int = arregloDinamico
        .reduce{//acumulado = 0 -> Siempre empieza en 0
            acumulado: Int, valorActual: Int ->
            return@reduce (acumulado + valorActual)// ->logica negocio
        }

    println(respuestaReduce)

    //100
    //[12,15,8,10]
    val arregloDanio = arrayListOf<Int>(12,15,8,10)
    val respuestaReduceFold = arregloDanio
        .fold(100,// acumulado inicial
            { acumulado, valorAcualIteracion ->
                return@fold acumulado - valorAcualIteracion
            }
        )
    println(respuestaReduceFold)

    val vidaActual: Double = arregloDinamico
        .map { it * 2.3 } // arreglo
        .filter { it > 20 } // arreglo
        .fold(100.00, {acc,i -> acc-i})//valor
        .also { println(it) } // ejecutar codigo extra
    println("Valor vida actual ${vidaActual}")





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



abstract class NumerosJava{
    protected val numeroUno: Int //Propiedad clase
    private val numeroDos: Int //Propiedad clase
    constructor(
        uno: Int, //Parametros requeridos
        dos: Int, //Parametros requeridos
    ){
        //this.numeroUno = uno
        //this.numeroDos = dos
        numeroUno= uno
        numeroDos = dos
        println("Inicializar")
    }
}


abstract class Numeros(
    // Constructor Primario
    protected val numeroUno: Int, //Propiedad clase
    protected val numeroDos: Int, //Propiedad clase
){
    init{ // bloque inicio del constructor primario
        println("Inicializar")
    }
}

// instancia.numeroUno
// instancia.numeroDos



abstract class Suma(
    // Constructor Primario
    uno: Int, //Parametros requeridos
    dos: Int, //Parametros requeridos
):Numeros(// Constructor "papa" (super)
    uno,
    dos
) {
    init{ // bloque inicio del constructor primario
        this.numeroUno
        this.numeroDos
        //X-> this.uno -> NO EXISTE
        //X-> this.dos -> NO EXISTE
    }

    // public fun sumar(): Int{
    fun sumar(): Int {
        // val total: Int = this.numeroUno + this.numeroDos
        val total: Int = numeroUno + numeroDos
        return total
    }
}