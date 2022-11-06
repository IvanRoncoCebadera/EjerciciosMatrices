import Utils.escribirMatriz
import Utils.generarCoordenadas

fun main(){
    val tamaño = 8
    var lago: Array<IntArray> = Array(tamaño){IntArray(tamaño)}
    representarOndas(lago,tamaño)
}

fun representarOndas(matriz: Array<IntArray>, tamaño: Int){
    var lago = matriz
    var posicion = intArrayOf(generarCoordenadas(tamaño, "Por favor, introduzca la coordenada de la fila que quiere mirar(tiene que ser un valor entre 1 y $tamaño):"),
        generarCoordenadas(tamaño, "Ahora, introduzca la coordenada de la columna que quiere mirar(tiene que ser un valor entre 1 y $tamaño):"))
    var potencia = escribirPotencia(tamaño, "Ahora escriba el valor de la potencia de la piedra(puede ser de 1 a $tamaño):")
    do {
        for (i in -(tamaño - 1)..(tamaño - 1)) {
            for (j in -(tamaño - 1)..(tamaño - 1)) {
                if (posicion[0] + i >= 0 && posicion[0] + i < tamaño && posicion[1] + j >= 0 && posicion[1] + j < tamaño) {
                    representacionLineasHorizontales(j, potencia, lago, posicion)
                    representacionLineasVerticales(i, potencia, lago, posicion)
                    representacionDiagonalPrincipal(i, j, potencia, lago, posicion)
                    representacionGiagonalSecundaria(i, j, potencia, lago, posicion)
                }
            }
        }
        lago[posicion[0]][posicion[1]] = potencia
        println(escribirMatriz(lago))
        potencia--
        Thread.sleep(1000)
    }while(potencia >= 0)
}

private fun representacionGiagonalSecundaria(
    i: Int,
    j: Int,
    potencia: Int,
    lago: Array<IntArray>,
    posicion: IntArray
) {
    if (i > 0 && j < 0) {
        if (potencia + j >= 0 && -j == i) {
            lago[posicion[0] + i][posicion[1] + j] = potencia + j
        }
    } else {
        if (potencia - j >= 0 && j == -i) {
            lago[posicion[0] + i][posicion[1] + j] = potencia - j
        }
    }
}

private fun representacionDiagonalPrincipal(
    i: Int,
    j: Int,
    potencia: Int,
    lago: Array<IntArray>,
    posicion: IntArray
) {
    if (i < 0 && j < 0) {
        if (potencia + j >= 0 && j == i) {
            lago[posicion[0] + i][posicion[1] + j] = potencia + j
        }
    } else {
        if (potencia - j >= 0 && j == i) {
            lago[posicion[0] + i][posicion[1] + j] = potencia - j
        }
    }
}

private fun representacionLineasVerticales(
    i: Int,
    potencia: Int,
    lago: Array<IntArray>,
    posicion: IntArray
) {
    if (i < 0) {
        if (potencia + i >= 0) {
            lago[posicion[0] + i][posicion[1]] = potencia + i
        }
    } else {
        if (potencia - i >= 0) {
            lago[posicion[0] + i][posicion[1]] = potencia - i
        }
    }
}

private fun representacionLineasHorizontales(
    j: Int,
    potencia: Int,
    lago: Array<IntArray>,
    posicion: IntArray
) {
    if (j < 0) {
        if (potencia + j >= 0) {
            lago[posicion[0]][posicion[1] + j] = potencia + j
        }
    } else {
        if (potencia - j >= 0) {
            lago[posicion[0]][posicion[1] + j] = potencia - j
        }
    }
}


/**
 * funcion para introducir la potencia de la piedra
 * @param tamaño el tamaño de las filas y columnas
 * @param mensaje un texto informativo con el proceso ha realizar
 * @return la potencia de la piedra
 */
fun escribirPotencia(tamaño: Int, mensaje: String): Int{
    println(mensaje)
    var potencia = 0
    do{
        potencia = readln().toInt()
        if(potencia < 0 || potencia >= tamaño){
            println("Esa potencia no es valida, prueba de nuevo:")
        }
    }while(potencia < 0 || potencia >= tamaño)
    return potencia
}