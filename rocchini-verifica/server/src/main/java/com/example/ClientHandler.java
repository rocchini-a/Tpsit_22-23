package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler extends Thread {
    private Socket s;

    public Socket getS() {
        return s;
    }

    private PrintWriter pr = null;
    private BufferedReader br = null;
    private int numClient=0; //numero cliente
    static int c = 4; //numero biglietti
    private String comando;
    private List<ClientHandler> clients;

    // contatore = contatore+1;
    public ClientHandler(Socket s,int num, List<ClientHandler> x) {
        this.clients = x;
        this.s = s;
        this.comando = "";
        this.numClient=num;
        try {
            pr = new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run() {
 
        try {        
            
            for(;;){

                comando = br.readLine();
                if(c==0){
                    sendToAll("I biglietti sono terminati");
                    sendToAll("@");
                    break;
                }   else if(comando.equals("D")){
                    if(c!=0){
                        pr.println("il numero di biglietti disponibili è: " + c);
                    }else{
                    pr.println("biglietti esauriti");
                    }
                    
                }else if(comando.equals("A")){
                    if(c!=0){
                        pr.println("Hai acquistato un biglietto ");
                         c--;
                    }else{
                        pr.println("biglietti esauriti");}
                    
                }else if(comando.equals("Q")){

                    System.out.println("Connessione chiusa con utente n. " + numClient);
                    s.close();
                    break;

                     }
                if(c==0){
                    
                }
                   
            }
        }
        catch(Exception e){
            
        }    

       
    }
    private void sendToAll(String msg) {
        for (ClientHandler client : clients) {
            client.pr.println(msg);
        }
    }
 }