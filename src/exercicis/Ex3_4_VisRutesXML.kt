package exercicis

import javax.swing.*
import java.awt.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory

class Finestra : JFrame() {

    init {
        var doc: Document
        // sentències per a omplir doc

        val documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutas.xml")
        val raiz = documento.documentElement

        val ruta = raiz.getElementsByTagName("Ruta")
        val puntos = raiz.getElementsByTagName("Puntos")
        val punto = raiz.getElementsByTagName("Punto")

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1,BorderLayout.NORTH)
        add(panell2,BorderLayout.CENTER)

        val llistaRutes = arrayListOf<String>()
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        for (i in 0 until ruta.length){
            val elemento = ruta.item(i) as Element
            llistaRutes.add(elemento.getElementsByTagName("Nombre").item(0).textContent)
        }

        val combo = JComboBox(llistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"),BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener{
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            area.text = " "
            val puntos = ruta.item(combo.selectedIndex) as Element
            val listaPuntos = puntos.getElementsByTagName("Punto")

            for (i in 0 until listaPuntos.length) {

                val punto = listaPuntos.item(i) as Element
                area.text += punto.getElementsByTagName("nombre").item(0).textContent + ": ("
                area.text += punto.getElementsByTagName("Latitud").item(0).textContent + ") ("
                area.text += punto.getElementsByTagName("Longitud").item(0).textContent + ")\n"
            }
        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        Finestra().isVisible = true
    }
}
