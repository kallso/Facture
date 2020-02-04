package Facture.Actions;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class XMLTools {
    private XMLTools() {
    }

    public static void encodeToFile(Object object, String fileName) throws IOException {
        // ouverture de l'encodeur vers le fichier
        File f = new File(fileName);
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(f));
        try {// serialisation de l'objet
            encoder.writeObject(object);
            encoder.flush();
        } finally {
            // fermeture de l'encodeur
            encoder.close();
        }
    }

    public static Object decodeFromFile(String fileName) throws IOException {
        Object object = null;
        // ouverture de decodeur
        XMLDecoder decoder = new XMLDecoder(new FileInputStream(fileName));
        try {// deserialisation de l'objet
            object = decoder.readObject();
        } finally {
            // fermeture du decodeur
            decoder.close();
        }
        return object;
    }
}
