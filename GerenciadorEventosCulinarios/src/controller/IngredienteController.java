package controller;

import model.IngredienteModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IngredienteController {
    
    private DefaultTableModel dtm = null;
    
    public DefaultTableModel getTableModel() { return this.dtm; }
    
    // construtor
    public IngredienteController() {
        
        this.updateDefaultTableModel();
        
    }
 
    // remover cliente
    public void removerIngred(int codIngred) {
        
        IngredienteModel ingred = new IngredienteModel();
        
        try  {
            
            ingred.removerIngred(codIngred);
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        
        this.updateDefaultTableModel();
        
    }
    
    // novo ingrediente
    public boolean novoIngred(String nomeIngred, String unidMed, double valor) {
        
        // gera uma instancia com os dados
        IngredienteModel ingred = new IngredienteModel();
        ingred.setNomeIngred(nomeIngred);
        ingred.setUnMedIngred(unidMed);
        ingred.setValorIngred(valor);
        
        try  {
            
            ingred.novoIngred(ingred);
            
            JOptionPane.showMessageDialog(null, "Ingrediente cadastrado com sucesso!\n Atualize a listagem de ingredientes.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }
    
    // atualizar ingrediente
    public boolean atualizarIngred(IngredienteModel ingred) {
        
        try  {
            
            ingred.atualizarIngred(ingred);
            
            JOptionPane.showMessageDialog(null, "Ingrediente atualizado com sucesso!\n Atualize a listagem de ingredientes.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }        

    
    // atualiza modelo de tabela padrao
    public void updateDefaultTableModel() {
        
        IngredienteModel ingred = new IngredienteModel();
        
        try {
            
            this.dtm = ingred.getDefaultTableModel();
            
        } catch (SQLException ex) {
            
            this.dtm = new DefaultTableModel();
            
        }
        
    }
    
}
