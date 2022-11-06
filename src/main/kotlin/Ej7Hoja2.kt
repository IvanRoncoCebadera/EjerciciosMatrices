import Utils.escribirMatriz
import Utils.generarMatrizAleatoria

fun main(){
    var tamaño = 3
    println("La matriz es:")
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    println("La matriz traspuesta es:")
    val matrizTraspuesta: Array<IntArray> = generarMatrizGirada90º(matriz, tamaño)
    escribirMatriz(matrizTraspuesta)
    println()
    val matriz2: Array<IntArray> = generarMatrizTraspuesta2(tamaño)
    escribirMatriz(matriz2)
}

/**
 * funcion para trasponer una matriz
 * @param matriz la matriz que queremos trasponer
 * @param tamaño el tamaño de las filas y columnas de la matriz a trasponer
 * @retrun la matriz traspuesta
 */
private fun generarMatrizGirada90º(matriz: Array<IntArray>, tamaño: Int): Array<IntArray> {
    val matrizTraspuesta: Array<IntArray> = Array(tamaño){IntArray(tamaño)}
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            matrizTraspuesta[j][i] = matriz[i][j]
        }
    }
    return matrizTraspuesta
}
/**
 * Para la segunda parte del ejercicio asumo que dos matrices identicas cuentan como una sola matriz
 */
/**
 * funcion para crear una matriz traspuesta sin necesidad de recurrir a otra matriz externa, o al menos eso creo.
 * @param tamaño el tamaño de las filas y columnas de la matriz a trasponer
 * @retrun la matriz traspuesta
 */
fun generarMatrizTraspuesta2(tamaño: Int): Array<IntArray>{
    println("La matriz ya traspuesta es: ")
    val matriz: Array<IntArray> = arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    )
    var recorrido = 0
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(j > recorrido) {
                val valor = matriz[j][i]
                matriz[j][i] = matriz[i][j]
                matriz[i][j] = valor
            }
        }
        recorrido++
    }
    return matriz
}
