package exercicis

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import javax.xml.transform.stream.StreamSource

fun main(args: Array<String>) {
    val fichero = ObjectInputStream(FileInputStream("Rutes.obj"))
    val documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    val raizPrincipal = documento.createElement("Rutas")

    documento.appendChild(raizPrincipal)

    try {
        while (true){
            val lectura = fichero.readObject() as Ruta
            val ruta = documento.createElement("Ruta")

            val nombre = documento.createElement("Nombre")
            nombre.textContent = lectura.nom
            ruta.appendChild(nombre)

            val desnivel = documento.createElement("Desnivel")
            desnivel.textContent = lectura.desnivell.toString()
            ruta.appendChild(desnivel)

            val desnivelAcumulado = documento.createElement("DesnivelAcumulado")
            desnivelAcumulado.textContent = lectura.desnivellAcumulat.toString()
            ruta.appendChild(desnivelAcumulado)

            val punt = documento.createElement("Puntos")

            for (i in lectura.llistaDePunts) {
                val puntos = documento.createElement("Punto")

                val nombrePunto = documento.createElement("NombrePunto")
                nombrePunto.appendChild(documento.createTextNode(lectura.getPuntNom(lectura.llistaDePunts.indexOf(i))))
                puntos.appendChild(nombrePunto)

                val latitud = documento.createElement("Latitud")
                latitud.textContent = lectura.getPuntLatitud(lectura.llistaDePunts.indexOf(i)).toString()
                puntos.appendChild(latitud)

                val longitud = documento.createElement("Longitud")
                longitud.textContent = lectura.getPuntLongitud(lectura.llistaDePunts.indexOf(i)).toString()
                puntos.appendChild(longitud)

                punt.appendChild(puntos)
            }

            ruta.appendChild(punt)

            raizPrincipal.appendChild(ruta)
        }
    } catch (eof : EOFException){
        fichero.close()
    }

    val transformar = TransformerFactory.newInstance().newTransformer()
    transformar.setOutputProperty(OutputKeys.INDENT, "yes")
    transformar.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
    transformar.transform(DOMSource(documento), StreamResult("Rutas.xml"))
}
