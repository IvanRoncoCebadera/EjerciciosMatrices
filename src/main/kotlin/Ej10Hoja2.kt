import Utils.escribirMatriz
import Utils.generarMatrizAleatoria

fun main(){
    var tamaño = 3
    println("La matriz es:")
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    val matrizPermutadaFilas: Array<IntArray> = crearMatrizPermutadaFilas(tamaño, matriz,
        leerFilaPermutar("Por favor, introduzca la primera fila que desea permutar:", tamaño),
        leerFilaPermutar("Por favor, introduzca la segunda fila que permutará con la primera:", tamaño) )
    println("La matriz permutada es:")
    println(escribirMatriz(matrizPermutadaFilas))
    val matrizPermutadaColumnas: Array<IntArray> = crearMatrizPermutadaColumnas(tamaño, matriz,
        leerColumnaPermutar("Por favor, introduzca la primera columna que desea permutar:", tamaño),
        leerColumnaPermutar("Por favor, introduzca la segunda columna que permutará con la primera:", tamaño) )
    println("La matriz permutada es:")
    println(escribirMatriz(matrizPermutadaColumnas))
}

/**
 * funcion para leer el valor de la fila que se desea permutar
 * @param mensaje un texto informativo de la accion a realizar
 * @param tamaño es el tamaño de filas y columnas que tiene la matriz, por lo que es el valor de filas o coulumnas maximos posibles
 * @return el valor de la fila ha permutar
 */
fun leerFilaPermutar(mensaje: String, tamaño: Int): Int{
    println(mensaje)
    var fila = 0
    var minimo = 1
    do {
        fila = readln().toInt()
        if(fila < 1 || fila > tamaño){
            println("Ese valor no está disponible, solo los valores de 1 al $tamaño. Prueba de nuevo:")
        }
    }while(fila < minimo || fila > tamaño)
    return fila - 1
}

/**
 * funcion para leer el valor de la column que se desea permutar
 * @param mensaje un texto informativo de la accion a realizar
 * @param tamaño es el tamaño de filas y columnas que tiene la matriz, por lo que es el valor de filas o coulumnas maximos posibles
 * @return el valor de la columna ha permutar
 */
fun leerColumnaPermutar(mensaje: String, tamaño: Int): Int{
    println(mensaje)
    var columna = 0
    var minimo = 1
    do {
        columna = readln().toInt()
        if(columna < 1 || columna > tamaño){
            println("Ese valor no está disponible, solo los valores de 1 al $tamaño. Prueba de nuevo:")
        }
    }while(columna < minimo || columna > tamaño)
    return columna - 1
}

/**
 * funcion que sirve para crear una matriz tras haber permutado sus filas
 * @param tamaño es el tamaño de filas y columnas que tiene la matriz
 * @param matriz es la matriz cuyas filas permutaremos
 * @param fila1 el valor de la fila que se quiere permutar
 * @param fila2 el valor de la fila que se quiere permutar
 * @return la matriz permutada
 */
fun crearMatrizPermutadaFilas(tamaño: Int, matriz: Array<IntArray>, fila1: Int, fila2: Int): Array<IntArray>{
    val matrizP: Array<IntArray> = Array(tamaño){IntArray(tamaño)}
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(i == fila1){
                matrizP[fila2][j] = matriz[i][j]
            }else {
                if (i == fila2) {
                    matrizP[fila1][j] = matriz[i][j]
                }else{
                    matrizP[i][j] = matriz[i][j]
                }
            }
        }
    }
    return matrizP
}
/**
 * funcion que sirve para crear una matriz tras haber permutado sus columnas
 * @param tamaño es el tamaño de filas y columnas que tiene la matriz
 * @param matriz es la matriz cuyas columnas permutaremos
 * @param columna1 el valor de la columna que se quiere permutar
 * @param columna2 el valor de la columna que se quiere permutar
 * @return la matriz permutada
 */
fun crearMatrizPermutadaColumnas(tamaño: Int, matriz: Array<IntArray>, columna1: Int, columna2: Int): Array<IntArray>{
    val matrizP: Array<IntArray> = Array(tamaño){IntArray(tamaño)}
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(j == columna1){
                matrizP[i][columna2] = matriz[i][j]
            }else {
                if (j == columna2) {
                    matrizP[i][columna1] = matriz[i][j]
                }else{
                    matrizP[i][j] = matriz[i][j]
                }
            }
        }
    }
    return matrizP
}