package exercicis

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import exemples.Estacions
import java.io.File

fun main (args : Array<String>){
    val fichero = File("Rutes.obj").readText()

    val moshi = Moshi.Builder().build()
    val llistaRutes = Types.newParameterizedType(List::class.java, Rutes::class.java)
    val adapter: JsonAdapter<List<Rutes>> = moshi.adapter(llistaRutes)
    val rutes = adapter.fromJson(fichero)

    val rutesTotes = rutes[0].rutes
    for (e in rutesTotes){
        println("Nombre: " + e.nom + "Desnivel: " + e.desnivell)
    }
}