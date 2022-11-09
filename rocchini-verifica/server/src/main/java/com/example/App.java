package com.example;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class App {
    static int contatore = 0;

  public static void main(String[] args) throws Exception {


    List<ClientHandler> clients = new ArrayList<>();

    ServerSocket ss = new ServerSocket(3000);
    System.out.println("Server in ascolto sulla porta 3000");
    boolean running = true;
    while (running) {
      Socket s = ss.accept();
      contatore++;
      System.out.println("Client connesso");
      ClientHandler client = new ClientHandler(s, contatore, clients);
      clients.add(client);
      client.start();
    }
    ss.close();
  }
}