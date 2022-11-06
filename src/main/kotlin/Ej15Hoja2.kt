import Utils.escribirMatriz

fun main(){
    val tamaño = 8
    val minas = 6
    var contC = 1
    val tableroMinas: Array<IntArray> = generarTableroMinas(tamaño, minas)
    println(escribirMatriz(tableroMinas))
    var tableroJugador = Array(tamaño){IntArray(tamaño)}
    jugar(tamaño, tableroMinas, tableroJugador, contC, minas)
}

/**
 * funcion donde se juega al buscaminas
 * @param tamaño tamaño de las filas y columnas
 * @param tableroMinas el tablero donde estan las minas
 * @param tableroJugador el tablero que vera el jugador
 * @param contC contador del numero de casillas sin minas que llevamos descubiertos
 * @param minas el numero de minas que tenemos
 */
private fun jugar(
    tamaño: Int,
    tableroMinas: Array<IntArray>,
    tableroJugador: Array<IntArray>,
    contC: Int,
    minas: Int
) {
    var contC1 = contC
    do {
        var caso = generarCasoDeResultados(tamaño, tableroMinas, tableroJugador)
        if (caso == 1) {
            println("Como has encontrado una de las minas, perdiste.")
        } else {
            if (contC1 == (tamaño * tamaño - minas)) {
                println("Felicidades, has ganado el juego.")
            } else {
                println("como no era una mina, puedes seguir jugando, adelante:")
            }
            contC1++
        }
    } while (caso != 1 && contC1 < (tamaño * tamaño - minas))
}
/**
 * funcion donde se considera que estamos en el caso 1 o 2
 * @param tamaño tamaño de las filas y columnas
 * @param tableroM el tablero donde estan las minas
 * @param tableroJugador el tablero que vera el jugador
 * @return caso el numero de caso que tenemos
 */
fun generarCasoDeResultados(tamaño: Int, tableroM: Array<IntArray>, tableroJugador: Array<IntArray>): Int{
    var posF = generarCoordenadas(tamaño, "Por favor, introduzca la coordenada de la fila que quiere mirar(tiene que ser un valor entre 1 y $tamaño):")
    var posC = generarCoordenadas(tamaño, "Ahora, introduzca la coordenada de la columna que quiere mirar(tiene que ser un valor entre 1 y $tamaño):")
    var tableroJ = tableroJugador
    var caso = 0
    if(tableroM[posF][posC] == 9){
        tableroJ = escribirResultado(tableroM, posF, posC, tableroJ)
        println(escribirMatriz(tableroJ))
        println("Que mal, te encontraste con una mina.")
        caso = 1
    }else{
        tableroJ = escribirResultado(tableroM, posF, posC, tableroJ)
        println(escribirMatriz(tableroJ))
        println("Bien, no había ninguna mina en esa posición.")
        caso = 2
    }
    return caso
}
/**
 * funcion donde se implementa los numero a la matriz que ve el jugador
 * @param tamaño tamaño de las filas y columnas
 * @param tableroM el tablero donde estan las minas
 * @param tableroJ el tablero que vera el jugador
 * @param posF la coordenada de la fila
 * @param posC la coordenada de la columna
 * @return el tablero jugador modificado
 */
fun escribirResultado(tableroM: Array<IntArray>, posF: Int, posC: Int, tableroJ: Array<IntArray>): Array<IntArray>{
    var tablero = tableroJ
    tablero[posF][posC] = tableroM[posF][posC]
    return tablero
}

/**
 * funcion para introducir las coordenadas fila/columna
 * @param tamaño el tamaño de las filas y columnas
 * @param mensaje un texto informativo con el proceso ha realizar
 * @return la coordenada de la fila/columna
 */
private fun generarCoordenadas(tamaño: Int, mensaje: String): Int{
    println(mensaje)
    var coordenada = 0
    do{
        coordenada = readln().toInt() - 1
        if(coordenada < 0 || coordenada >= tamaño){
            println("Esa coordenada no es valida, prueba de nuevo:")
        }
    }while(coordenada < 0 || coordenada >= tamaño)
    return coordenada
}

/**
 * funcion que genera las minas y sus numero adyacentes de manera aleatoria (las minas)
 * @param tamaño es el tamaño de las fila y columnas
 * @param minas es el numero de minas a colocar aleatoriamente
 * @return el tablero con las minas y numeros adyacentes creados
 */
fun generarTableroMinas(tamaño: Int, minas: Int): Array<IntArray>{
    val tablero = Array(tamaño){IntArray(tamaño)}
    var posF = 0
    var posC = 0
    var contM = 1
    do{
        do {
            posF = (0..tamaño - 1).random()
            posC = (0..tamaño - 1).random()
        }while(tablero[posF][posC] == 9)
        tablero[posF][posC] = 9
        for(i in -1..1){
            for(j in -1..1){
                if(posF + i >= 0 && posF + i < tamaño && posC + j >= 0 && posC + j < tamaño){
                    if(tablero[posF + i][posC + j] != 9){
                        tablero[posF + i][posC + j] = tablero[posF + i][posC + j] + 1
                    }
                }
            }
        }
        contM++
    }while(contM <= minas)
    return tablero
}