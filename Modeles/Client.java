package Facture.Modeles;

import java.io.Serializable;

public class Client implements Serializable {
    static private int idCount;
    private int id;
    private String nom, prenom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Client(String nom, String prenom) {
        this.id = getNewID();
        this.nom = nom;
        this.prenom = prenom;
    }

    public Client() {}

    static private int getNewID() {
        return idCount++;
    }
}
