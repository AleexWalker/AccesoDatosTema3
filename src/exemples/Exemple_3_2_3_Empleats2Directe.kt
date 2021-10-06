package exemples

import java.io.RandomAccessFile
import java.util.Scanner

fun main(args: Array<String>) {
    val f = RandomAccessFile("Empleats2.dat", "rw")
    val sc = Scanner(System.`in`)
    println("Quin registre? (-1 per a eixir): ")
    var num = sc.nextInt ()
    while (num != -1) {
        f.seek(32 * (num - 1).toLong())
        println("Núm.: " + f.readInt())
        println("Nom: " + f.readUTF())
        println("Depart: " + f.readInt())
        println("Edat: " + f.readInt())
        println("Sou: " + f.readDouble())
        println()
        println("Quin registre? (-1 per a eixir): ")
        num = sc.nextInt()

    }
    f.close()
}