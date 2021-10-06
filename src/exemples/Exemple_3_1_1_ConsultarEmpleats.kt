package exemples

import java.io.FileInputStream
import java.io.DataInputStream

fun main(args: Array<String>) {
    val f = DataInputStream(FileInputStream("Empleats.dat"))

    while (f.available() > 0) {
        System.out.println("Número: " + f.readInt())
        System.out.println("Nom: " + f.readUTF())
        System.out.println("Depart: " + f.readInt())
        System.out.println("Edat: " + f.readInt())
        System.out.println("Sou: " + f.readDouble())
        System.out.println()
    }
    f.close()
}

