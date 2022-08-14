package view;

import controller.IngredienteController;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import model.IngredienteModel;

public class JifIngredientesListagem extends javax.swing.JInternalFrame {
    // controller
    private IngredienteController ing = new IngredienteController();
    private IngredienteModel ingredModel = new IngredienteModel();

    CellEditorListener changeNotification = new CellEditorListener() { 
        @Override
        public void editingCanceled(ChangeEvent e) {}
        @Override
        public void editingStopped(ChangeEvent e) {
            System.out.println("Stopped");
        }
    };
    
    public JifIngredientesListagem() {
        
        initComponents();
        
        this.btnRemover.setEnabled(false);
        this.btnEditar.setEnabled(false);

        // atualiza a tabela clienteListagem
        this.tblIngred.setModel(ing.getTableModel());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDesktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIngred = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnRemover = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnAtualizarLst = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1038, 600));

        tblIngred.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblIngred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIngredMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIngred);

        JDesktopPane.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDesktopPaneLayout = new javax.swing.GroupLayout(JDesktopPane);
        JDesktopPane.setLayout(JDesktopPaneLayout);
        JDesktopPaneLayout.setHorizontalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
        );
        JDesktopPaneLayout.setVerticalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDesktopPaneLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        jToolBar1.setRollover(true);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);
        jToolBar1.add(jSeparator1);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);
        jToolBar1.add(jSeparator2);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemover);
        jToolBar1.add(jSeparator3);

        btnAtualizarLst.setText("Atualizar lista");
        btnAtualizarLst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarLstActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAtualizarLst);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(150, 10, 1038, 600);
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        JifNovoIngrediente novoIng = new JifNovoIngrediente(this.ing);
        novoIng.setTitle("Novo Ingrediente");
        novoIng.pack();
        novoIng.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDesktopPane.add(novoIng);
        novoIng.setVisible(true);
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        
        if (this.tblIngred.getSelectedRowCount() == 1) {
            
            // transforma o valor de vv,vv para vv.vv
            String valorFormatado = (String)this.tblIngred.getValueAt(this.tblIngred.getSelectedRow(), 3);
            String[] partes = valorFormatado.split(",");
            valorFormatado = partes[0] + "." + partes[1];
            
            ingredModel.setCodIngred(Integer.parseInt((String) this.tblIngred.getValueAt(this.tblIngred.getSelectedRow(), 0)));
            ingredModel.setNomeIngred((String) this.tblIngred.getValueAt(this.tblIngred.getSelectedRow(), 1));
            ingredModel.setUnMedIngred((String) this.tblIngred.getValueAt(this.tblIngred.getSelectedRow(), 2));
            ingredModel.setValorIngred(Double.parseDouble(valorFormatado));
            JifEditarIngrediente editarIngred = new JifEditarIngrediente(this.ing, ingredModel);
            editarIngred.setTitle("Editar ingrediente");
            editarIngred.pack();
            editarIngred.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JDesktopPane.add(editarIngred);
            editarIngred.setVisible(true);
            
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        /// tem linha selecionada?
        if (tblIngred.getSelectedRow() >= 0) {
        
            // confirma remoção
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente remover o registro selecionado?") == 0) {

                // pega os dados selecionados
                int linha   = this.tblIngred.getSelectedRow();
                int codIngred  = Integer.parseInt( (String) this.tblIngred.getValueAt(linha, 0) ); // 0 pq o codIngred ta na coluna 0
                
                // se o usuario confirmou, entao remove
                ing.removerIngred(codIngred);
                
                // atualiza a tabela
                this.tblIngred.setModel(ing.getTableModel());
                
                // desabilita os botoes
                this.btnRemover.setEnabled(false);
                this.btnEditar.setEnabled(false);

            }
        
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAtualizarLstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarLstActionPerformed
        this.tblIngred.setModel(ing.getTableModel());
        this.btnRemover.setEnabled(false);
        this.btnEditar.setEnabled(false);

    }//GEN-LAST:event_btnAtualizarLstActionPerformed

    private void tblIngredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIngredMouseClicked
        this.btnRemover.setEnabled(this.tblIngred.getSelectedRow() > -1);
        this.btnEditar.setEnabled(this.btnRemover.isEnabled());
        
    }//GEN-LAST:event_tblIngredMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktopPane;
    private javax.swing.JButton btnAtualizarLst;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblIngred;
    // End of variables declaration//GEN-END:variables

}
