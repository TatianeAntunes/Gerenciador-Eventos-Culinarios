package controller;

import model.ItemModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ItemController {
    
    private DefaultTableModel dtm = null;
    
    public DefaultTableModel getTableModel() { return this.dtm; }
    
    // construtor
    public ItemController() {
        
        this.updateDefaultTableModel();
        
    }
 
    // remover item
    public void removerItem(int codItem) {
        
        ItemModel item = new ItemModel();
        
        try  {
            
            item.removerItem(codItem);
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        
        this.updateDefaultTableModel();
        
    }
    
    // novo Item
    public boolean novoItem(String nomeItem) {
        
        // gera uma instancia com os dados
        ItemModel item = new ItemModel();
        item.setNomeItem(nomeItem);
        
        try  {
            
            item.novoItem(item);
            
            JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!\n Atualize a listagem de itens.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "O item não foi cadastrado!\nERRO:"+ex.getMessage());
            
            return false;
            
        }
        
    }
    
    // atualizar item
    public boolean atualizarItem(ItemModel item) {
        
        try  {
            
            item.atualizarItem(item);
            
            JOptionPane.showMessageDialog(null, "Item atualizado com sucesso!\nAtualize a listagem de item.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }        

    
    // atualiza modelo de tabela padrao
    public void updateDefaultTableModel() {
        
        ItemModel item = new ItemModel();
        
        try {
            
            this.dtm = item.getDefaultTableModel();
            
        } catch (SQLException ex) {
            
            this.dtm = new DefaultTableModel();
            
        }
        
    }
    
}
