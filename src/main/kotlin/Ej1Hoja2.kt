import java.util.Arrays

fun main(){
    var tamaño = 3
    println("La matriz es:")
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    var sumaPares = generarSumaPares(matriz)
    var sumaImpares = generarSumaImpares(matriz)
    val array: IntArray = generarArray(matriz, tamaño)
    var sumaPosPar = generarSumaPosPar(array)
    var sumaPosImpar = generarSumaPosImpar(array)
    println("Los resultados pedidos, son: $sumaPares, $sumaImpares, $sumaPosPar y $sumaPosImpar.")
}

/**
 * funcion para hacer la suma de todos los numeros pares de la matriz
 * @param matriz la matirz con los numero ha operar
 * @return el resultado de la suma
 */
fun generarSumaPares(matriz: Array<IntArray>): Int{
    var res = 0
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(matriz[i][j] % 2 == 0){
                res = res + matriz[i][j]
            }
        }
    }
    return res
}
/**
 * funcion para hacer la suma de todos los numeros impares de la matriz
 * @param matriz la matirz con los numero ha operar
 * @return el resultado de la suma
 */
fun generarSumaImpares(matriz: Array<IntArray>): Int{
    var res = 0
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(matriz[i][j] % 2 != 0){
                res = res + matriz[i][j]
            }
        }
    }
    return res
}
/**
 * funcion para hacer la suma de todos los numeros en posiciones pares de la matriz
 * @param matriz la matirz con los numero ha operar
 * @return el resultado de la suma
 */
fun generarSumaPosPar(array: IntArray): Int{
    var res = 0
    for(i in array.indices){
        if(i % 2 == 0){
            res = res + array[i]
        }
    }
    return res
}
/**
 * funcion para hacer la suma de todos los numeros en posiciones impares de la matriz
 * @param matriz la matirz con los numero ha operar
 * @return el resultado de la suma
 */
fun generarSumaPosImpar(array: IntArray): Int{
    var res = 0
    for(i in array.indices){
        if(i % 2 != 0){
            res = res + array[i]
        }
    }
    return res
}
/**
 * funcion para crear una matriz de tamaño el que le demos y con valores aleatorios
 * @param tamaño el tamaño elegido para la matriz, tanto de filas como de columnas
 * @return la matriz con valores aleatorios
 */
private fun generarMatrizAleatoria(tamaño: Int): Array<IntArray>{
    var mensaje = ""
    val matriz = Array(tamaño){IntArray(tamaño)}
    for(i in matriz.indices){
        mensaje = ""
        for(j in matriz[i].indices){
            matriz[i][j] = (0 .. 10).random()
            mensaje = "$mensaje ${matriz[i][j]}"
        }
        println(mensaje)
    }
    return matriz
}
/**
 * funcion para pasar una matriz a vector
 * @param matriz la matirz que se debe transformar en array
 * @param tamaño el tamaño de las filas y columnas de la matriz
 * @return la matriz convertida en array
 */
private fun generarArray(matriz: Array<IntArray>, tamaño: Int): IntArray{
    val array: IntArray = IntArray(tamaño*tamaño)
    var cont = 0
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(matriz[i][j] % 2 != 0){
                array[cont] = matriz[i][j]
                cont ++
            }
        }
    }
    return array
}
