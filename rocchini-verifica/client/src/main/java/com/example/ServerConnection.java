package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerConnection implements Runnable {

    private Socket s;
    BufferedReader in;

    public ServerConnection(Socket s) throws IOException {
        this.s = s;
        this.in = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (true) {
                String serverResponse = in.readLine();
                if ( serverResponse.equals("@") ) {
                    System.out.println("chiudi");
                    s.close();
                    System.exit(0);                }
                System.out.println(serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}