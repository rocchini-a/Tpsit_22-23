package com.example;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception 
    {
        System.out.println("------------");
        Studenti listaStudenti = new Studenti();
        Studente s1 = new Studente(1, "alessia", "rocchini", "2004-06-03", 95);
        Studente s2 = new Studente(2,"mattia", "teriaca", "2004-09-13", 95);
        Studente s3 = new Studente(3, "alessia", "caruso", "2004-11-25", 80);
        Studente s4 = new Studente(4, "christian", "vivoli", "2004-05-28",70);
        Studente s5 = new Studente(5, "cesare", "tei", "2004-11-03", 75);

        listaStudenti.add(s1);
        listaStudenti.add(s2);
        listaStudenti.add(s3);
        listaStudenti.add(s4);
        listaStudenti.add(s5);

        XmlMapper xmlMapper = new XmlMapper();
        
        // Serializzazione        
        xmlMapper.writeValue(new File("studenti.xml"), listaStudenti);
        String myXml1 = xmlMapper.writeValueAsString(listaStudenti);
        System.out.println("Oggetto serializzato:" + myXml1);

    }


}
