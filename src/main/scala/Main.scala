import cl.fbd.capacitacion_scala.taller.FileOps
object Main extends App {
  if (args.length == 0) {
        println("Uso... <directorio con archivos>")
        System.exit (1)
  }

  val dir = new java.io.File (args (0))

  println (s"Procesando contenido de ${dir}")

  if (! dir.isDirectory()) {
    println (s"$dir no es un directorio")
    System.exit (2)
  }

  val files = dir.listFiles  

  val mapa = FileOps.addFiles (files)

  for ((fecha, files) <- mapa) {
    println (s"$fecha -> ${files.mkString ("; ")}")
  }

  println ("fin procesao")
}