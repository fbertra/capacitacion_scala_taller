import cl.fbd.capacitacion_scala.taller.FileOps
object Main extends App {
  if (args.length == 0) {
    println("Uso... <directorio con archivos>")
    System.exit(1)
  }

  val dir = new java.io.File(args(0))

  println(s"Procesando contenido de ${dir}")

  if (!dir.isDirectory()) {
    println(s"$dir no es un directorio")
    System.exit(2)
  }

  try {
    val files = dir.listFiles

    val mapa = FileOps.addFiles(files)

    for ((fecha, files) <- mapa) {
      // println (s"$fecha -> ${files.mkString ("; ")}")
      FileOps.writeFile(fecha, files)
    }
  }
  catch {
    case th: Throwable => {
      th.printStackTrace () 
      System.exit (3)
    }
  }

  println("fin procesao")
}
