package exercicis

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream

fun main(args: Array<String>) {
    val ficheroEscrituraObjeto = ObjectOutputStream(FileOutputStream("Rutes.obj"))
    val ficheroLectura = DataInputStream(FileInputStream("Rutes.dat"))

    while (ficheroLectura.available() > 0){
        val nombreRuta = ficheroLectura.readUTF()
        val desnivell = ficheroLectura.readInt()
        val desnivellAcumulat = ficheroLectura.readInt()

        val numeroPuntos = ficheroLectura.readInt()
        for (i in 1..numeroPuntos){
            val nombre = ficheroLectura.readUTF()
            val latitud = ficheroLectura.readDouble()
            val longitud = ficheroLectura.readDouble()
        }
        ficheroEscrituraObjeto.writeObject(nombreRuta, desnivell, desnivellAcumulat, )
    }
}