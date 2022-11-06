import Utils.generarMatrizAleatoria

fun main(){
    var tamaño = 3
    println("La primera matriz es:")
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    println("La segunda matriz es:")
    val matrizCalculada: Array<IntArray> = generaraMatrizCalculos(matriz, tamaño)

}

/**
 * funcion que sirve para crear una matriz como se nos pide en el enunciado
 * @param matriz la matriz que usaremos de base para el ejercicio
 * @param tamaño el tamaño de la matriz que usamos de base
 * @return la nueva matriz como pide el enunciado
 */
fun generaraMatrizCalculos(matriz: Array<IntArray>, tamaño: Int): Array<IntArray>{
    var mensaje = ""
    var res1 = 0
    var mensaje2 = ""
    val matriz2: Array<IntArray> = Array(tamaño + 1){IntArray(tamaño + 1)}
    var array: IntArray = generarArray(matriz, tamaño)
    for(a in matriz2.indices){
        res1 = 0
        mensaje = ""
        for(b in matriz2[a].indices){
            if(a < tamaño) {
                if (b < tamaño) {
                    res1 = res1 + matriz[a][b]
                    matriz2[a][b] = matriz[a][b]
                    mensaje = "$mensaje ${matriz2[a][b]}"
                } else {
                    matriz2[tamaño - 1][tamaño - 1] = res1
                    mensaje = "$mensaje ${matriz2[tamaño - 1][tamaño - 1]}"
                    matriz2[a][b] = generarSumaColumnas(array, tamaño, a)
                }
            }else{
                if(b < tamaño) {
                    matriz2[a][b] = generarSumaColumnas(array, tamaño, b)
                    mensaje = "$mensaje ${matriz2[a][b]}"
                }else{
                    mensaje = "$mensaje 0"
                }
            }

        }

        println(mensaje)
    }
    println(mensaje2)
    return matriz2
}
/**
 * funcion que sirve para crear un array en base a una matriz
 * @param matriz la matriz que usaremos de base para generar un array
 * @param tamaño el tamaño de la matriz que usamos de base
 * @return el array creado en funcion de la matriz
 */
private fun generarArray(matriz: Array<IntArray>, tamaño: Int): IntArray{
    val array: IntArray = IntArray(tamaño*tamaño)
    var cont = 0
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            array[cont] = matriz[i][j]
            cont++
        }
    }
    return array
}
/**
 * funcion que sirve para sumar los valores de las columnas de una matriz
 * @param array el array que se creo a partir de la matriz de la que queremos sumar los valores de las columnas
 * @param tamaño el tamaño de la matriz que usamos de base
 * @param posicion la posicion de columna por la que debemos empezar a sumar
 * @return el resultado de la suma de los valores de la columna
 */
fun generarSumaColumnas(array: IntArray, tamaño: Int, posicion: Int): Int{
    var res = 0
    for(i in (posicion until array.size) step tamaño ){
        res = res + array[i]
    }
    return res
}