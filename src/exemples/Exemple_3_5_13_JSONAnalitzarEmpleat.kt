package exemples

import org.json.JSONTokener
import org.json.JSONObject
import java.io.FileReader

fun main(args: Array<String>) {

    val r_json = FileReader("Empleat.json")

    val arrel = JSONTokener(r_json).nextValue() as JSONObject

    val empleat = arrel.getJSONObject("empleat")

    println("" + empleat.get("nom") + " (" + empleat.get("sou") + ")")
}