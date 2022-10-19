package it.rocchini;

import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int portaServer = 3000;
   
        ServerSocket ss = new ServerSocket(portaServer);
        System.out.println("Server in ascolto sulla porta " + portaServer);
        Socket s = ss.accept();
        System.out.println("Client Connesso");

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("Inserisci l'altezza (M): ");
        pr.flush();

        InputStreamReader altezza = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(altezza);
        String HG = br.readLine();

        PrintWriter pr1 = new PrintWriter(s.getOutputStream());
        pr1.println("Inserisci il peso (KG): ");
        pr1.flush();

        InputStreamReader peso = new InputStreamReader(s.getInputStream());
        BufferedReader br1 = new BufferedReader(peso);
        String WG = br1.readLine();

        float H = Float.parseFloat(HG);
        float W = Float.parseFloat(WG);
        float mol = H*H;
        float BMI = W / mol;

        PrintWriter pr2 = new PrintWriter(s.getOutputStream());
        pr2.println("L'indice metabolico-salutistico e': " + BMI);
        pr2.flush();
       
        s.close();
        ss.close();
    }
}
