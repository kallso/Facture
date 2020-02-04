package Facture.Modeles;

import java.io.Serializable;
import java.util.Objects;

public class LigneCommande implements Serializable {
    private int quantite;
    private Article article;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public LigneCommande(int quantite, Article article) {
        this.quantite = quantite;
        this.article = article;
    }

    public LigneCommande(Article article) {
        this.article = article;
    }

    public LigneCommande() {}

    public double getPrixTotal() {
        return this.article.getPrix() * quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneCommande that = (LigneCommande) o;
        return article.equals(that.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(article);
    }
}
