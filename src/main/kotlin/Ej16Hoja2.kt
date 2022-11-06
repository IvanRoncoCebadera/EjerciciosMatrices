import Utils.escribirMatriz

fun main(){
    val tamañoF = 5
    val tamañoC = 5
    var contadorJ = 0
    var contadorO = 0
    val panelOrdenador = crearPanelOrdenador(tamañoF, tamañoC)
    println(escribirMatriz(panelOrdenador))
    val panelJugador = crearPanelJugador(tamañoF, tamañoC)
    println(escribirMatriz(panelJugador))
    presentarResultados(tamañoF, tamañoC, panelOrdenador, panelJugador, contadorJ, contadorO)
}

/**
 * funcion para juagr a los barcos
 * @param tamañoF el tamaño de las filas
 * @param tamañoC el tamaño de las columnas
 * @param panelOrdenador el panel de los barcos del ordenador
 * @param panelJugador el panel de los barcos del ordenador
 * @param contadorJ el contador de barcos dados por el jugador
 * @param contadorO el contador de barcos dados por el ordenador
 */
private fun presentarResultados(
    tamañoF: Int,
    tamañoC: Int,
    panelOrdenador: Array<IntArray>,
    panelJugador: Array<IntArray>,
    contadorJ: Int,
    contadorO: Int
) {
    var contadorJ1 = contadorJ
    var contadorO1 = contadorO
    do {
        var turno = "humano"
        if (turno == "humano") {
            var posJF = escribirFila(
                tamañoF,
                "Por favor, introduzca un valor de fila para tratar de golpear un barco, como mín 1 y como máx $tamañoF:"
            )
            var posJC = escribirColumna(
                tamañoC,
                "Ahora, introduzca un valor de columna para tratar de golpear un barco, como mín 1 y como máx $tamañoC:"
            )
            if (comprobarTiro(posJF, posJC, panelOrdenador) == true) {
                contadorJ1++
                println("Has acertado el tiro, al ordenador le quedan ${4 - contadorJ1} barcos.")
            } else {
                println("Fallaste el tiro, al ordenador le quedan ${4 - contadorJ1} barcos.")
            }
            turno = "ordenador"
        }
        if (turno == "ordenador") {
            var posOF = (0 until tamañoC).random()
            var posOC = (0 until tamañoC).random()
            if (comprobarTiro(posOF, posOC, panelJugador) == true) {
                contadorO1++
            } else {
            }
            turno = "humano"
        }
    } while (contadorJ1 < 4 && contadorO1 < 4)
}

/**
 * funcion para comprobar si se acerto el tiro
 * @param posF es la posicion de las filas
 * @param posC es la posicion de las columnas
 * @param panel es la matriz sobre la que comprobaremos el tiro
 * @return un valor booleano de si se a acertado o no
 */
fun comprobarTiro(posF: Int, posC: Int, panel: Array<IntArray>): Boolean{
    return if(panel[posF][posC] == 1){
        true
    }else{
        false
    }
}

/**
 * funcion para poner los barcos del ordenador
 * @param filas tamaño de filas
 * @param columnas tamaño columnas
 * @return el panel con los barcos
 */
fun crearPanelOrdenador(filas: Int, columnas: Int): Array<IntArray>{
    var panel = Array(filas){IntArray(columnas)}
    var contador = 1
    var posF = 0
    var posC = 0
    do {
        do {
            var condicion = false
            posF = (0 until filas).random()
            posC = (0 until columnas).random()
            for (i in -1..1) {
                for (j in -1..1) {
                    if (posF + i >= 0 && posF + i < panel.size && posC + j >= 0 && posC + j < panel.size) {
                        if (panel[posF + i][posC + j] == 1) {
                            condicion = true
                        }
                    }
                }
            }
        }while(condicion == true)
        panel[posF][posC] = 1
        contador++
    }while(contador <= 4)
    return panel
}
/**
 * funcion para poner los barcos del jugador
 * @param filas tamaño de filas
 * @param columnas tamaño columnas
 * @return el panel con los barcos
 */
fun crearPanelJugador(filas: Int, columnas: Int): Array<IntArray>{
    var panel = Array(filas){IntArray(columnas)}
    var contador = 1
    var posF = 0
    var posC = 0
    do {
        do {
            var condicion = false
            posF = escribirFila(filas, "Por favor, introduzca un valor de fila para colocar el barco, como mín 1 y como máx $filas:")
            posC = escribirColumna(columnas, "Ahora, introduzca un valor de columna para colocar el barco, como mín 1 y como máx $columnas:")
            for (i in -1..1) {
                for (j in -1..1) {
                    if (posF + i >= 0 && posF + i < panel.size && posC + j >= 0 && posC + j < panel.size) {
                        if (panel[posF + i][posC + j] == 1) {
                            condicion = true
                        }
                    }
                }
            }
            if(condicion == true){
                println("No puedes meter un barco en esa posicion, ya que estaría al lado de otro, trata de repartirlos más.")
            }
        }while(condicion == true)
        panel[posF][posC] = 1
        contador++
    }while(contador <= 4)
    return panel
}

/**
 * funcion que sirve para escribir la posicion de la fila
 * @param filas el tamaño de la fila
 * @param mensaje un texto informativo del proceso a realizar
 */
fun escribirFila(filas: Int, mensaje: String): Int{
    println(mensaje)
    var valor = 0
    do{
        valor = readln().toInt() - 1
        if(valor < 0 || valor > filas - 1){
            println("Ese valor no sirve, introduzca otro:")
        }
    }while(valor < 0 || valor > filas - 1)
    return valor
}
/**
 * funcion que sirve para escribir la posicion de la columna
 * @param columnas el tamaño de la columna
 * @param mensaje un texto informativo del proceso a realizar
 */
fun escribirColumna(columnas: Int, mensaje: String): Int{
    println(mensaje)
    var valor = 0
    do{
        valor = readln().toInt() - 1
        if(valor < 0 || valor > columnas - 1){
            println("Ese valor no sirve, introduzca otro:")
        }
    }while(valor < 0 || valor > columnas - 1)
    return valor
}