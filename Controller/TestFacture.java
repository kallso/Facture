package Facture.Controller;

import Facture.Modeles.ArticleCommande;
import Facture.Modeles.Articles.Ramette;
import Facture.Modeles.Articles.Stylo;
import Facture.Modeles.Client;
import Facture.Modeles.Facture;
import Facture.Vues.FactureView;

public class TestFacture {
    public static void main(String[] args) {
        Client client = new Client("Toto", "Titi");
        Ramette ramette = new Ramette("r1", "Clairefont","haute qualité", 14);
        Stylo stylo = new Stylo("s1", "Watertruc", "Jade", 76);
        ArticleCommande[] articlesCommande = {ramette, stylo};
        Facture facture = new Facture(12345, client, {ramette, stylo});
        FactureView factureView = new FactureView();

        System.out.println(ramette.getNom());
        System.out.println(stylo.getNom());
    }
}
