package Utils.Utilidades

import Utils.generarMatrizAleatoria


fun main(){
    var tamaño = 3
    println("Primera matriz:")
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    println("El vaector de los numeros más grandes de cada fila es: ${generarVectorEscrito(generarMediaMaximosFila(matriz, tamaño))}")
}
fun generarVectorEscrito(array: IntArray): String{
    var mensaje = StringBuilder()
    for(j in array.indices){
        if(j == 0){
            mensaje.append("[${array[j]}, ")
        }else {
            if (j != 0 && j < array.size - 1) {
                mensaje.append("${array[j]}, ")
            } else {
                mensaje.append("${array[j]}]")
            }
        }
    }
    return mensaje.toString()
}
/**
 * funcion para calcular la media de los valores max de cada fila de una matriz de tamaño, el que le demos
 * @param matriz la matriz con la que operaremos
 * @param tamaño el tamaño de las filas y columnas de la matriz
 * @return el resultado de calcular la media
 */
private fun generarMediaMaximosFila(matriz: Array<IntArray>, tamaño: Int): IntArray{
    var cont = 0
    var valorMax = 0
    val array: IntArray = IntArray(tamaño)
    while(cont < tamaño){
        valorMax = matriz[cont][0]
        for(i in matriz[cont]){
            if(i > valorMax){
                valorMax = i
            }
        }
        array[cont] = valorMax
        cont++
    }
    return array
}
