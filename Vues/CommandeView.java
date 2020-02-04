package Facture.Vues;

import java.util.Scanner;

public class CommandeView {

    public String[] nouvelArticleIntitules() {
        Scanner s = new Scanner(System.in);
        System.out.print("Entrer l'intitulé du nouvel article : ");
        String intitule = s.nextLine();
        System.out.print("Entrer la marque du nouvel article : ");
        String marque = s.nextLine();
        System.out.print("Entrer la référence du nouvel article : ");
        String ref = s.nextLine();
        return new String[]{intitule, marque, ref};
    }

    public int nouvelArticlePrix() {
        Scanner s = new Scanner(System.in);
        System.out.print("Entrer le prix unitaire du nouvel article : ");
        return s.nextInt();
    }

    public int nouvelArticleQuantite() {
        Scanner s = new Scanner(System.in);
        System.out.print("Combien en voulez vous ? ");
        return s.nextInt();
    }

    public String supprimerArticle() {
        Scanner s = new Scanner(System.in);
        System.out.print("Entrer la référence de l'article a supprimer: ");
        return s.nextLine();
    }

    public String selectionnerArticle() {
        Scanner s = new Scanner(System.in);
        System.out.print("Entrer la référence de l'article a modifier: ");
        return s.nextLine();
    }

    public String modifierMarque() {
        Scanner s = new Scanner(System.in);
        System.out.print("Entrer la nouvelle marque de l'article : ");
        return s.nextLine();
    }

    public String modifierQuantite() {
        Scanner s = new Scanner(System.in);
        System.out.print("Entrer la nouvelle quantité d'articles que vous voulez : ");
        return s.nextLine();
    }

    public String modifierPrix() {
        Scanner s = new Scanner(System.in);
        System.out.print("Entrer le nouveau prix de l'article : ");
        return s.nextLine();
    }
}
