import Utils.generarMatrizAleatoria

fun main(){
    var tamaño = 3
    println("La matriz es:")
    val matriz: Array<IntArray> = generarMatrizAleatoria(tamaño)
    if(comprobarSimetriaMatriz(matriz)){
        println("La matriz es simétrica.")
    }else{
        println("La matriz no es simétrica.")
    }
}

/**
 * funcion para comprobar si una matriz es o no simétrica
 * @param matriz es la matriz de la que queremos comprbar su simetría
 * @retrun nos devuelva de condicion de si es o no simétrica
 */
fun comprobarSimetriaMatriz(matriz: Array<IntArray>): Boolean{
    var contador = 1
    var conclusion = true
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            if(j >= 0 + contador) {
                if (matriz[i][j] != matriz[j][i]) {
                    conclusion = false
                }
            }
        }
        contador++
    }
    return conclusion
}