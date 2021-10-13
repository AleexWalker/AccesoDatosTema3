package exemples

import org.json.JSONTokener
import org.json.JSONArray

fun main(args: Array<String>) {

    val cadena = "[ 5 , 7 , 8 , 7 ]"

    val arrel = JSONTokener(cadena).nextValue() as JSONArray

    for (i in arrel)
        println(i)
}