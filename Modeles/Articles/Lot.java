package Facture.Modeles.Articles;

import Facture.Modeles.Article;

public class Lot extends Article {
    private Article article;
    private int quantite;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Lot(String ref, Article article, int quantite) {
        super(ref, article.getMarque(), article.getPrix() * quantite);
        this.nom = "Lot de " + quantite + " " + article.getNom();
        this.article = article;
        this.quantite = quantite;
    }

    public Lot() {}
}
