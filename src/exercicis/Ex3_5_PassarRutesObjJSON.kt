package exercicis

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import exemples.Estacions
import java.io.EOFException
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

fun main (args : Array<String>){
    val fichero = ObjectInputStream(FileInputStream("Rutes.obj"))
    val listaRutas : MutableList<Ruta> = arrayListOf()


    try {
        while (true) {
            val ruta = fichero.readObject() as Ruta
            listaRutas.add(ruta)
        }
    } catch (eof : EOFException){
        fichero.close()
    }

    val moshi = Moshi.Builder().build()
    val llistaRutes = Types.newParameterizedType(List::class.java, Rutes::class.java)
    val adapter: JsonAdapter<List<Rutes>> = moshi.adapter(llistaRutes)
    val rutes = adapter.toJson(listOf(Rutes(listaRutas)))

    File("Rutas.json").writeText(rutes)
}