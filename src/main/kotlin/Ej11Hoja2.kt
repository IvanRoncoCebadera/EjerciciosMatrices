import Utils.escribirMatriz
fun main(){
    var tamaño = 8
    var posicion: IntArray = generarCoordenadasPieza("Tienes que ingresar las cordenadas donde quieras colocar tu pieza.", tamaño)
    val tablero: Array<IntArray> = mostrarPosiblesMovimientosPieza(tamaño, posicion, generarPiezaParaJugar("""Introduce si quieres jugar con la "torre", "alfil", "dama" o "caballo"."""))
    println("Las posibles posiciones a las que se puede mover la pieza(se representa con un '9'), son(las marcadas en '1'):")
    println(escribirMatriz(tablero))
}
fun mostrarPosiblesMovimientosPieza(tamaño: Int, posicion: IntArray, pieza: Int): Array<IntArray>{
    val tablero = Array(tamaño){IntArray(tamaño)}
    val fila = posicion[0]
    val columna = posicion[1]
    var aumentoFilas = 0
    var aumentoColumnas = 0
    if(pieza == 1){
        escribirPosiblesPosicionesTorres(columna, aumentoFilas, tablero, tamaño, fila, aumentoColumnas)
    }else{
        if(pieza == 2){
            escribirPosiblesPosicionesAlfil(fila, tamaño, columna, aumentoColumnas, aumentoFilas, tablero)
        }else{
            if(pieza == 3){
                escribirPosiblesPosicionesTorres(columna, aumentoFilas, tablero, tamaño, fila, aumentoColumnas)
                escribirPosiblesPosicionesAlfil(fila, tamaño, columna, aumentoColumnas, aumentoFilas, tablero)
            }else{
                escribirPosiblesPosicionesCaballo(fila, columna, tablero, tamaño)
            }
        }
    }
    tablero[fila][columna] = 9
    return tablero
}
private fun escribirPosiblesPosicionesCaballo(
    fila: Int,
    columna: Int,
    tablero: Array<IntArray>,
    tamaño: Int
) {
    if (fila == 0) {
        if (columna == 0) {
            tablero[fila + 2][columna + 1] = 1
            tablero[fila + 1][columna + 2] = 1
        } else {
            if (columna == tamaño - 1) {
                tablero[fila + 2][columna - 1] = 1
                tablero[fila + 1][columna - 2] = 1
            } else {
                if (columna >= 2 && columna <= tamaño - 3) {
                    tablero[fila + 1][columna - 2] = 1
                    tablero[fila + 1][columna + 2] = 1
                    tablero[fila + 2][columna - 1] = 1
                    tablero[fila + 2][columna + 1] = 1
                } else {
                    if (columna < 2) {
                        tablero[fila + 1][columna + 2] = 1
                        tablero[fila + 2][columna - 1] = 1
                        tablero[fila + 2][columna + 1] = 1
                    } else {
                        if (columna > tamaño - 3) {
                            tablero[fila + 1][columna - 2] = 1
                            tablero[fila + 2][columna - 1] = 1
                            tablero[fila + 2][columna + 1] = 1
                        }
                    }
                }
            }
        }
    } else {
        if (fila == tamaño - 1) {
            if (columna == 0) {
                tablero[fila - 2][columna + 1] = 1
                tablero[fila - 1][columna + 2] = 1
            } else {
                if (columna == tamaño - 1) {
                    tablero[fila - 2][columna - 1] = 1
                    tablero[fila - 1][columna - 2] = 1
                } else {
                    if (columna >= 2 && columna <= tamaño - 3) {
                        tablero[fila - 1][columna - 2] = 1
                        tablero[fila - 1][columna + 2] = 1
                        tablero[fila - 2][columna - 1] = 1
                        tablero[fila - 2][columna + 1] = 1
                    } else {
                        if (columna < 2) {
                            tablero[fila - 1][columna + 2] = 1
                            tablero[fila - 2][columna - 1] = 1
                            tablero[fila - 2][columna + 1] = 1
                        } else {
                            if (columna > tamaño - 3) {
                                tablero[fila - 1][columna - 2] = 1
                                tablero[fila - 2][columna - 1] = 1
                                tablero[fila - 2][columna + 1] = 1
                            }
                        }
                    }
                }
            }
        } else {
            if (fila == 1) {
                if (columna == 0) {
                    tablero[fila + 2][columna + 1] = 1
                    tablero[fila + 1][columna + 2] = 1
                    tablero[fila - 1][columna + 2] = 1
                } else {
                    if (columna == tamaño - 1) {
                        tablero[fila + 2][columna - 1] = 1
                        tablero[fila + 1][columna - 2] = 1
                        tablero[fila - 1][columna - 2] = 1
                    } else {
                        if (columna >= 2 && columna <= tamaño - 3) {
                            tablero[fila + 1][columna - 2] = 1
                            tablero[fila + 1][columna + 2] = 1
                            tablero[fila + 2][columna - 1] = 1
                            tablero[fila + 2][columna + 1] = 1
                            tablero[fila - 1][columna + 2] = 1
                            tablero[fila - 1][columna - 2] = 1
                        } else {
                            if (columna < 2) {
                                tablero[fila + 1][columna + 2] = 1
                                tablero[fila + 2][columna - 1] = 1
                                tablero[fila + 2][columna + 1] = 1
                                tablero[fila - 1][columna + 2] = 1
                            } else {
                                if (columna > tamaño - 3) {
                                    tablero[fila + 1][columna - 2] = 1
                                    tablero[fila + 2][columna - 1] = 1
                                    tablero[fila + 2][columna + 1] = 1
                                    tablero[fila - 1][columna - 2] = 1
                                }
                            }
                        }
                    }
                }
            } else {
                if (fila == tamaño - 2) {
                    if (columna == 0) {
                        tablero[fila - 2][columna + 1] = 1
                        tablero[fila - 1][columna + 2] = 1
                        tablero[fila + 1][columna + 2] = 1
                    } else {
                        if (columna == tamaño - 1) {
                            tablero[fila - 2][columna - 1] = 1
                            tablero[fila - 1][columna - 2] = 1
                            tablero[fila + 1][columna - 2] = 1
                        } else {
                            if (columna >= 2 && columna <= tamaño - 3) {
                                tablero[fila - 1][columna - 2] = 1
                                tablero[fila - 1][columna + 2] = 1
                                tablero[fila - 2][columna - 1] = 1
                                tablero[fila - 2][columna + 1] = 1
                                tablero[fila + 1][columna + 2] = 1
                                tablero[fila + 1][columna - 2] = 1
                            } else {
                                if (columna < 2) {
                                    tablero[fila - 1][columna + 2] = 1
                                    tablero[fila - 2][columna - 1] = 1
                                    tablero[fila - 2][columna + 1] = 1
                                    tablero[fila + 1][columna + 2] = 1
                                } else {
                                    if (columna > tamaño - 3) {
                                        tablero[fila - 1][columna - 2] = 1
                                        tablero[fila - 2][columna - 1] = 1
                                        tablero[fila - 2][columna + 1] = 1
                                        tablero[fila + 1][columna - 2] = 1
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if (columna == 0) {
                        tablero[fila + 1][columna + 2] = 1
                        tablero[fila + 2][columna + 1] = 1
                        tablero[fila - 1][columna + 2] = 1
                        tablero[fila - 2][columna + 1] = 1
                    } else {
                        if (columna == tamaño - 1) {
                            tablero[fila + 1][columna - 2] = 1
                            tablero[fila + 2][columna - 1] = 1
                            tablero[fila - 1][columna - 2] = 1
                            tablero[fila - 2][columna - 1] = 1
                        } else {
                            if (columna >= 2 && columna <= tamaño - 3) {
                                tablero[fila + 1][columna - 2] = 1
                                tablero[fila + 1][columna + 2] = 1
                                tablero[fila + 2][columna - 1] = 1
                                tablero[fila + 2][columna + 1] = 1
                                tablero[fila - 1][columna - 2] = 1
                                tablero[fila - 1][columna + 2] = 1
                                tablero[fila - 2][columna - 1] = 1
                                tablero[fila - 2][columna + 1] = 1
                            } else {
                                if (columna < 2) {
                                    tablero[fila + 1][columna + 2] = 1
                                    tablero[fila + 2][columna - 1] = 1
                                    tablero[fila + 2][columna + 1] = 1
                                    tablero[fila - 1][columna + 2] = 1
                                    tablero[fila - 2][columna - 1] = 1
                                    tablero[fila - 2][columna + 1] = 1
                                } else {
                                    if (columna > tamaño - 3) {
                                        tablero[fila + 1][columna - 2] = 1
                                        tablero[fila + 2][columna - 1] = 1
                                        tablero[fila + 2][columna + 1] = 1
                                        tablero[fila - 1][columna - 2] = 1
                                        tablero[fila - 2][columna - 1] = 1
                                        tablero[fila - 2][columna + 1] = 1
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
private fun escribirPosiblesPosicionesAlfil(
    fila: Int,
    tamaño: Int,
    columna: Int,
    aumentoColumnas: Int,
    aumentoFilas: Int,
    tablero: Array<IntArray>
) {
    var aumentoColumnas1 = aumentoColumnas
    var aumentoFilas1 = aumentoFilas
    if (fila != 0 && fila != tamaño - 1) {
        if (columna != tamaño - 1) {
            aumentoColumnas1 = columna + 1
            aumentoFilas1 = fila + 1
            do {
                tablero[aumentoFilas1][aumentoColumnas1] = 1
                aumentoFilas1++
                aumentoColumnas1++
            } while (aumentoFilas1 < tamaño && aumentoColumnas1 < tamaño)
            aumentoColumnas1 = columna + 1
            aumentoFilas1 = fila - 1
            do {
                tablero[aumentoFilas1][aumentoColumnas1] = 1
                aumentoFilas1--
                aumentoColumnas1++
            } while (aumentoFilas1 >= 0 && aumentoColumnas1 < tamaño)
        }
        if (columna != 0) {
            aumentoColumnas1 = columna - 1
            aumentoFilas1 = fila + 1
            do {
                tablero[aumentoFilas1][aumentoColumnas1] = 1
                aumentoFilas1++
                aumentoColumnas1--
            } while (aumentoFilas1 < tamaño && aumentoColumnas1 >= 0)
            aumentoColumnas1 = columna - 1
            aumentoFilas1 = fila - 1
            do {
                tablero[aumentoFilas1][aumentoColumnas1] = 1
                aumentoFilas1--
                aumentoColumnas1--
            } while (aumentoFilas1 >= 0 && aumentoColumnas1 >= 0)
        }
    } else {
        if (fila == 0) {
            if (columna == 0) {
                aumentoColumnas1 = columna + 1
                aumentoFilas1 = fila + 1
                do {
                    tablero[aumentoFilas1][aumentoColumnas1] = 1
                    aumentoFilas1++
                    aumentoColumnas1++
                } while (aumentoFilas1 < tamaño && aumentoColumnas1 < tamaño)
            } else {
                if (columna == tamaño - 1) {
                    aumentoColumnas1 = columna - 1
                    aumentoFilas1 = fila + 1
                    do {
                        tablero[aumentoFilas1][aumentoColumnas1] = 1
                        aumentoFilas1++
                        aumentoColumnas1--
                    } while (aumentoFilas1 < tamaño && aumentoColumnas1 >= 0)
                } else {
                    aumentoColumnas1 = columna + 1
                    aumentoFilas1 = fila + 1
                    do {
                        tablero[aumentoFilas1][aumentoColumnas1] = 1
                        aumentoFilas1++
                        aumentoColumnas1++
                    } while (aumentoFilas1 < tamaño && aumentoColumnas1 < tamaño)
                    aumentoColumnas1 = columna - 1
                    aumentoFilas1 = fila + 1
                    do {
                        tablero[aumentoFilas1][aumentoColumnas1] = 1
                        aumentoFilas1++
                        aumentoColumnas1--
                    } while (aumentoFilas1 < tamaño && aumentoColumnas1 >= 0)
                }
            }

        }
        if (fila == tamaño - 1) {
            if (columna == 0) {
                aumentoColumnas1 = columna + 1
                aumentoFilas1 = fila - 1
                do {
                    tablero[aumentoFilas1][aumentoColumnas1] = 1
                    aumentoFilas1--
                    aumentoColumnas1++
                } while (aumentoFilas1 >= 0 && aumentoColumnas1 < tamaño)
            } else {
                if (columna == tamaño - 1) {
                    aumentoColumnas1 = columna - 1
                    aumentoFilas1 = fila - 1
                    do {
                        tablero[aumentoFilas1][aumentoColumnas1] = 1
                        aumentoFilas1--
                        aumentoColumnas1--
                    } while (aumentoFilas1 >= 0 && aumentoColumnas1 >= 0)
                } else {
                    aumentoColumnas1 = columna + 1
                    aumentoFilas1 = fila - 1
                    do {
                        tablero[aumentoFilas1][aumentoColumnas1] = 1
                        aumentoFilas1--
                        aumentoColumnas1++
                    } while (aumentoFilas1 >= 0 && aumentoColumnas1 < tamaño)
                    aumentoColumnas1 = columna - 1
                    aumentoFilas1 = fila - 1
                    do {
                        tablero[aumentoFilas1][aumentoColumnas1] = 1
                        aumentoFilas1--
                        aumentoColumnas1--
                    } while (aumentoFilas1 >= 0 && aumentoColumnas1 >= 0)
                }
            }

        }
    }
}
private fun escribirPosiblesPosicionesTorres(
    columna: Int,
    aumentoFilas: Int,
    tablero: Array<IntArray>,
    tamaño: Int,
    fila: Int,
    aumentoColumnas: Int
) {
    var aumentoFilas1 = aumentoFilas
    var aumentoColumnas1 = aumentoColumnas
    if (columna == 0) {
        aumentoFilas1 = 1
        do {
            tablero[aumentoFilas1][columna] = 1
            aumentoFilas1++
        } while (aumentoFilas1 < tamaño)
    } else {
        if (columna == tamaño - 1) {
            aumentoFilas1 = tamaño - 1
            do {

                tablero[aumentoFilas1][columna] = 1
                aumentoFilas1--
            } while (aumentoFilas1 >= 0)
        } else {
            aumentoFilas1 = 1
            do {
                tablero[aumentoFilas1][columna] = 1
                aumentoFilas1++
            } while (aumentoFilas1 < tamaño)
            aumentoFilas1 = tamaño - 1
            do {
                tablero[aumentoFilas1][columna] = 1
                aumentoFilas1--
            } while (aumentoFilas1 >= 0)
        }
    }
    if (fila == 0) {
        aumentoColumnas1 = 1
        do {
            tablero[fila][aumentoColumnas1] = 1
            aumentoColumnas1++
        } while (aumentoColumnas1 < tamaño)
    } else {
        if (fila == tamaño - 1) {
            aumentoColumnas1 = tamaño - 1
            do {

                tablero[fila][aumentoColumnas1] = 1
                aumentoColumnas1--
            } while (aumentoColumnas1 >= 0)
        } else {
            aumentoColumnas1 = 1
            do {
                tablero[fila][aumentoColumnas1] = 1
                aumentoColumnas1++
            } while (aumentoColumnas1 < tamaño)
            aumentoColumnas1 = tamaño - 1
            do {
                tablero[fila][aumentoColumnas1] = 1
                aumentoColumnas1--
            } while (aumentoColumnas1 >= 0)
        }
    }
}

fun generarCoordenadasPieza(mensaje: String, tamaño: Int): IntArray{
    println(mensaje)
    var array: IntArray = IntArray(2)
    println("Primero meta la fila sobre la que pondrá la pieza, debe ser un valor entre 1 y $tamaño:")
    do {
        array[0] = readln().toInt() - 1
        if(array[0] < 0 || array[0] > tamaño - 1){
            println("Ese valor de fila no sirve. Prueba de nuevo:")
        }
    }while(array[0] < 0 || array[0] > tamaño - 1)
    println("Ahora meta la columna sobre la que pondrá la pieza, debe ser un valor entre 1 y $tamaño:")
    do {
        array[1] = readln().toInt() - 1
        if(array[1] < 0 || array[1] > tamaño - 1){
            println("Ese valor de columna no sirve. Prueba de nuevo:")
        }
    }while(array[1] < 0 || array[1] > tamaño - 1)
    return array
}
fun generarPiezaParaJugar(mensaje: String): Int{
    println(mensaje)
    var caso = 0
    var pieza = ""
    do{
        pieza = readln()
        if(pieza == "torre"){
            caso = 1
        }else{
            if(pieza == "alfil"){
                caso = 2
            }else{
                if(pieza == "dama"){
                    caso = 3
                }else{
                    if(pieza == "caballo"){
                        caso = 4
                    }else{
                        println("La pieza introducida no existe, por favor, prueba de nuevo:")
                    }
                }
            }
        }
    }while(pieza != "torre" && pieza != "alfil" && pieza != "dama" && pieza != "caballo")
    return caso
}