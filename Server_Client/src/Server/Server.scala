package Server

import java.net.Socket
import java.net.ServerSocket
import scala.io._
import java.io.PrintStream

object Server {
  def main(args: Array[String]): Unit = {

    val server = new ServerSocket(17)
    val startServer = new Server(server)

  }
}

class Server(server: ServerSocket) {

  while (true) {

    val serv = server.accept()
    val in = new BufferedSource(serv.getInputStream()).getLines()
    val out = new PrintStream(serv.getOutputStream())

    var data = in.next()
    
    if (data == "HÝ") {
      out.println("Helloo")
      out.println("Whatsup")

    } else if (data == "AGE") {
      out.println("22")
      out.println("you?")

    }  else
      out.println("ERR")

    out.flush()

  }

}