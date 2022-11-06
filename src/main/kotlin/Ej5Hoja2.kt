import Utils.generarArray
import Utils.generarMatrizAleatoria

fun main(){
    var tamaño = 3
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    val array: IntArray = generarArray(matriz, tamaño)
    println("La suma de las filas es:")
    println(generarArraySumaFilas(array, tamaño))
    println("La suma de las columnas es:")
    println(generarArraySumaColumnas(array, tamaño))
}
/**
 * funcion que sirve para sumar las filas de una matriz transformada en array
 * @param array el array que se creo a partir de la matriz de la que queremos sumar los valores de las columnas
 * @param tamaño el tamaño de la matriz que usamos de base
 * @return un mensaje mostrando los resultados
 */
fun generarArraySumaFilas(array: IntArray, tamaño: Int): String{
    var mensaje = StringBuilder()
    var res = 0
    var cont = 1
    var posicion = 0
    var posicion2 = tamaño + tamaño
    while(posicion2 >= 0){
        res = 0
        for (i in (posicion until (array.size - posicion2))) {
            res = res + array[i]
        }
        mensaje.append("Fila ${cont}: $res ")
        posicion = posicion + tamaño
        posicion2 = posicion2 - tamaño
        cont++
    }
    return mensaje.toString()
}
/**
 * funcion que sirve para sumar las columnas de una matriz transformada en array
 * @param array el array que se creo a partir de la matriz de la que queremos sumar los valores de las columnas
 * @param tamaño el tamaño de la matriz que usamos de base
 * @return un mensaje mostrando los resultados
 */
fun generarArraySumaColumnas(array: IntArray, tamaño: Int): String{
    var mensaje = StringBuilder()
    var res = 0
    var posicion = 0
    while(posicion < tamaño){
        for (i in (posicion until array.size) step tamaño) {
            res = res + array[i]
        }
        mensaje.append("Columna ${posicion + 1}: $res ")
        posicion ++
    }
    return mensaje.toString()
}
