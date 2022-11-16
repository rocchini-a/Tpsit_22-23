package com.example;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Studenti {
    @JacksonXmlElementWrapper(useWrapping = false)
    ArrayList<Studente> studente;

    public Studenti() {
        this.studente = new ArrayList<>();
    }

    public ArrayList<Studente> getStudenti() {
        return studente;
    }

    public void setStudenti(ArrayList<Studente> studenti) {
        this.studente = studenti;
    }

    public void add(Studente s){
        studente.add(s);
    }
}
