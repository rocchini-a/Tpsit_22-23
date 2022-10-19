package it.rocchini;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.channels.NonWritableChannelException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.crypto.Data;

public class ClientHandler extends Thread {
    private Socket s;
    private PrintWriter pr = null;
    private BufferedReader br = null;
    private int c;
    String comando;
    String nome = "Server a";
    public ClientHandler(Socket s, int c) {
        this.s = s;
        this.c =c;
        try {
            // per parlare
            pr = new PrintWriter(s.getOutputStream(), true);
            // per ascoltare
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
 
       
        try {
            System.out.println(br.readLine());
            pr.println("Ciao come ti chiami?"); // invio messaggio
            String nome = br.readLine().toUpperCase(); // ricevo: il nome
            System.out.println(nome);
            pr.println("Benvenuto " + nome + "sei l'utente " +c ); // invio messaggio
            
            comando = br.readLine();

            for(;;){
                if(comando.equals("data")){
                 LocalDate date = LocalDate.now();
                 pr.println(date);
                }
                if(comando.equals("ora")){
                 LocalTime ora = LocalTime.now();
                 pr.println(ora);
                }
                if(comando.equals("nome")){
                    pr.println("il nome del server è: "+nome);
                }

                if(comando.equals("id")){
                    pr.println("il contatore è " + c);
                }

                if(comando.equals("fine")){
                    pr.println("connessione chiusa con l'utente " + c);
                    s.close();
                    break;
                }

            }
         

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
