fun main(){
    var tamaño = 3
    println("Primera matriz:")
    val matriz1: Array<IntArray> = geneararMatrizAleatoria(tamaño)
    println()
    println("Segunda matriz:")
    val matriz2: Array<IntArray> = geneararMatrizAleatoria(tamaño)
    var caso = generarCaso("""Por favor, introduzca si quiere "sumar", "restar, "dividir" o si quiere hayar el "determinante" de la primera matriz.""")
    println("El resultado de la operacion pedida es: ${generarResultados(caso,tamaño, matriz1, matriz2)}.")
}
fun generarResultados(caso: Int, tamaño: Int, matriz1: Array<IntArray>, matriz2: Array<IntArray>): Int{
    var res = 0
    if(caso == 4){
        res = generarDeterminante(matriz1)
    }else {
        println("Ahora debes elegir las coordenadas del valor de la matriz 1 que operaras con el valor de la matriz 2 en ese orden.")
        println("Para las coordenadas de la primera matriz:")
        var posicionI1 = generarCoordenadaI(matriz1, tamaño)
        var posicionJ1 = generarCoordenadaJ(matriz1, tamaño)
        println("Para las coordenadas de la segunda matriz:")
        var posicionI2 = generarCoordenadaI(matriz2, tamaño)
        var posicionJ2 = generarCoordenadaJ(matriz2, tamaño)
        if(caso == 1){
            res = matriz1[posicionI1][posicionJ1] + matriz2[posicionI2][posicionJ2]
        }else{
            if(caso == 2){
                res = matriz1[posicionI1][posicionJ1] - matriz2[posicionI2][posicionJ2]
            }else{
                res = matriz1[posicionI1][posicionJ1] / matriz2[posicionI2][posicionJ2]
            }
        }
    }
    return res
}
fun generarDeterminante(matriz: Array<IntArray>): Int{
    var res = (matriz[0][0] * matriz[1][1] * matriz[2][2]) - (matriz[0][2] * matriz[1][1] * matriz[2][0])
    return res
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
fun generarCoordenadaI(matriz: Array<IntArray>, tamaño: Int): Int{
    var coordenada = 0
    do {
        println("Por favor, introduzca un valor de coordenada i, que sea positivo y menor o igual que ${tamaño - 1}.")
        coordenada = readln().toInt()
        if(coordenada !in (0 .. tamaño - 1)){
            println("Ese valor no nos vale.")
        }
    }while(coordenada !in (0 .. tamaño - 1))
    return coordenada
}
fun generarCoordenadaJ(matriz: Array<IntArray>, tamaño: Int): Int{
    var coordenada = 0
    do {
        println("Por favor, introduzca un valor de coordenada j positivo y menor o igual que ${tamaño - 1}.")
        coordenada = readln().toInt()
        if(coordenada !in (0 .. tamaño - 1)){
            println("Ese valor no nos vale.")
        }
    }while(coordenada !in (0 .. tamaño - 1))
    return coordenada
}
fun generarCaso(mensaje: String): Int {
    println(mensaje)
    var caso = 0
    var condicion = true
    do {
        condicion = true
        var texto = readln().lowercase()
        if (texto == "sumar") {
            caso = 1
        } else {
            if (texto == "restar") {
                caso = 2
            } else {
                if (texto == "dividir") {
                    caso = 3
                } else {
                    if (texto == "determinante") {
                        caso = 4
                    } else {
                        condicion = false
                    }
                }
            }
        }
        if (condicion == false) {
            println("No has escrito uno de los posibles casos, prueba de nuevo:")
        }
    } while (condicion == false)
    return caso
}
