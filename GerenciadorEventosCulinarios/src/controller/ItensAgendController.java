package controller;

import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import model.AgendamentoModel;
import model.ItensAgendModel;

public class ItensAgendController {
    
    private DefaultTableModel dtm = null;
    
    public DefaultTableModel getTableModel() { return this.dtm; }
    
    private ItensAgendModel itensAgendModel = new ItensAgendModel();
    
    private AgendamentoModel agModel;
    
    // construtor
    public ItensAgendController(AgendamentoModel agModel) {
        this.agModel = agModel;//novo
        this.updateDefaultTableModel();
        
    }
 
    // atualizar cliente
    public boolean atualizarItens(Map<Integer, Double> dados, AgendamentoModel IagModel) {
        
        try  {
            
            itensAgendModel.atualizarItens(dados, IagModel);
            
            JOptionPane.showMessageDialog(null, "Os itens do agendamento foram salvos com sucesso!");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }        
       

    // atualiza modelo de tabela padrao
    public void updateDefaultTableModel() {
        
        ItensAgendModel IagModel = new ItensAgendModel();
        
        try {
            
            this.dtm = IagModel.getDefaultTableModel(this.agModel);
            
        } catch (SQLException ex) {
            
            this.dtm = new DefaultTableModel();
            
        }
        
    }
    
}
