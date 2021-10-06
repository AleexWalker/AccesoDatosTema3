package exercicis

import java.io.DataInputStream
import java.io.FileInputStream


fun main(args: Array<String>) {
    val f = DataInputStream(FileInputStream("Rutes.dat"))
    var contador = 0

    while (f.available() > 0){
        println("Nom de la Ruta: " + f.readUTF())
        println("Desnivell: " + f.readInt())
        println("Desnivell Acumulat: " + f.readInt())

        val numeroPuntos = f.readInt()
        println("Numero de Punts:  $numeroPuntos")
        for (i in 1..numeroPuntos) {
            println("\tPunt $contador: " + f.readUTF() + " (" + f.readDouble() + ") ("+ f.readDouble() + ")")
            contador++
        }
        contador = 0
    }
}

