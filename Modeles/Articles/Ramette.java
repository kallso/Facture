package Facture.Modeles.Articles;

import Facture.Modeles.Article;

public class Ramette extends Article {

    public Ramette(String ref, String marque, String qualite, double prix) {
        super(ref, marque, prix);
        this.nom += " " + qualite;
    }
}
