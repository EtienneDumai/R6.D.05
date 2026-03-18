package org.example;

import java.util.ArrayList;
public class Panier {
    private GestionDeStock stock;
    private Comptabilite compta;
    private String contenu;

    public Panier (GestionDeStock pStock, Comptabilite pCompta) {
        this.stock = pStock;
        this.compta = pCompta;
        this.contenu = new String ("Contenu du panier");
    }

    public String getContenu() {
        return this.contenu;
    };

    public void declencherCommande() {
        this.stock.traite(this.contenu);
        this.compta.traite(this.contenu);
    }
}
