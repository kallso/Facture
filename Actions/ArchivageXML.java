package Facture.Actions;

import Facture.Modeles.Facture;

import java.io.*;

public class ArchivageXML {

    public String[] getFacturesList() {
        File facturesFile = new File("src/Facture/Storage/Factures");
        return facturesFile.list();
    }

    public Object load(String fileName) {
        //Désérialisation XML
        String filePath = "src/Facture/Storage/Factures/" + fileName;
        Facture facture = null;
        try {
            facture = (Facture) XMLTools.decodeFromFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return facture;
    }

    //TODO element is either a facture or a commande. Its actually always a facture
    public void save(Object objectToSerialize) {
        //Sérialisation XML
        String filePath = "src/Facture/Storage/Factures/Facture" + (getFacturesList().length + 1) + ".xml";
        try {
            XMLTools.encodeToFile(objectToSerialize, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
