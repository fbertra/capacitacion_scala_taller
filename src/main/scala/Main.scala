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

  for (file <- files) {
    println (s"procesando $file")
  }

  println ("fin procesao")
}