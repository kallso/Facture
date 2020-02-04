package Facture.Modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;

public class Commande implements Serializable {
    static private int idCount;
    private int id;
    private Client client;
    private Date date;
    private LinkedList<LigneCommande> articles;

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Date getDate() {
        return date;
    }

    public LinkedList<LigneCommande> getArticles() {
        return articles;
    }

    public Commande(Client client, LinkedList<LigneCommande> articles) {
        this.client = client;
        this.articles = articles;
        this.date = new Date();
        this.id = getNewID();
    }

    public Commande(Client client) {
        this.client = client;
        this.articles = new LinkedList();
        this.date = new Date();
        this.id = getNewID();
    }

    public Commande() {}

    static private int getNewID() {
        return idCount++;
    }

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
