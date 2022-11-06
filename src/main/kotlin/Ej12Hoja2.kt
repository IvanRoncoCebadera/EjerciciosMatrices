import Utils.escribirMatriz

fun main(){
    var tamaño = 5
    var posicionMosca = intArrayOf((0..tamaño - 1).random(), (0..tamaño - 1).random())
    var matrizMosca: Array<IntArray> = colocarMosca(tamaño, posicionMosca)
    do {
        println(escribirMatriz(matrizMosca))
        var resultadoGolpe = comprobarGolpeJugador(matrizMosca, tamaño, posicionMosca)
        if(resultadoGolpe == 2){
            println("No estuviste ni cerca de golpear a la mosca, prueba de nuevo:")
        }else{
            if(resultadoGolpe == 3) {
                posicionMosca = intArrayOf((0..tamaño - 1).random(), (0..tamaño - 1).random())
                matrizMosca = colocarMosca(tamaño, posicionMosca)
            }
        }
    }while(resultadoGolpe != 1)
    println("felicidades has ganado, la mosca estaba en la posición: ${escribirVector(posicionMosca)}")
}
/**
 * funcion que sirve para representar el contenido de vectores
 * @param vector es el vector ha representar
 * @return el contenido representado como texto
 */
fun escribirVector(vector: IntArray): String{
    var mensaje = StringBuilder()
    for(i in vector.indices){
        if(i == 0) {
            mensaje.append("[${vector[i]}, ")
        }else{
            if(i == vector.size- 1){
                mensaje.append("${vector[i]}]")
            }else{
                mensaje.append("${vector[i]}, ")
            }
        }
    }
    return mensaje.toString()
}

/**
 * funcion que sirve para colocar la mosca en una posicion aleatoria
 * @param tamaño el tamaño de filas y columnas de la matriz
 * @param posicionMosca el vector con la posicion de la mosca
 * @return la matriz donde se coloco la mosca
 */
fun colocarMosca(tamaño: Int, posicionMosca: IntArray): Array<IntArray>{
    val matriz = Array(tamaño){IntArray(tamaño)}
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            matriz[i][j] = 0
        }
    }
    matriz[posicionMosca[0]][posicionMosca[1]] = 1
    return matriz
}

/**
 * funcion que genera distintos casos según el resultado conseguido tras tratar de golpear a la mosca
 * @param matriz la amtriz sobre la que comprobaremos el golpe
 * @param tamaño el tamaño de filas y columnas de la matriz
 * @param posicionMosca el vector con la posicion de la mosca
 * @return el caso optenido
 */
fun comprobarGolpeJugador(matriz: Array<IntArray>, tamaño: Int, posicionMosca: IntArray): Int{
    var caso = 0
    var filaGolpeada = escribirPosicionGolpear(tamaño, "Ahora escriba la posición de la fila que quieres golpear, tiene que estar entre 1 y $tamaño:")
    var columnaGolpeada = escribirPosicionGolpear(tamaño, "Ahora escriba la posición de la columna que quieres golpear, tiene que estar entre 1 y $tamaño:")
    if(matriz[filaGolpeada][columnaGolpeada] == 1){
        caso = 1
    }else{
        for(i in -1 .. 1){
            for(j in -1..1){
                if(filaGolpeada + i >= 0 && filaGolpeada + i < matriz.size && columnaGolpeada + j >= 0 && columnaGolpeada + j < matriz.size){
                    if(matriz[filaGolpeada + i][columnaGolpeada + j] != 1){
                        caso = 2
                    }else{
                        caso = 3
                        return caso
                    }
                }
            }
        }
    }
    return caso
}

/**
 * funcion para escribir la fila/columna a golpear
 * @param tamaño el tamaño de filas y columnas de la matriz
 * @param mensaje un texto informativo del proceso ha realizar
 * @return el valor numerico de fila/columna introducido
 */
fun escribirPosicionGolpear(tamaño: Int, mensaje: String): Int{
    println(mensaje)
    var numero = 0
    do{
        numero = readln().toInt() - 1
        if(numero < 0 || numero > tamaño - 1){
            println("El valor introducido no es valido, prueba de nuevo:")
        }
    }while(numero < 0 || numero > tamaño - 1)
    return numero
}