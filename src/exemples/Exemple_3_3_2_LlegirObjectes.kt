package exemples

    import java.io.ObjectInputStream
    import java.io.FileInputStream
    import java.io.EOFException

    fun main(args: Array<String>) {
        val f = ObjectInputStream(FileInputStream("Empleats.obj"))

        try {
            while (true) {
                val e = f.readObject() as Empleat
                println("Número: " + e.num)
                println("Nom: " + e.nom)
                println("Departament: " + e.departament)
                println("Edat: " + e.edat)
                println("Sou: " + e.sou)
                println();
            }
        } catch (eof: EOFException) {
            f.close()
        }
    }