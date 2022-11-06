fun main(){
    var tamaño = 5
    val matrizAleatoria = geneararMatrizAleatoria(tamaño)
    var max = encontrarMaximo(matrizAleatoria)
    println("El valor maximo de la matriz es: $max")
    var min = encontrarMinimo(matrizAleatoria)
    println("El valor minimo de la matriz es: $min")
    var media = generarMedia(matrizAleatoria)
    println("La media de todos los valores de la matriz es: $media.")
    var elemento = 10
    println("El elemento $elemento, ${busquedaSecuencial(elemento, matrizAleatoria)}")
    val matrizOrdenada: Array<IntArray> = ordenarBurbuja(elemento, matrizAleatoria, tamaño)

}
fun ordenarBurbuja(elemento: Int, matriz: Array<IntArray>, tamaño: Int): Array<IntArray>{
    val array: IntArray = IntArray(tamaño*tamaño)
    val matriz2: Array<IntArray> = Array(tamaño){IntArray(tamaño)}
    var cont = 0
    var valor = 0
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            array[cont] = matriz[i][j]
            cont++
        }
    }
    for(a in 0 until array.size){
        for(b in 0 until array.size - a){
            if(b >= 1) {
                if (array[b] < array[b - 1]) {
                    valor = array[b]
                    array[b] = array[b - 1]
                    array[b - 1] = valor
                }
            }
        }
    }
    var izq = 0
    var der = (tamaño*tamaño) - 1
    println(busquedaBinaria(izq, der, array, elemento))
    var mensaje = ""
    var cont2 = 0
    for(e in matriz2.indices){
        mensaje = ""
        for(c in matriz2[e].indices){
            matriz2[e][c] = array[cont2]
            cont2++
            mensaje = "$mensaje ${matriz2[e][c]}"
        }
        println(mensaje)
    }
    return matriz2
}

/**
 * falta por meter la busqueda binaria
 */
fun busquedaBinaria(izq: Int, der: Int, array: IntArray,elemento: Int): String{
    if(izq > der){
        return "cagamos"
    }
    var medio = (izq + der)/2
    return when{
        array[medio] == elemento -> "si esta dentro de la matriz"
        array[medio] > elemento -> busquedaBinaria(izq, medio - 1, array, elemento)
        else -> busquedaBinaria(medio + 1, der, array, elemento)
    }
}
fun busquedaSecuencial(elemento: Int, matriz: Array<IntArray>): String{
    var condicion = false
    var mensaje = ""
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(matriz[i][j] == elemento){
                condicion = true
            }
        }
    }
    if(condicion == true){
        mensaje = "se encuentra dentro de la matriz."
    }else{
        mensaje = "no se encuentra dentro de la matriz."
    }
    return mensaje
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
            matriz[i][j] = (0 .. 10).random()
            mensaje = "$mensaje ${matriz[i][j]}"
        }
        println(mensaje)
    }
    return matriz
}

/**
 * funciona
 */
fun encontrarMaximo(matriz: Array<IntArray>):  Int{
    var valor1 = 0
    var valor2 = 0
    var maximo = matriz[valor1][valor2]
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(maximo < matriz[i][j]){
                maximo = matriz[i][j]
            }
        }
    }
    return maximo
}
fun encontrarMinimo(matriz: Array<IntArray>): Int{
    var valor1 = 0
    var valor2 = 0
    var minimo = matriz[valor1][valor2]
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(minimo > matriz[i][j]){
                minimo = matriz[i][j]
            }
        }
    }
    return minimo
}
fun generarMedia(matriz: Array<IntArray>): Double{
    var cont = 0.0
    var media = 0.0
    var suma = 0.0
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            cont++
            suma += matriz[i][j]
        }
    }
    media = suma / cont
    return media
}