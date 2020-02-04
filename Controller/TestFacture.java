package Facture.Controller;

import Facture.Actions.ArchivageXML;
import Facture.Modeles.Article;
import Facture.Modeles.Articles.Lot;
import Facture.Modeles.Articles.Ramette;
import Facture.Modeles.Articles.Stylo;
import Facture.Modeles.Client;
import Facture.Modeles.Facture;
import Facture.Vues.CommandeView;
import Facture.Vues.MenuView;

import java.io.IOException;

public class TestFacture {
    public static void main(String[] args) throws IOException {
        // Initialisation des vues
        CommandeView vue_commande = new CommandeView();

        // Creation
        // creation client
        Client client = new Client("Toto", "Titi");
        // creation articles
        Ramette rametteHQ = new Ramette("r1", "Clairefont", "haute qualité", 14);
        Stylo styloJade = new Stylo("s1", "Watertruc", "Jade", 76);
        Stylo stylo = new Stylo("s2", "Marker", "", 137.2);
        Lot lotStylos = new Lot("l1", stylo, 5);
        // creation commande
        // Commande commande = new Commande(client);
        // ajout lignes de commandes
        // commande.addLigne(10, styloJade);
        // commande.addLigne(15, rametteHQ);
        // commande.addLigne(2, lotStylos);
        // creation facture
        Facture facture;
        // creation module d'archivage
        ArchivageXML archivageXML = new ArchivageXML();
        // Creation terminée

        // Initialisations pour le Menu
        MenuView menu = new MenuView();
        ActionsFacture choix;
        int entierChoixFacture;
        String[] facturesList = archivageXML.getFacturesList();

        do {
            // Choix Facture
            entierChoixFacture = menu.getChoixFacture(facturesList);
            if (entierChoixFacture != 0 && entierChoixFacture <= facturesList.length) {
                facture = (Facture) archivageXML.load(facturesList[entierChoixFacture - 1]);

                do {
                    // Affichage de la facture au demarrage
                    facture.afficherFacture();
                    // Choix Modif Facture
                    int entierModifFacture = menu.getChoixModifFacture();
                    entierModifFacture = (entierModifFacture < 7 && entierModifFacture >= 0 ? entierModifFacture : 6);
                    choix = ActionsFacture.values()[entierModifFacture];

                    switch (choix) {
                        case Afficher_facture:
                            facture.afficherFacture();
                            break;
                        case Ajout_article:
                            String[] articleStringInfos = vue_commande.nouvelArticleIntitules();
                            int prixArticle = vue_commande.nouvelArticlePrix();
                            int quantiteArticle = vue_commande.nouvelArticleQuantite();
                            Article article = new Article(articleStringInfos[2], articleStringInfos[1], articleStringInfos[0], prixArticle);
                            facture.addLigne(quantiteArticle, article);
                            break;
                        case Supprimer_article:
                            String refToRemove = vue_commande.supprimerArticle();
                            if (facture.lineExist(refToRemove)) {
                                facture.removeLigne(refToRemove);
                            } else {
                                menu.erreur("Cet article n'existe pas.");
                            }
                            break;
                        case Modifier_article:
                            String refToModify = vue_commande.selectionnerArticle();
                            if (facture.lineExist(refToModify)) {
                                int entierModifArticle = menu.getChoixModifArticle();
                                entierModifArticle = (entierModifArticle < 4 && entierModifArticle >= 0 ? entierModifArticle : 3);
                                ChoixModif choixModif = ChoixModif.values()[entierModifArticle];

                                switch (choixModif) {
                                    case Marque:
                                        String newMarque = vue_commande.modifierMarque();
                                        facture.modifyLigne(refToModify, "marque", newMarque);
                                        break;
                                    case Prix_unitaire:
                                        String newPrix = vue_commande.modifierPrix();
                                        facture.modifyLigne(refToModify, "prix", newPrix);
                                        break;
                                    case Quantite:
                                        String newQuantite = vue_commande.modifierQuantite();
                                        facture.modifyLigne(refToModify, "quantite", newQuantite);
                                        break;
                                    case Precedent:
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                menu.erreur("Cet article n'existe pas.");
                            }
                            break;
                        case Enregistrer_facture:
                            archivageXML.save(facture);
                            break;
                        case Liste_factures:
                            facturesList = archivageXML.getFacturesList();
                            break;
                        case Quitter:
                            System.exit(0);
                            break;
                        default:
                            break;
                    }
                } while (choix != ActionsFacture.Liste_factures);
            }
        } while (entierChoixFacture != 0);
    }
}
