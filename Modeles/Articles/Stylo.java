package Facture.Modeles.Articles;

import Facture.Modeles.Article;

public class Stylo extends Article {

    public Stylo(String ref, String marque, String couleur, double prix) {
        super(ref, marque, prix);
        this.nom += " " + couleur;
    }
}
