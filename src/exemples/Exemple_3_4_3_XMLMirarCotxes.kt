package exemples

import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.Element

fun main(args: Array<String>) {

    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("cotxes.xml")
    val arrel = doc.getDocumentElement()  // apuntarà a l'element arrel
    val llista = arrel.getElementsByTagName("vehiculo")

    for (i in 0 until llista.getLength()) {
        val el = llista.item(i) as Element
        println(el.getNodeName() + " " + (i + 1))
        println("Marca: " + el.getElementsByTagName("marca").item(0).getChildNodes().item(0).getNodeValue())
        println("Matrícula: " + el.getElementsByTagName("matricula").item(0).getFirstChild().getNodeValue())
        println("Motor: " + el.getElementsByTagName("motor").item(0).getTextContent())
        println("Combustible: " + el.getElementsByTagName("motor").item(0).getAttributes().item(0).getNodeValue())
        val m = el . getElementsByTagName ("motor").item(0) as Element
        println("Combustible: " + m.getAttribute("combustible"))
        println()
    }
    println(arrel.getTextContent())
}