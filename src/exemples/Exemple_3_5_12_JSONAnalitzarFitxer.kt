package exemples

import org.json.JSONTokener
import org.json.JSONObject
import java.io.FileReader

fun main(args: Array<String>) {

    val r_json = FileReader("parelles.json")

    val arrel = JSONTokener(r_json).nextValue() as JSONObject

    println(arrel.get("p3"));
}