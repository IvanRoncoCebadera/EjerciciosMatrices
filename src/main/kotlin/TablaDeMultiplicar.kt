fun main(){
    val tablaMultiplicar = Array(10) {IntArray(10)}
    var tabla = escribirTablaMultiplicar(tablaMultiplicar)
}
fun escribirTablaMultiplicar(tabla: Array<IntArray>){
    var mensaje = ""
    for(fila in tabla.indices){
        mensaje = ""
        for(elemento in tabla[fila].indices){
            tabla[fila][elemento] = (fila + 1)*(elemento + 1)
            mensaje = "$mensaje ${tabla[fila][elemento]}"
        }
        println(mensaje)
    }
}
