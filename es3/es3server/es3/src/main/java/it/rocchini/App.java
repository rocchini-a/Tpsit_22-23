package it.rocchini;

import java.net.ServerSocket;
import java.net.Socket;

public class App {
  static int c=0;
  public static void main(String[] args) throws Exception {
    ServerSocket ss = new ServerSocket(3000);
    System.out.println("Server in ascolto sulla porta 3000");
    boolean running = true;
    while (running) {
      Socket s = ss.accept();
      c++;
      System.out.println("Client connesso");
      ClientHandler client = new ClientHandler(s, c);
      client.start();
    }
    ss.close();
  }
}
