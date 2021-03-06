package Facture.Modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

public class Facture implements Serializable {
    private int numero, prixTotal;
    private Client client;
    private Date date;
    private LinkedList<LigneCommande> articles;
    private Commande commande;

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setArticles(LinkedList<LigneCommande> articles) {
        this.articles = articles;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPrixTotal() {
        for(LigneCommande ligneCommande : articles) {
            prixTotal += ligneCommande.getPrixTotal();
        }
        return prixTotal;
    }

    public String getNomClient() {
        return client.getNom();
    }

    public Date getDate() {
        return date;
    }

    public LinkedList<LigneCommande> getArticles() {
        return articles;
    }

    public Client getClient() {
        return client;
    }

    public Facture(int numero, Commande commande) {
        this.numero = numero;
        this.date = new Date();
        this.commande = commande;
        this.client = commande.getClient();
        this.articles = commande.getArticles();
    }

    public Facture() {}

    public boolean lineExist(LigneCommande ligne) {
        boolean lineExist = false;

        if (articles.contains(ligne)) {
            lineExist = true;
        }
        return lineExist;
    }

    public boolean lineExist(String ref) {
        boolean lineExist = false;

        LigneCommande compareObject = new LigneCommande(new Article(ref));
        if (articles.contains(compareObject)) {
            lineExist = true;
        }
        return lineExist;
    }

    public void afficherFacture() {
        String repeated = new String(new char[80]).replace('\0', '-');
        System.out.println(repeated);
        System.out.printf("Facture %d       Client: %s       Date: %s %n",
                this.getNumero(), this.getNomClient(), this.getDate());
        System.out.printf("%7s  %6s  %23s  %14s  %10s  %10s %n",
                "Quant.", "Réf.", "Nom", "Marque", "PU", "PT");
        for(LigneCommande ligne : articles) {
            System.out.printf("%7d  %6s  %23.20s  %14.20s  %10.2f  %10.2f %n",
                    ligne.getQuantite(), ligne.getArticle().getRef(),
                    ligne.getArticle().getNom(),
                    ligne.getArticle().getMarque(), ligne.getArticle().getPrix(), ligne.getPrixTotal());
        }
        System.out.printf("%48s Prix total facture : %10.2f %n%n", "", this.getPrixTotal());
    }

    public boolean addLigne(int quantite, Article article) {
        boolean result = false;
        // LinkedList<LigneCommande> articles = facture.getArticles();
        LigneCommande compareObject = new LigneCommande(new Article(article.getRef()));
        if (!articles.contains(compareObject)) {
            result = articles.add(new LigneCommande(quantite, article));
        } else {
            int index = articles.indexOf(compareObject);
            LigneCommande ligne = articles.get(index);
            ligne.setQuantite(ligne.getQuantite() + quantite);
            result = true;
        }
        return result;
    }

    public boolean removeLigne(String ref) {
        boolean ok = false;
        LigneCommande compareObject = new LigneCommande(new Article(ref));
        ok = articles.remove(compareObject);
        return ok;
    }

    public boolean modifyLigne(String ref, String elementToModify, String newValue) {
        // LinkedList<LigneCommande> articles = facture.getArticles();
        boolean ok = false;
        LigneCommande compareObject = new LigneCommande(new Article(ref));
        int index = articles.indexOf(compareObject);
        LigneCommande ligne = articles.get(index);
        if (ligne != null) {
            ok = true;
        }
        Article article = ligne.getArticle();
        switch (elementToModify) {
            case "marque":
                article.setMarque(newValue);
                break;
            case "prix":
                article.setPrix(Double.parseDouble(newValue));
                break;
            case "quantite":
                ligne.setQuantite(Integer.parseInt(newValue));
                break;
        }
        return ok;
    }
}
