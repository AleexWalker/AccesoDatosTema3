package exemples

import java.io.ObjectOutputStream
import java.io.FileOutputStream

fun main(args: Array<String>) {
    val f = ObjectOutputStream(FileOutputStream("Empleats.obj"))

    val noms = arrayOf("Andreu", "Bernat", "Clàudia", "Damià")
    val departaments = arrayOf(10, 20, 10, 10)
    val edats = arrayOf(32, 28, 26, 40)
    val sous = arrayOf(1000.0, 1200.0, 1100.0, 1500.0)

    for (i in 0..3){
        val e = Empleat (i + 1, noms[i], departaments[i], edats[i], sous[i])
        f.writeObject(e)
    }

    f.close();
}

