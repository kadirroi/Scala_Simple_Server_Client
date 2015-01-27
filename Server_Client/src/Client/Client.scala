package Client

import java.net.Socket
import java.net.ServerSocket
import scala.io._
import java.io.PrintStream
import java.net.InetAddress

object Client {
  def main(args: Array[String]): Unit = {
    val client = new Socket(InetAddress.getByName("localhost"), 12)
    val clentStart = new Client(client)
  }

}

class Client(client: Socket) {

  val in = new BufferedSource(client.getInputStream()).getLines()
  val out = new PrintStream(client.getOutputStream())
  //out.println("HÝ")
  out.println("AGE")
  
  while (in.hasNext) println("Client_Receveid:" + in.next())

  out.flush()
  client.close()

}