package Facture.Modeles;

import java.util.Date;

public class Facture {
    private int numero, prixTotal;
    final private String nomClient;
    final private Date date;
    private ArticleCommande[] articles;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPrixTotal() {
        for(ArticleCommande articleCommande : articles) {
            prixTotal += articleCommande.getArticle().prix;
        }
        return prixTotal;
    }

    public String getNomClient() {
        return nomClient;
    }

    public Date getDate() {
        return date;
    }

    public ArticleCommande[] getArticles() {
        return articles;
    }

    public void setArticles(ArticleCommande[] articles) {
        this.articles = articles;
    }

    public Facture(int numero, Client client, ArticleCommande[] articles) {
        this.numero = numero;
        this.nomClient = client.getNom();
        this.date = new Date();
        this.articles = articles;
    }

}
