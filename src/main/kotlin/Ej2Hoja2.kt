fun main(){
    var tamaño = 3
    println("Primera matriz:")
    val matriz: Array<IntArray> = geneararMatrizAleatoria(tamaño)
    var media = generarMediaMaximosFila(matriz, tamaño)
    println("La media de los valores más grandes de cada fila en una matriz de ${tamaño}x${tamaño} es: $media")
}

/**
 * funcion para calcular la media de los valores max de cada fila de una matriz de tamaño, el que le demos
 * @param matriz la matriz con la que operaremos
 * @param tamaño el tamaño de las filas y columnas de la matriz
 * @return el resultado de calcular la media
 */
private fun generarMediaMaximosFila(matriz: Array<IntArray>, tamaño: Int): Double{
    var cont = 0
    var media = 0.0
    var valorMax = 0
    while(cont < tamaño){
        valorMax = matriz[cont][0]
        for(i in matriz[cont]){
            if(i > valorMax){
                valorMax = i
            }
        }
        media = media + valorMax
        cont++
    }
    media = media/tamaño
    return media
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