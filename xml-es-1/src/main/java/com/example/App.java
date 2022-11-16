package com.example;
import java.io.File;
import java.time.LocalDate;

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
        LocalDate d1 = LocalDate.of(2004, 6, 03);
        LocalDate d2 = LocalDate.of(2004, 9, 13);
        LocalDate d3 = LocalDate.of(2004, 11, 25);
        LocalDate d4 = LocalDate.of(2004, 5, 28);
        LocalDate d5 = LocalDate.of(2004, 9, 13);
        Studente s1 = new Studente(1, "alessia", "rocchini", d1, 95);
       /* Studente s2 = new Studente("mattia", "teriaca", d2, 95);
        Studente s3 = new Studente("alessia", "caruso", d3, 80);
        Studente s4 = new Studente("christian", "vivoli", d4,70);
        Studente s5 = new Studente("cesare", "tei", d5, 75);*/ 



        XmlMapper xmlMapper = new XmlMapper();
        
        // Serializzazione        
        xmlMapper.writeValue(new File("test.xml"), s1);
        String myXml1 = xmlMapper.writeValueAsString(s1);
        System.out.println("Oggetto serializzato:" + myXml1);

      /* xmlMapper.writeValue(new File("test.xml"), s2);
        String myXml2 = xmlMapper.writeValueAsString(s2);
        System.out.println("Oggetto serializzato:" + myXml2);

        xmlMapper.writeValue(new File("test.xml"), s3);
        String myXml3 = xmlMapper.writeValueAsString(s3);
        System.out.println("Oggetto serializzato:" + myXml3);


        xmlMapper.writeValue(new File("test.xml"), s4);
        String myXml4 = xmlMapper.writeValueAsString(s4);
        System.out.println("Oggetto serializzato:" + myXml4);

        xmlMapper.writeValue(new File("test.xml"), s5);
        String myXml5 = xmlMapper.writeValueAsString(s5);
        System.out.println("Oggetto serializzato:" + myXml5);*/  
        
        // Deserializzazione        
        Studente c2 = xmlMapper.readValue(myXml1, Studente.class);
        System.out.println("Oggetto deserializzato da stringa:" + c2.getNome());

       // Studente c3 = xmlMapper.readValue(new File("test.xml"), Studente.class);
        //System.out.println("Oggetto deserializzato da file: " + c3.getDataDiNascita());
    }


}
