package exemples

import org.json.JSONObject
import org.json.JSONArray
import java.io.FileWriter

fun main(args: Array<String>) {
    val noms = arrayOf("Andreu", "Bernat", "Clàudia", "Damià")
    val departaments = arrayOf( 10, 20, 10, 10 )
    val edats = arrayOf( 32, 28, 26, 40 )
    val sous = arrayOf( 1000.0, 1200.0, 1100.0, 1500.0)

    val arrel = JSONObject()
    val empresa = JSONObject()
    arrel.put("empresa", empresa)
    val empleats = JSONArray()
    empresa.put("empleat", empleats)

    for (i in 0..3){
        val emp = JSONObject()
        emp.put("num", i + 1)
        emp.put("nom", noms[i])
        emp.put("departament", departaments[i])
        emp.put("edat", edats[i])
        emp.put("sou", sous[i])
        empleats.put(emp)
    }

    val f = FileWriter("Empleats.json")
    f.write(arrel.toString(4))
    f.close()
}

