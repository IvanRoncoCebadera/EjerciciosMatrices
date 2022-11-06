import Utils.escribirMatriz
import Utils.generarMatrizAleatoria

fun main(){
    var tamaño = 6
    println("La matriz es:")
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    println("La matriz girada 90º es:")
    val matrizGirada90º: Array<IntArray> = generarMatrizGirada90º(matriz, tamaño)
    escribirMatriz(matrizGirada90º)
}

/**
 * funcion para girar una matriz 90º
 * @param matriz la matriz que queremos trasponer
 * @param tamaño el tamaño de las filas y columnas de la matriz a trasponer
 * @retrun la matriz girada
 */
private fun generarMatrizGirada90º(matriz: Array<IntArray>, tamaño: Int): Array<IntArray> {
    val matriz2: Array<IntArray> = Array(tamaño){IntArray(tamaño)}
    var cont = 0
    var contColumnas = 1
    for(i in matriz2.indices) {
        cont = 0
        for(j in matriz2[i].indices) {
            if (i == 0) {
                matriz2[cont][tamaño - 1] = matriz[i][j]
                cont++
            }
            if (i == tamaño - 1) {
                matriz2[cont][tamaño - tamaño] = matriz[i][j]
                cont++
            }
            if(i < tamaño - 1 && i > 0) {
                matriz2[cont][tamaño - contColumnas] = matriz[i][j]
                cont++
            }
        }
        contColumnas++
    }
    return matriz2
}