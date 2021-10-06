package exercicis

import exemples.Empleat
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import java.io.Serializable

class Ruta (var nom: String, var desnivell: Int, var desnivellAcumulat: Int, var llistaDePunts: MutableList<PuntGeo>): Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }

    fun addPunt(p: PuntGeo){
        llistaDePunts.add(p)
    }

    fun getPunt(i: Int): PuntGeo{
        return llistaDePunts.get(i)
    }

    fun getPuntNom(i: Int): String {
        return llistaDePunts.get(i).nom
    }

    fun getPuntLatitud(i: Int): Double {
        return llistaDePunts.get(i).coord.latitud
    }

    fun getPuntLongitud(i: Int): Double {
        return llistaDePunts.get(i).coord.longitud
    }

    fun size(): Int {
        return llistaDePunts.size
    }

    fun mostrarRuta() {
        val fichero = ObjectInputStream(FileInputStream("Rutes.obj"))

        try {
            while (true) {
                val lectorCoordenades = fichero.readObject() as Coordenades
                val lectorGeo = fichero.readObject() as PuntGeo
                var contador = 1

                println("Ruta: $nom")
                println("Desnivell: $desnivell")
                println("Desnivell Acumulat: $desnivellAcumulat")

                val numeroPuntos = llistaDePunts.size
                println("Tiene $numeroPuntos puntos")
                while (true) {
                    println("Punt $contador: " + lectorGeo.nom + " (" + lectorCoordenades.latitud + lectorCoordenades.longitud + ")")
                    contador++
                }
            }
        } catch (eof: EOFException) {
            fichero.close()
        }
    // Aquest és el mètode que heu d'implementar vosaltres
    }
}