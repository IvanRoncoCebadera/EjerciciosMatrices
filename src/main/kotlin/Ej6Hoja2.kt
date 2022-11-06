import Utils.generarMatrizAleatoria

fun main(){
    var tamaño = 6
    println("La matriz es:")
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    var sumaDiagonalPrincipal = generarSumaDiagonalPrincipalMatriz(matriz, tamaño)
    var sumaDiagonalSecundaria = generarSumaDiagonalSecundariaMatriz(matriz, tamaño)
    println("La suma de los elemento de la diagonal principal es: $sumaDiagonalPrincipal")
    println("La suma de los elemento de la diagonal secundaria es: $sumaDiagonalSecundaria")
    println("Por tanto la suma de estos resultados es: ${sumaDiagonalPrincipal + sumaDiagonalSecundaria}")
}

/**
 * funcion para hallar la suma de todos los elementos de la diagonal principal de una matriz
 * @param matriz la matriz con la que vamos a operar
 * @param tamaño el tamaño de las filas y columnas de la matriz, por lo que tambien el tamaño de valores de la diagonal que hay que sumar
 * @return la suma de los valores de la diagonal principal
 */
fun generarSumaDiagonalPrincipalMatriz(matriz: Array<IntArray>, tamaño: Int): Int{
    var resultado = 0
    var posicionI = 0
    var posicionJ = 0
    while(posicionI < tamaño){
        resultado = resultado + matriz[posicionI][posicionJ]
        posicionI++
        posicionJ++
    }
    return resultado
}
/**
 * funcion para hallar la suma de todos los elementos de la diagonal secundaria de una matriz
 * @param matriz la matriz con la que vamos a operar
 * @param tamaño el tamaño de las filas y columnas de la matriz, por lo que tambien el tamaño de valores de la diagonal que hay que sumar
 * @return la suma de los valores de la diagonal secundaria
 */
fun generarSumaDiagonalSecundariaMatriz(matriz: Array<IntArray>, tamaño: Int): Int {
    var resultado = 0
    var posicionI = tamaño - 1
    var posicionJ = 0
    while (posicionJ < tamaño) {
        resultado = resultado + matriz[posicionI][posicionJ]
        posicionI--
        posicionJ++
    }
    return resultado
}