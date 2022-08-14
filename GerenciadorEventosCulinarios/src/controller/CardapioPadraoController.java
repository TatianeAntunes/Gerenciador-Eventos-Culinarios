package controller;

import model.CardapioPadraoModel;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import model.TemaModel;

public class CardapioPadraoController {
    
    private DefaultTableModel dtm = null;

    public CardapioPadraoController() {}
    
    public DefaultTableModel getTableModel() { return this.dtm; }
    
    private CardapioPadraoModel cardapioPadraoModel = new CardapioPadraoModel();
    
    private TemaModel temaModel;//novo
    
    // construtor                   
    public CardapioPadraoController(TemaModel temaModel) {
        this.temaModel = temaModel;//novo
        this.updateDefaultTableModel();
        
    }
 
    // atualizar
    public boolean atualizarItens(Map<Integer, Double> dados, TemaModel temaModel) {
        
        try  {
            
            cardapioPadraoModel.atualizarItens(dados, temaModel);
            
            JOptionPane.showMessageDialog(null, "O cardápio selecionado foi salvo com sucesso!");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }

    // atualiza modelo de tabela padrao
    public void updateDefaultTableModel() {
        
        CardapioPadraoModel itemCard = new CardapioPadraoModel();
        
        try {
                                                      
            this.dtm = itemCard.getDefaultTableModel(this.temaModel);
            
        } catch (SQLException ex) {
            
            this.dtm = new DefaultTableModel();
            
        }
        
    }
    
}
