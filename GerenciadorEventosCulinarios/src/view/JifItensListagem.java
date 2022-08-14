package view;

import controller.ItemController;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.ItemModel;

public class JifItensListagem extends javax.swing.JInternalFrame {
    
    ItemController itemC = new ItemController();
    
    public JifItensListagem() {
        
        initComponents();
        this.btnRemover.setEnabled(false);
        this.btnEditar.setEnabled(false);

        // atualiza a tabela tblItens
        this.tblItens.setModel(itemC.getTableModel());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDesktopPane = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovo = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnEditar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnRemover = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnAtualizarLst = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnSelecIngred = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1038, 600));

        JDesktopPane.setPreferredSize(new java.awt.Dimension(1030, 440));

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblItens);

        JDesktopPane.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDesktopPaneLayout = new javax.swing.GroupLayout(JDesktopPane);
        JDesktopPane.setLayout(JDesktopPaneLayout);
        JDesktopPaneLayout.setHorizontalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        JDesktopPaneLayout.setVerticalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovo);
        jToolBar1.add(jSeparator4);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditar);
        jToolBar1.add(jSeparator3);

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemover);
        jToolBar1.add(jSeparator2);

        btnAtualizarLst.setText("Atualizar lista");
        btnAtualizarLst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarLstActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAtualizarLst);
        jToolBar1.add(jSeparator1);

        btnSelecIngred.setText(" Editar ingredientes do item");
        btnSelecIngred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecIngredActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSelecIngred);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
            .addComponent(JDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(150, 10, 1038, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        JifNovoItem novoIt = new JifNovoItem(this.itemC);
        novoIt.setTitle("Novo Item");
        novoIt.pack();
        novoIt.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDesktopPane.add(novoIt);
        novoIt.setVisible(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (this.tblItens.getSelectedRowCount() == 1) {
            ItemModel itemModel = new ItemModel();
            itemModel.setCodItem(Integer.parseInt((String) this.tblItens.getValueAt(this.tblItens.getSelectedRow(), 0)));
            itemModel.setNomeItem((String) this.tblItens.getValueAt(this.tblItens.getSelectedRow(), 1));
            JifEditarItem editarItem = new JifEditarItem(this.itemC, itemModel);
            editarItem.setTitle("Editar item");
            editarItem.pack();
            editarItem.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JDesktopPane.add(editarItem);
            editarItem.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        // tem linha selecionada
        if (tblItens.getSelectedRow() >= 0) {
        
            // confirma remoção
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente remover o registro selecionado?") == 0) {

                // pega os dados selecionados
                int linha   = this.tblItens.getSelectedRow();
                int codItem  = Integer.parseInt( (String) this.tblItens.getValueAt(linha, 0) ); // 0 pq o codCli ta na coluna 0, ok?
                
                // se o usuario confirmou, entao remove
                itemC.removerItem(codItem);
                
                // atualiza a tabela
                this.tblItens.setModel(itemC.getTableModel());
                
                // desabilita os botoes
                this.btnRemover.setEnabled(false);
                this.btnEditar.setEnabled(false);

            }
        
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnAtualizarLstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarLstActionPerformed
        this.tblItens.setModel(itemC.getTableModel());
        this.btnRemover.setEnabled(false);
        this.btnEditar.setEnabled(false);

    }//GEN-LAST:event_btnAtualizarLstActionPerformed

    private void btnSelecIngredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecIngredActionPerformed
        
        // evita abrir os ingredientes padrão sem um item selecionado (o que seria um erro)
        if ( tblItens.getSelectedRow() < 0 ) {
            JOptionPane.showMessageDialog(null, "Selecione um item para editar seus ingredientes.");
            return;
        }
        
        // cria um modelo com os dados do item selecionado
        ItemModel itemSelecionado = new ItemModel();
        itemSelecionado.setCodItem( Integer.parseInt( tblItens.getValueAt(tblItens.getSelectedRow(), 0 ).toString()) );
        itemSelecionado.setNomeItem( tblItens.getValueAt(tblItens.getSelectedRow(), 1 ).toString() );
        
        // abre o cardapio padrao passando para ele o modelo do tema selecionado
        JifIngredientePadaoListagem temaSelec = new JifIngredientePadaoListagem(itemSelecionado);
        temaSelec.setTitle("Ingredientes do item");
        temaSelec.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDesktopPane.add(temaSelec);
        temaSelec.setVisible(true);

    }//GEN-LAST:event_btnSelecIngredActionPerformed

    private void tblItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensMouseClicked
         this.btnRemover.setEnabled(this.tblItens.getSelectedRow() > -1);
        this.btnEditar.setEnabled(this.btnRemover.isEnabled());
        
    }//GEN-LAST:event_tblItensMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktopPane;
    private javax.swing.JButton btnAtualizarLst;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSelecIngred;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblItens;
    // End of variables declaration//GEN-END:variables
}
