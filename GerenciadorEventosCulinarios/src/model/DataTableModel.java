package model;

import java.util.LinkedList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DataTableModel {
    
    public static DefaultTableModel getTableModel(LinkedList<String[]> body, LinkedList<String> header) {
        
        // cabeçalho da tabela
        Vector<String> columnNames = new Vector<String>();
        for (int column = 0; column < header.size(); column++) {
            columnNames.add(header.get(column));
        }
        
        // corpo da tabela
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        for(String[] instance : body) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 0; columnIndex < header.size(); columnIndex++) {
                vector.add(instance[ columnIndex ]);
            }
            data.add(vector);
        }
        
        return new DefaultTableModel(data, columnNames);
        
    }
    
}
