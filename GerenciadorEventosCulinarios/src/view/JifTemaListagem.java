package view;

import controller.TemaController;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.TemaModel;

public class JifTemaListagem extends javax.swing.JInternalFrame {
    // controller
    private TemaController tema = new TemaController();

    public JifTemaListagem() {
        initComponents();
        this.btnRemoverTema.setEnabled(false);
        this.btnEditarTema.setEnabled(false);

        // atualiza a tabela clienteListagem
        this.tblTema.setModel(tema.getTableModel());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDesktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTema = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnNovoTema = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnEditarTema = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnRemoverTema = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnAtualizarLst = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnEscolheItens = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(1038, 600));

        tblTema.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblTema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTemaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTema);

        JDesktopPane.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDesktopPaneLayout = new javax.swing.GroupLayout(JDesktopPane);
        JDesktopPane.setLayout(JDesktopPaneLayout);
        JDesktopPaneLayout.setHorizontalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
        );
        JDesktopPaneLayout.setVerticalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDesktopPaneLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jToolBar1.setRollover(true);

        btnNovoTema.setText("Novo");
        btnNovoTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoTemaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNovoTema);
        jToolBar1.add(jSeparator4);

        btnEditarTema.setText("Editar");
        btnEditarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTemaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditarTema);
        jToolBar1.add(jSeparator3);

        btnRemoverTema.setText("Remover");
        btnRemoverTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverTemaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemoverTema);
        jToolBar1.add(jSeparator2);

        btnAtualizarLst.setText("Atualizar lista");
        btnAtualizarLst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarLstActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAtualizarLst);
        jToolBar1.add(jSeparator1);

        btnEscolheItens.setText("Definir itens do Tema selecionado");
        btnEscolheItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolheItensActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEscolheItens);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JDesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(441, 441, 441))
        );

        setBounds(150, 10, 1038, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoTemaActionPerformed
        JifNovoTema novoTema = new JifNovoTema(this.tema);
        novoTema.setTitle("Novo tema");
        novoTema.pack();
        novoTema.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDesktopPane.add(novoTema);
        novoTema.setVisible(true);
        
    }//GEN-LAST:event_btnNovoTemaActionPerformed

    private void btnEditarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTemaActionPerformed
        if (this.tblTema.getSelectedRowCount() == 1) {
            TemaModel temaModel = new TemaModel();
            temaModel.setCodTema(Integer.parseInt((String) this.tblTema.getValueAt(this.tblTema.getSelectedRow(), 0)));
            temaModel.setNomeTema((String) this.tblTema.getValueAt(this.tblTema.getSelectedRow(), 1));
            JifEditarTema editarTema = new JifEditarTema(this.tema, temaModel);
            editarTema.setTitle("Editar tema");
            editarTema.pack();
            editarTema.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JDesktopPane.add(editarTema);
            editarTema.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarTemaActionPerformed

    private void btnRemoverTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverTemaActionPerformed
        // tem linha selecionada?
        if (tblTema.getSelectedRow() >= 0) {
        
            // confirma remoção
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente remover o registro selecionado?") == 0) {

                // pega os dados selecionados
                int linha   = this.tblTema.getSelectedRow();
                int codTema = Integer.parseInt( (String) this.tblTema.getValueAt(linha, 0) ); // 0 pq o codCli ta na coluna 0, ok?
                
                // se o usuario confirmou, entao remove
                tema.removerTema(codTema);
                
                // atualiza a tabela
                this.tblTema.setModel(tema.getTableModel());
                
                // desabilita os botoes
                this.btnRemoverTema.setEnabled(false);
                this.btnEditarTema.setEnabled(false);

            }
        }
        
    }//GEN-LAST:event_btnRemoverTemaActionPerformed

    private void btnAtualizarLstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarLstActionPerformed
        this.tblTema.setModel(tema.getTableModel());
        this.btnRemoverTema.setEnabled(false);
        this.btnEditarTema.setEnabled(false);

    }//GEN-LAST:event_btnAtualizarLstActionPerformed

    private void tblTemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTemaMouseClicked
        this.btnRemoverTema.setEnabled(this.tblTema.getSelectedRow() > -1);
        this.btnEditarTema.setEnabled(this.btnRemoverTema.isEnabled());
        this.btnEscolheItens.setEnabled(this.tblTema.getSelectedRow()> -1);
        
        
    }//GEN-LAST:event_tblTemaMouseClicked

    private void btnEscolheItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolheItensActionPerformed
        
        // evita abrir o cardapio padrao sem um tema selecionado (o que seria um erro)
        if ( tblTema.getSelectedRow() < 0 ) {
            JOptionPane.showMessageDialog(null, "Selecione um Tema para editar seus itens.");
            return;
        }
        
        // cria um modelo com os dados do tema selecionado
        TemaModel temaSelecionado = new TemaModel();
        temaSelecionado.setCodTema( Integer.parseInt( tblTema.getValueAt(tblTema.getSelectedRow(), 0 ).toString()) );
        temaSelecionado.setNomeTema( tblTema.getValueAt(tblTema.getSelectedRow(), 1 ).toString() );
        
        // abre o cardapio padrao passando para ele o modelo do tema selecionado
        JifCardapioPadrao temaSelec = new JifCardapioPadrao(temaSelecionado);
        temaSelec.setTitle("Itens do Tema");
        temaSelec.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDesktopPane.add(temaSelec);
        temaSelec.setVisible(true);

    }//GEN-LAST:event_btnEscolheItensActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktopPane;
    private javax.swing.JButton btnAtualizarLst;
    private javax.swing.JButton btnEditarTema;
    private javax.swing.JButton btnEscolheItens;
    private javax.swing.JButton btnNovoTema;
    private javax.swing.JButton btnRemoverTema;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblTema;
    // End of variables declaration//GEN-END:variables
}
