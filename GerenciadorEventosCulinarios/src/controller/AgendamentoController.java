package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.AgendamentoModel;

public class AgendamentoController {
    private DefaultTableModel dtm = null;
    public DefaultTableModel getTableModel() { return this.dtm; }

    // construtor
    public AgendamentoController() {
        
        this.updateDefaultTableModel();
        
    }
    // remover cliente
    public void removerAgenda(int codAg) {
        
        AgendamentoModel agenda = new AgendamentoModel();
        
        try  {
            
            agenda.removerAgenda(codAg);
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        
        this.updateDefaultTableModel();
        
    }
    
    // novo ingrediente
    public boolean novoAgenda(Date dataAg, Time horaAg, int codCli, int codTemaAg, int nPessoas) {
        
        // gera uma instancia com os dados
        AgendamentoModel agenda = new AgendamentoModel();
        agenda.setDataAg(dataAg);
        agenda.setHoraAg(horaAg);
        agenda.setCodCli(codCli);
        agenda.setCodTemaAg(codTemaAg);
        agenda.setnPessoas(nPessoas);
        
        try  {
            
            agenda.novoAgenda(agenda);
            
            JOptionPane.showMessageDialog(null, "Agendamento registrado com sucesso!\n Atualize a listagem de agendamento.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }
    
    // atualizar ingrediente
    public boolean atualizarAgenda(AgendamentoModel agenda) {
        
        try  {
            
            agenda.atualizarAgenda(agenda);
            
            JOptionPane.showMessageDialog(null, "Agendamento atualizado com sucesso!\n Atualize a listagem de agendamento.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }        

    
    // atualiza modelo de tabela padrao
    public void updateDefaultTableModel() {
        
        AgendamentoModel agenda = new AgendamentoModel();
        
        try {
            
            this.dtm = agenda.getDefaultTableModel();
            
        } catch (SQLException ex) {
            
            this.dtm = new DefaultTableModel();
            
        }
        
    }

}
