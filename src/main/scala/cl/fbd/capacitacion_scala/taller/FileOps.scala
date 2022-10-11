package cl.fbd.capacitacion_scala.taller

import scala.io.Source

/**
  * 
  */
object FileOps {

  def addFiles (files: Array [java.io.File]): Map [String, List [java.io.File]] = {
    val lista = files.toList

    lista.map (file => {
        val name = file.getName ()
        (name.substring (name.length() - 4 - 12, name.length() - 4 - 4), file)
      })
      .groupBy(_._1)
      .mapValues (_.map (_._2))
      .toMap
  }

  def writeFile (fecha: String, files: List [java.io.File]) = {
    val nameOut = s"${fecha}.txt"

    println (s"Creando salida $nameOut")

    val out = new java.io.PrintWriter (new java.io.FileOutputStream (nameOut))

    for (file <- files) {
        println (s"procesando ${file.getName()}")

        val iter = Source.fromFile (file).getLines

        appendFile (out, iter)
    }

    out.close ()
  }

  def appendFile (out: java.io.PrintWriter, lines: Iterator [String]) = {
    lines.foreach (out.println(_))
  }
}
