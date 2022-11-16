package com.example;

import java.time.LocalDate;

public class Studente {
    private int id;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private int votoesame;

    //costruttore vuoto
    
    public Studente(){

    }

    //costruttore  pieno
   
    public Studente(int id, String nome, String cognome, LocalDate dataDiNascita, int votoesame) {
        this.id =id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.votoesame = votoesame;
    }

    //get e set
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getVotoesame() {
        return votoesame;
    }

    public void setVotoesame(int votoesame) {
        this.votoesame = votoesame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

}
