package Facture.Modeles;

public class Article {
    protected String ref, marque, nom;
    protected double prix;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Article(String ref, String marque, double prix) {
        this.ref = ref;
        this.marque = marque;
        this.nom = getClass().getSimpleName();
        this.prix = prix;
    }

    public Article() {
    }
}
