package Facture.Modeles;

import java.util.UUID;

public class Client {
    private UUID id;
    private String nom, prenom;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
        this.id = UUID.randomUUID();
        this.nom = nom;
        this.prenom = prenom;
    }
}
