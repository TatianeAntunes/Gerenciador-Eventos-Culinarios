package controller;

import model.ClienteModel;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class ClienteController {
    
    private DefaultTableModel dtm = null;
    
    public DefaultTableModel getTableModel() { return this.dtm; }
    
    // construtor
    public ClienteController() {
        
        this.updateDefaultTableModel();
        
    }
 
    // remover cliente
    public void removerCliente(int codCli) {
        
        ClienteModel cliente = new ClienteModel();
        
        try  {
            
            cliente.removerCliente(codCli);
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
        }
        
        this.updateDefaultTableModel();
        
    }
    
    // novo cliente
    public boolean novoCliente(String nomeCli) {
        
        // gera uma instancia com os dados
        ClienteModel cliente = new ClienteModel();
        cliente.setNomeCli(nomeCli);
        
        try  {
            
            cliente.novoCliente(cliente);
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado(a) com sucesso.\n Atualize a listagem de clientes.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }
    
    // atualizar cliente
    public boolean atualizarCliente(ClienteModel cliente) {
        
        try  {
            
            cliente.atualizarCliente(cliente);
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado(a) com sucesso. Atualize a listagem de clientes.");
            
            this.updateDefaultTableModel();
            
            return true;
        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex.getMessage());
            
            return false;
            
        }
        
    }        

    
    // atualiza modelo de tabela padrao
    public void updateDefaultTableModel() {
        
        ClienteModel cliente = new ClienteModel();
        
        try {
            
            this.dtm = cliente.getDefaultTableModel();
            
        } catch (SQLException ex) {
            
            this.dtm = new DefaultTableModel();
            
        }
        
    }
    
}
