package edu.conncection_alt.tests;

import edu.conncection_alt.entities.Personne;
import edu.conncection_alt.services.PersonneServices;
import edu.conncection_alt.tools.MyConncetion;

import java.util.ArrayList;
import java.util.List;

public class MainConnection {
    public static void main(String[] args) {
        //MyConncetion myConncetion=new MyConncetion();
        PersonneServices p1=new PersonneServices();
        Personne personne=new Personne(12,"amine","oun");

        p1.addEntity2(personne);
         List<Personne> list= p1.getAllData();
        for (Personne p:list
             ) {
            System.out.println(p.toString());
        }

    }
}
