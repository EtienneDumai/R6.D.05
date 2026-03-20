package org.example;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PanierTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Panier panier;
    private GestionDeStock gestionDeStock;
    private Comptabilite comptabilite;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        comptabilite = new Comptabilite("comptabilité");
        gestionDeStock = new GestionDeStock("gestionDeStock");
        panier = new Panier(gestionDeStock, comptabilite);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
    @Test
    public void should_declencher_commande(){
        //WHEN
        panier.declencherCommande();
        //THEN
        assertThat(outputStreamCaptor.toString())
                .contains("G.DES.STOCKS:CONTENU DU PANIER\n" +
                        "comptabilité:contenu du panier");
    }
    @Test
    public void should_traiter_comptabilite(){
        //WHEN
        comptabilite.traite("comptabilité");
        //THEN
        assertThat(outputStreamCaptor.toString())
                .contains("comptabilité:comptabilité");
    }
    @Test
    public void should_traiter_gestionStock(){
        //WHEN
        gestionDeStock.traite("gestionStock");
        //THEN
        assertThat(outputStreamCaptor.toString()).contains("G.DES.STOCKS:GESTIONSTOCK");
    }
    @Test
    public void should_return_contenu(){
        //WHEN
        String contenu = panier.getContenu();
        //THEN
        assertThat(contenu.contains("Contenu du panier"));
    }
}
