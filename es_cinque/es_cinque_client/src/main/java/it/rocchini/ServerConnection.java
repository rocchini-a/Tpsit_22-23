package it.rocchini;
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
        boolean running = true;

        try {
            while (running) {
                String serverResponse = in.readLine();
                if (serverResponse != null) {
                    System.out.println(serverResponse);
                   // break;
                }else{break;}
               
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
