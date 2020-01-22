package Facture.Vues;

import Facture.Modeles.Client;
import Facture.Modeles.Facture;

public class FactureView {
    Facture facture;
    Client client;

    public FactureView(Facture facture, Client client) {
        this.facture = facture;
        this.client = client;
    }

    public void print() {
        System.out.println("Facture " + facture.getNumero() + " Client: " + facture.getNomClient() + " Date: " + facture.getDate());
    }
}
