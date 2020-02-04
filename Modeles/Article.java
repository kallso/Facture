package Facture.Modeles;

import java.io.Serializable;
import java.util.Objects;

public class Article implements Serializable {
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

    public Article(String ref, String marque, String nom, double prix) {
        this.ref = ref;
        this.marque = marque;
        this.nom = nom;
        this.prix = prix;
    }

    public Article(String ref, String marque, double prix) {
        this.ref = ref;
        this.marque = marque;
        this.nom = getClass().getSimpleName();
        this.prix = prix;
    }

    public Article(String ref) {
        this.ref = ref;
    }

    public Article() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Article article = (Article) o;
        return ref.equals(article.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref);
    }
}
