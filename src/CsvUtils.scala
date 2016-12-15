import java.io.{IOException, File, PrintWriter}

object CsvUtils {

  val defaultFieldSeparator = ","

  def writeCSVToFile(pathName: String, sep: String = defaultFieldSeparator, header: List[String] ,csvLines: List[String]): Unit = {
    try{

      val headerString = header.mkString(sep)
      val csv = csvLines.+:(headerString)
      val file = new File(pathName)
      if (!file.exists()) {
        file.createNewFile()
        val writer = new PrintWriter(file)
        csv.foreach(writer.println)
        writer.close()
      } else {
        val writer = new PrintWriter(file)
        csv.foreach(writer.println)
        writer.close()
      }

    }
    catch{
      case e:IOException =>
        println("Exception Caught: "+e.getMessage )
    }
  }
}
