package exemples

import java.io.RandomAccessFile
import java.util.Scanner

fun main(args: Array<String>) {
    val f = RandomAccessFile("Empleats3.dat", "rw")
    val sc = Scanner(System.`in`)
    println("Quin registre? (-1 per a eixir): ")
    var num = sc.nextInt()
    while (num != -1) {
        f.seek(40 * (num - 1).toLong())
        println("Núm.: " + f.readInt())
        var nom = ""
        for (i in 1..10)
            nom += f.readChar()
        println("Nom: " + nom)
        println("Depart: " + f.readInt())
        println("Edat: " + f.readInt())
        println("Sou: " + f.readDouble())
        println()
        println("Quin registre? (-1 per a eixir): ")
        num = sc.nextInt()
    }
    f.close()
}

