package controller;

import model.TemaModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TemaController {
private DefaultTableModel dtm = null;
    
    public DefaultTableModel getTableModel() { return this.dtm; }
    
    // construtor
    public TemaController() {
        
        this.updateDefaultTableModel();
        
    }
 
    // remover tema
    public void removerTema(int codTema) {
        
        TemaModel tema = new TemaModel();
        
        try  {
            
            tema.removerTema(codTema);
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        
        this.updateDefaultTableModel();
        
    }
    
    // novo tema
    public boolean novoTema(String nomeTema) {
        
        // gera uma instancia com os dados
        TemaModel tema = new TemaModel();
        tema.setNomeTema(nomeTema);
        
        try  {
            
            tema.novoTema(tema);
            
            JOptionPane.showMessageDialog(null, "Tema cadastrado com sucesso!\nAtualize a listagem de tema.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }
    
    // atualizar tema
    public boolean atualizarTema(TemaModel tema) {
        
        try  {
            
            tema.atualizarTema(tema);
            
            JOptionPane.showMessageDialog(null, "Tema atualizado com sucesso!\n Atualize a listagem de tema.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }        

    
    // atualiza modelo de tabela padrao
    public void updateDefaultTableModel() {
        
        TemaModel tema = new TemaModel();
        
        try {
            
            this.dtm = tema.getDefaultTableModel();
            
        } catch (SQLException ex) {
            
            this.dtm = new DefaultTableModel();
            
        }
        
    }
    
}
