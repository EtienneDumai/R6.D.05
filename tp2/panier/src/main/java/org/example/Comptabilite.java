package org.example;

import java.util.ArrayList;

public class Comptabilite implements Subscriber{
    private String comptabilite;

    public Comptabilite(String pComptabilite) {
        this.comptabilite = pComptabilite;
    }
    @Override
    public void update(String contenu){
        System.out.println("comptabilité:" + contenu.toString().toLowerCase());
    }
    public void traite(String contenu) {
        System.out.println("comptabilité:" + contenu.toString().toLowerCase());
    }
}
