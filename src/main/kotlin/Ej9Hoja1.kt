fun main(){
    val tamaño = 3
    val matriz: Array<IntArray> = geneararMatrizAleatoria(tamaño)
    println("La matriz inversa de la de arriba se escribe asi:")
    val matrizInversa: Array<IntArray> = generarArray(matriz, tamaño)
}
private fun generarArray(matriz: Array<IntArray>, tamaño: Int): Array<IntArray>{
    var array = IntArray(tamaño*tamaño)
    var cont1 = array.size - 1
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            array[cont1] = matriz[i][j]
            cont1--
        }
    }
    val matrizI: Array<IntArray> = generarMatrizInversa(tamaño, array)
    return matrizI
}
fun generarMatrizInversa(tamaño: Int,array: IntArray ): Array<IntArray>{
    val matrizI: Array<IntArray> = Array(tamaño){IntArray(tamaño)}
    var cont2 = 0
    var mensaje = ""
    for(a in matrizI.indices){
        mensaje = ""
        for(b in matrizI[a].indices){
            matrizI[a][b] = array[cont2]
            mensaje = "$mensaje ${matrizI[a][b]}"
            cont2++
        }
        println(mensaje)
    }
    return matrizI
}
/**
 * funcion para crear una matriz de tamaño el que le demos y con valores aleatorios
 * @param tamaño el tamaño elegido para la matriz, tanto de filas como de columnas
 * @return la matriz con valores aleatorios
 */
private fun geneararMatrizAleatoria(tamaño: Int): Array<IntArray>{
    var mensaje = ""
    val matriz = Array(tamaño){IntArray(tamaño)}
    for(i in matriz.indices){
        mensaje = ""
        for(j in matriz[i].indices){
            matriz[i][j] = (0 .. 9).random()
            mensaje = "$mensaje ${matriz[i][j]}"
        }
        println(mensaje)
    }
    return matriz
}
