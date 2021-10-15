package exercicis

import com.squareup.moshi.JsonAdapter
import javax.swing.*
import java.awt.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.io.File

class FinestraJSON : JFrame() {

    init {
        val fichero = File("Rutas.json").readText()
        val moshi = Moshi.Builder().build()
        val listaTipos = Types.newParameterizedType(List::class.java, Rutes::class.java)
        val adapter : JsonAdapter<List<Rutes>> = moshi.adapter(listaTipos)
        val rutas = adapter.fromJson(fichero)

        var llistaRutes : ArrayList<List<Rutes>> = arrayListOf(rutas)
        llistaRutes.get(0).get(0).rutes.get(0).llistaDePunts

        // sentències per a omplir llistaRutes


        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("JSON: Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        var nomsLlistaRutes = arrayListOf<String>()
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        for (i in 0 until llistaRutes.get(0).get(0).rutes.size){
            nomsLlistaRutes.add(llistaRutes.get(0).get(0).rutes.get(i).nom)
        }

        val combo = JComboBox(nomsLlistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener {
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            val seleccion = llistaRutes.get(0).get(0).rutes.get(combo.selectedIndex)
            area.text = ""

            for (i in 0 until seleccion.llistaDePunts.size){
                area.text += seleccion.llistaDePunts.get(i).nom + ": ("
                area.text += seleccion.llistaDePunts.get(i).coord.latitud.toString() + ") ("
                area.text += seleccion.llistaDePunts.get(i).coord.longitud.toString() + ")\n"
            }
        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        FinestraJSON().isVisible = true
    }
}


