package exemples

import org.json.JSONTokener
import org.json.JSONObject

fun main(args: Array<String>) {

    val cadena = "{ \"p1\" : 2 , \"p2\" : 4 , \"p3\" : 6 , \"p4\" : 8 , \"p5\" : 10 }"

    val arrel = JSONTokener(cadena).nextValue() as JSONObject

    println(arrel.get("p1"))
}