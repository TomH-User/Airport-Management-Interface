import javax.swing.*;
import javax.swing.JOptionPane;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Tom
 */
public class Export {

    //Attributs
    private final BufferedWriter sortie;
    public JFrame ecran;
    public javax.swing.JTable Table;

    //Constructeur
    public Export(File fichier) throws IOException {
        sortie = new BufferedWriter(new FileWriter(fichier));
    }

    //Methode
    public void Ecrit(JTable Table) {
        try {
            sortie.write("Numero_vol;Nom_Compagnie;Date_Depart;Ville_Arrivee;Nombre_Passagers;Nombre_Personne;Total_Personne;Vol_Direct");
            sortie.newLine();
            //Parcours de nos lignes et colonnes
            for (int r = 0; r < Table.getRowCount(); r++) {
                for (int c = 0; c < Table.getColumnCount(); c++) {

                    //Ecriture
                    sortie.write(Table.getValueAt(r, c).toString() + ";");
                }
                //Creation d'une nouvelle ligne quand la dernière colonne est parcourrue
                sortie.newLine();
            }
            JOptionPane.showMessageDialog(ecran, "Fichier exporté", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            sortie.close();

        } catch (IOException exception) {
            JOptionPane.showMessageDialog(ecran, "Exportation impossible", "ERREUR", JOptionPane.ERROR_MESSAGE);
        }
    }
}