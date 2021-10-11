package exercicis

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main (args : Array<String>){
    val ficheroLecturaObjeto = ObjectInputStream(FileInputStream("Rutes.obj"))

    try {
        val ruta = ficheroLecturaObjeto.readObject() as Ruta
        ruta.mostrarRuta()
    } catch (eof : EOFException){
        ficheroLecturaObjeto.close()
    }
}