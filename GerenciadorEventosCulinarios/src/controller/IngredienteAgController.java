package controller;

import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import model.IngredienteAgModel;
import model.ItemModel;

public class IngredienteAgController {
    
    private DefaultTableModel dtm = null;
    
    public DefaultTableModel getTableModel() { return this.dtm; }
    
    private IngredienteAgModel ingredienteAgModel = new IngredienteAgModel();
    
    private ItemModel itemModel;
    
    // construtor
    public IngredienteAgController(ItemModel itemModel) {
        this.itemModel = itemModel;
        this.updateDefaultTableModel();
    }
 
    // atualizar ingreiente do item
     public boolean atualizarIngred(Map<Integer, Double[]> dados, ItemModel itemModel) {
        
        try  {
            
            ingredienteAgModel.atualizarIngred(dados, itemModel);
            
            JOptionPane.showMessageDialog(null, "Os ingredientes do item foram atualizados com sucesso!");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    } 
       

    // atualiza modelo de tabela padrao
    public void updateDefaultTableModel() {
        
        IngredienteAgModel ingPadM = new IngredienteAgModel();
        
        try {
            
            this.dtm = ingPadM.getDefaultTableModel(this.itemModel);
            
        } catch (SQLException ex) {
            
            this.dtm = new DefaultTableModel();
            
        }
        
    }
    
}
