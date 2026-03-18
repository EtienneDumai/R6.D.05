package org.example;

public class Main {

    public static void main(String[] args) {
        Panier panier;
        GestionDeStock gestionDeStock;
        Comptabilite comptabilite;
        comptabilite = new Comptabilite("comptabilité");
        gestionDeStock = new GestionDeStock("gestionDeStock");
        panier = new Panier(gestionDeStock, comptabilite);
        panier.declencherCommande();
    }
}