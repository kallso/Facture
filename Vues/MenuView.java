package Facture.Vues;

import java.util.Scanner;

public class MenuView {

    public int getChoixFacture(String[] facturesList) {
        Scanner scan = new Scanner(System.in);
        int count = 1;

        System.out.println("------------------------------------------");
        System.out.println("Entrer le numéro de la facture a charger :");
        assert facturesList != null;
        for (String facture: facturesList) {
            System.out.println(count + "- " + facture.replace(".xml", ""));
            count++;
        }
        System.out.println("0- Quitter");
        System.out.println("------------------------------------------");
        return scan.nextInt();
    }

    public int getChoixModifFacture() {
        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------");
        System.out.println("0- Afficher la facture");
        System.out.println("1- Ajouter un article");
        System.out.println("2- Supprimer un article");
        System.out.println("3- Modifier un article");
        System.out.println("4- Enregistrer la facture");
        System.out.println("5- Liste des factures");
        System.out.println("6- Quitter");
        System.out.println("------------------------------------------");
        return scan.nextInt();
    }

    public int getChoixModifArticle() {
        Scanner scan = new Scanner(System.in);

        System.out.println("------------------------------------------");
        System.out.println("Que voulez vous modifier ?");
        System.out.println("0- La marque");
        System.out.println("1- Le prix unitaire");
        System.out.println("2- La quantité");
        System.out.println("3- Précédent");
        System.out.println("------------------------------------------");
        return scan.nextInt();
    }

    public void erreur(String message) {
        System.out.println(message);
    }
}
