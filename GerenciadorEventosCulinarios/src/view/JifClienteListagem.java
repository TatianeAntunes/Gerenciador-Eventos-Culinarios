package view;

import controller.ClienteController;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.ClienteModel;

public class JifClienteListagem extends javax.swing.JInternalFrame {
    
    // controller
    private ClienteController cc = new ClienteController();

    public JifClienteListagem() {
        initComponents();
        this.botaoRemover.setEnabled(false);
        this.botaoEditar.setEnabled(false);

        // atualiza a tabela clienteListagem
        this.clienteListagem.setModel(cc.getTableModel());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDesktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        clienteListagem = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        botaoNovo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        botaoEditar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        botaoRemover = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        botaoAtualizarListagem = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1038, 600));

        clienteListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        clienteListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clienteListagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(clienteListagem);

        JDesktopPane.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDesktopPaneLayout = new javax.swing.GroupLayout(JDesktopPane);
        JDesktopPane.setLayout(JDesktopPaneLayout);
        JDesktopPaneLayout.setHorizontalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
        );
        JDesktopPaneLayout.setVerticalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoNovo);
        jToolBar1.add(jSeparator1);

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoEditar);
        jToolBar1.add(jSeparator2);

        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoRemover);
        jToolBar1.add(jSeparator3);

        botaoAtualizarListagem.setText("Atualizar lista");
        botaoAtualizarListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarListagemActionPerformed(evt);
            }
        });
        jToolBar1.add(botaoAtualizarListagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(JDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesktopPane))
        );

        setBounds(150, 10, 1038, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        JifNovoCliente novoCliente = new JifNovoCliente(this.cc);
        novoCliente.setTitle("Novo cliente");
        novoCliente.pack();
        novoCliente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDesktopPane.add(novoCliente);
        novoCliente.setVisible(true);
        
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        if (this.clienteListagem.getSelectedRowCount() == 1) {
            ClienteModel clienteModel = new ClienteModel();
            clienteModel.setCodCli(Integer.parseInt((String) this.clienteListagem.getValueAt(this.clienteListagem.getSelectedRow(), 0)));
            clienteModel.setNomeCli((String) this.clienteListagem.getValueAt(this.clienteListagem.getSelectedRow(), 1));
            JifEditarCliente editarCliente = new JifEditarCliente(this.cc, clienteModel);
            editarCliente.setTitle("Editar cliente");
            editarCliente.pack();
            editarCliente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JDesktopPane.add(editarCliente);
            editarCliente.setVisible(true);
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        // tem linha selecionada?
        if (clienteListagem.getSelectedRow() >= 0) {
        
            // confirma remoção
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente remover o registro selecionado?") == 0) {

                // pega os dados selecionados
                int linha   = this.clienteListagem.getSelectedRow();
                int codCli  = Integer.parseInt( (String) this.clienteListagem.getValueAt(linha, 0) ); // 0 pq o codCli ta na coluna 0, ok?
                
                // se o usuario confirmou, entao remove
                cc.removerCliente(codCli);
                
                // atualiza a tabela
                this.clienteListagem.setModel(cc.getTableModel());
                
                // desabilita os botoes
                this.botaoRemover.setEnabled(false);
                this.botaoEditar.setEnabled(false);

            }
        
        }
        
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void botaoAtualizarListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarListagemActionPerformed
        this.clienteListagem.setModel(cc.getTableModel());
        this.botaoRemover.setEnabled(false);
        this.botaoEditar.setEnabled(false);
    }//GEN-LAST:event_botaoAtualizarListagemActionPerformed

    private void clienteListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clienteListagemMouseClicked
        this.botaoRemover.setEnabled(this.clienteListagem.getSelectedRow() > -1);
        this.botaoEditar.setEnabled(this.botaoRemover.isEnabled());
       
    }//GEN-LAST:event_clienteListagemMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktopPane;
    private javax.swing.JButton botaoAtualizarListagem;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JTable clienteListagem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
