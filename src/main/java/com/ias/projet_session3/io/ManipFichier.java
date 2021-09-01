/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.swing.JOptionPane;

/**
 *
 * @author BaDRi
 */
public class ManipFichier {
    public static void copierFichier(File fichierSource, File fichierDestination) throws IOException {
        if (!fichierSource.exists()) {
            return;
        }
        if (!fichierDestination.exists()) {
            fichierDestination.createNewFile();
        }
        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(fichierSource).getChannel();
            destination = new FileOutputStream(fichierDestination).getChannel();
            if (destination != null && source != null) {
                destination.transferFrom(source, 0, source.size());
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Fichier non trouve!\n",
                    "Fichier non trouve!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Fichier non trouve!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                    "Erreur de copier de fichier!!", JOptionPane.ERROR_MESSAGE);
            // System.out.println("Erreur de manipulation fichier!");
        } finally {
            if ((source != null) || (destination != null))
                try {
                source.close();
                destination.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erreur de manipulation fichier!\n",
                        "Erreur de fermeture de fichier!!", JOptionPane.ERROR_MESSAGE);
                // System.out.println("Erreur de manipulation stream!");
            }

        }
    }
}
