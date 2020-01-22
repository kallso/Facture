package Facture.Modeles;

public class ArticleCommande {
    private int quantite;
    private double prixTotal;
    private Article article;

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }


    public ArticleCommande(Article article, int quantite) {
        this = new Article(article.ref, article.marque, article.prix);
        this.quantite = quantite;
        this.prixTotal = quantite * article.prix;
    }
}
