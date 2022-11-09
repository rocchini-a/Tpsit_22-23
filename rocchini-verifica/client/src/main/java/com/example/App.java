package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
                    
public class App {
    

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3000);
        ServerConnection serverConn = new ServerConnection(s);

        PrintWriter pr = new PrintWriter(s.getOutputStream(), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));

        pr.println("");
        System.out.println("Eccomi");
        pr.println(tastiera.readLine());
        System.out.println(br.readLine());
        
        new Thread(serverConn).start();

        for(; ;){
            String x = tastiera.readLine();
            pr.println(x);
            if(x.equals("Q")){
                break;
            
        }
    }
}
}