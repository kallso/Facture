package Facture.Modeles.Articles;

import Facture.Modeles.Article;

public class Lot extends Article {
    private Article article;
    private int quantite;

    public Lot(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Lot de " + quantite + " " + article.getNom();
    }
}
