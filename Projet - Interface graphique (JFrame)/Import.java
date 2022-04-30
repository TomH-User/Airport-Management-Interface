import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Tom
 */
public class Import {

    //Attributs
    private final BufferedReader entree;
    private final DefaultTableModel tblmodel;

    //Constructeur
    public Import(File fichier, JTable Table) throws FileNotFoundException {
        entree = new BufferedReader(new FileReader(fichier));
        tblmodel = (DefaultTableModel) Table.getModel();
    }

    //Methodes
    public void Importer(JTable Table) throws IOException {

        Object[] tabligne = entree.lines().toArray();
        for (int i = 1; i < tabligne.length; i++) {
            String line = tabligne[i].toString();
            String[] donnees = line.split(";");
            tblmodel.addRow(donnees);
        }
    }

    public void Ecraser(JTable Table) throws IOException {
        for (int i = tblmodel.getRowCount() - 1; i >= 0; i--) {
            tblmodel.removeRow(i);
        }
        Importer(Table);

    }
}