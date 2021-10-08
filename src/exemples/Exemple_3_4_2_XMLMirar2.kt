package exemples

import javax.xml.parsers.DocumentBuilderFactory

fun main(args: Array<String>) {

    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("cotxes.xml")
    val arrel = doc.getDocumentElement()  // apuntarà a l'element arrel
    val fills = arrel.getChildNodes()
    println(fills.item(0).getNodeName())   // el primer fill és el retorn de carro; ens dirà que és de text
    println(fills.item(1).getNodeName())   // el segon fill sí que és vehiculo
    println(fills.item(2).getNodeName())   // el tercer fill és el retorn de carro; ens dirà que és de text
    println(fills.item(3).getNodeName())   // el quart fill sí que és vehiculo
    println(fills.item(4).getNodeName())   // el cinquè fill és el retorn de carro; ens dirà que és de text
    println(fills.item(5).getNodeName())   // no existeix el sisè fill. Donarà error
}