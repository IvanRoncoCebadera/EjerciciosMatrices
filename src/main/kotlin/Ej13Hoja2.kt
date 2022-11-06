import Utils.escribirMatriz

fun main(){
    var contador = 1
    val tamañoF = 2
    val tamañoC = 5
    val matrizParejas = generarMatrizParejas(tamañoF, tamañoC)
    println(escribirMatriz(matrizParejas))
    println("Las casillas que aun no has averiguado se presentar con el numero 0:")
    var matrizJugador = Array(tamañoF){IntArray(tamañoC)}
    println(escribirMatriz(matrizJugador))
    println(presentarResultados(tamañoF, tamañoC, matrizJugador, matrizParejas, contador))
}

/**
 * funcion para jugar al juego de las cartas
 * @param tamañoF el tamaño de las filas
 * @param tamañoC el tamaño de las columnas
 * @param matrizJugador la matriz del jugador
 * @param matrizParejas la matriz de parejas aleatoriamente colocadas
 * @param contador un contador al que se le va sumando un 1
 * @return un mensaje de felicitaciones al ganar
 */
private fun presentarResultados(
    tamañoF: Int,
    tamañoC: Int,
    matrizJugador: Array<IntArray>,
    matrizParejas: Array<IntArray>,
    contador: Int
): String {
    var matrizJugador1 = matrizJugador
    var contador1 = contador
    do {
        var posF1 = escribirPosicionParejaF(
            tamañoF,
            "Introduzca el valor de la fila que quiere comprobar, tiene que ser un número de 1 a ${tamañoF}:"
        )
        var posC1 = escribirPosicionParejaC(
            tamañoC,
            "Introduzca el valor de la columna que quiere comprobar, tiene que ser un número de 1 a ${tamañoC}:"
        )
        matrizJugador1 = primerNumeroPareja(matrizJugador1, matrizParejas, posF1, posC1)
        println(escribirMatriz(matrizJugador1))
        var posF2 = escribirPosicionParejaF(
            tamañoF,
            "Introduzca el valor de la fila que quiere comprobar, tiene que ser un número de 1 a ${tamañoF}:"
        )
        var posC2 = escribirPosicionParejaC(
            tamañoC,
            "Introduzca el valor de la columna que quiere comprobar, tiene que ser un número de 1 a ${tamañoC}:"
        )
        if (matrizParejas[posF1][posC1] == matrizParejas[posF2][posC2]) {
            println("Felicidades, encontraste la pareja:")
            matrizJugador1 = segundoNumeroPareja(matrizJugador1, matrizParejas, posF2, posC2)
            println(escribirMatriz(matrizJugador1))
        } else {
            matrizJugador1 = segundoNumeroPareja(matrizJugador1, matrizParejas, posF2, posC2)
            println(escribirMatriz(matrizJugador1))
            Thread.sleep(2000)
            println("Que pena, no encontraste la pareja, por lo que se resetearon las casillas:")
            matrizJugador1 = resetearLaPareja(matrizJugador1, posF1, posC1, posF2, posC2)
            println(escribirMatriz(matrizJugador1))
        }
        contador1++
    } while (contador1 <= 5)
    return "Felicidades, encontraste todas la parejas, has ganado."
}

/**
 * funcion que sirve para resetear las ultimas dos casillas
 * @param matrizJ la matriz del jugador
 * @param posF1 la posicion de la fila del primer digito
 * @param posC1 la poscion de la columna del primer digito
 * @param posF2 la posicion de la fila del segundo digito
 * @param posC2 la poscion de la columna del segundo digito
 * @return la matrizJ habiendo ocultado las dos ultimas posiciones
 */
fun resetearLaPareja(matrizJ: Array<IntArray>,posF1: Int, posC1: Int,posF2: Int, posC2: Int ): Array<IntArray>{
    matrizJ[posF1][posC1] = 0
    matrizJ[posF2][posC2] = 0
    return matrizJ
}
/**
 * funcion que sirve para mostrar la casilla del primer numero de la pareja
 * @param matrizJ la matriz del jugador
 * @param matrizP la matriz con todas las parejas
 * @param posF la posicion de la fila del digito
 * @param posC la poscion de la columna del digito
 * @return la matrizJ habiendo mostrado la casilla pedida
 */
fun primerNumeroPareja(matrizJ: Array<IntArray>, matrizP: Array<IntArray>,posF: Int, posC: Int): Array<IntArray>{
    var matrizJugador = matrizJ
    matrizJugador[posF][posC] = matrizP[posF][posC]
    return matrizJugador
}
/**
 * funcion que sirve para mostrar la casilla del segundo numero de la pareja
 * @param matrizJ la matriz del jugador
 * @param matrizP la matriz con todas las parejas
 * @param posF la posicion de la fila del digito
 * @param posC la poscion de la columna del digito
 * @return la matrizJ habiendo mostrado la casilla pedida
 */
fun segundoNumeroPareja(matrizJ: Array<IntArray>, matrizP: Array<IntArray>,posF: Int, posC: Int): Array<IntArray>{
    var matrizJugador = matrizJ
    matrizJugador[posF][posC] = matrizP[posF][posC]
    return matrizJugador
}

/**
 * funcion con la que escribimos las filas de la casilla
 * @param tamañoF el tamaño maximo de las filas
 * @param mensaje texto informativo del proceso a realizar
 * @return el numero de fila introducido
 */
fun escribirPosicionParejaF(tamañoF: Int, mensaje: String): Int{
    println(mensaje)
    var numero = 0
    do{
        numero = readln().toInt() - 1
        if(numero < 0 || numero > tamañoF - 1){
            println("El valor introducido no es valido, prueba de nuevo:")
        }
    }while(numero < 0 || numero > tamañoF - 1)
    return numero
}
/**
 * funcion con la que escribimos las columnas de la casilla
 * @param tamañoF el tamaño maximo de las columnas
 * @param mensaje texto informativo del proceso a realizar
 * @return el numero de columna introducido
 */
fun escribirPosicionParejaC(tamañoC: Int, mensaje: String): Int{
    println(mensaje)
    var numero = 0
    do{
        numero = readln().toInt() - 1
        if(numero < 0 || numero > tamañoC - 1){
            println("El valor introducido no es valido, prueba de nuevo:")
        }
    }while(numero < 0 || numero > tamañoC - 1)
    return numero
}

/**
 * funcion que crea una matriz de parejas de numeros colocados aleatoriamente
 * @param filas el tamaño de las filas
 * @param columnas el tamaño de las columnas
 * @return la matriz de parejas de numeros descolocados
 */
fun generarMatrizParejas(filas: Int, columnas: Int): Array<IntArray>{
    val matriz = Array(filas){IntArray(columnas)}
    var posF = 0
    var posC = 0
    var numeros = 1
    do{
        for(i in 1..2){
            do {
                posF = (0..filas - 1).random()
                posC = (0..columnas - 1).random()
            }while(matriz[posF][posC] != 0)
            matriz[posF][posC] = numeros
        }
        numeros++
    }while(numeros <= 5)
    return matriz
}