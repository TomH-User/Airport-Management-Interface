import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Tom
 */
public class Recherche {
    //Attributs
    private final DefaultTableModel tblmodel;
    private final JTable Table;

    //Constructeur
    Recherche(JTable Table){
        tblmodel=(DefaultTableModel) Table.getModel();
        this.Table=Table;
    }
    
    //Methodes
     void filtreIndex(String filtre, int column){
        //Création puis affectation du tableau trié avec la chaine de caractère 'filtre'
        TableRowSorter<DefaultTableModel> tablerow = new TableRowSorter<>(tblmodel);
        Table.setRowSorter(tablerow);
        tablerow.setRowFilter(RowFilter.regexFilter(filtre, column));     
    }
     
      void filtreRecherche(String filtre){
        //Création puis affectation du tableau trié avec la chaine de caractère 'filtre'
        TableRowSorter<DefaultTableModel> tablerow = new TableRowSorter<>(tblmodel);
        Table.setRowSorter(tablerow);
        tablerow.setRowFilter(RowFilter.regexFilter(filtre)); 
    }
}