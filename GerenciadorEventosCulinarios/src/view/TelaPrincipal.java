package view;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TelaPrincipal extends javax.swing.JFrame {
    
    public TelaPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnCrudAgenda = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnCrudCliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnCrudTema = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnCrudItens = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnCrudIngrediente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jdpPrincipal.setToolTipText("");
        jdpPrincipal.setPreferredSize(new java.awt.Dimension(1340, 768));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ícone/background-1932466_1920.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(1370, 768));
        jLabel1.setMinimumSize(new java.awt.Dimension(1366, 776));
        jLabel1.setPreferredSize(new java.awt.Dimension(1370, 768));

        jdpPrincipal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jdpPrincipalLayout = new javax.swing.GroupLayout(jdpPrincipal);
        jdpPrincipal.setLayout(jdpPrincipalLayout);
        jdpPrincipalLayout.setHorizontalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jdpPrincipalLayout.setVerticalGroup(
            jdpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdpPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jdpPrincipal);
        jdpPrincipal.setBounds(0, 60, 1370, 710);

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator5);

        btnCrudAgenda.setText("Agendamento");
        btnCrudAgenda.setFocusable(false);
        btnCrudAgenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrudAgenda.setPreferredSize(new java.awt.Dimension(85, 63));
        btnCrudAgenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCrudAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudAgendaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCrudAgenda);
        jToolBar1.add(jSeparator1);

        btnCrudCliente.setText("Cliente");
        btnCrudCliente.setFocusable(false);
        btnCrudCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrudCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCrudCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudClienteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCrudCliente);
        jToolBar1.add(jSeparator2);

        btnCrudTema.setText("Tema");
        btnCrudTema.setFocusable(false);
        btnCrudTema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrudTema.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCrudTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudTemaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCrudTema);
        jToolBar1.add(jSeparator3);

        btnCrudItens.setText("Item");
        btnCrudItens.setFocusable(false);
        btnCrudItens.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrudItens.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCrudItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudItensActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCrudItens);
        jToolBar1.add(jSeparator4);

        btnCrudIngrediente.setText("Ingrediente");
        btnCrudIngrediente.setFocusable(false);
        btnCrudIngrediente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCrudIngrediente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCrudIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudIngredienteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCrudIngrediente);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 1370, 60);

        setBounds(0, 0, 1384, 813);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrudAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudAgendaActionPerformed
        JifAgendamentoListagem agenda = new JifAgendamentoListagem();
        jdpPrincipal.add(agenda);
        agenda.setTitle("Agendamento de eventos");
        agenda.pack();
        agenda.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        agenda.setVisible(true);
        
    }//GEN-LAST:event_btnCrudAgendaActionPerformed

    private void btnCrudClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudClienteActionPerformed
        JifClienteListagem cliente = new JifClienteListagem();
        jdpPrincipal.add(cliente);
        cliente.setTitle("Cadastro de Clientes");
        cliente.pack();
        cliente.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cliente.setVisible(true);
        
    }//GEN-LAST:event_btnCrudClienteActionPerformed

    private void btnCrudTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudTemaActionPerformed
        JifTemaListagem tema = new JifTemaListagem();
        jdpPrincipal.add(tema);
        tema.setTitle("Cadastro de Temas");
        tema.pack();
        tema.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tema.setVisible(true);

    }//GEN-LAST:event_btnCrudTemaActionPerformed

    private void btnCrudItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudItensActionPerformed
        JifItensListagem item = new JifItensListagem();
        jdpPrincipal.add(item);
        item.setTitle("Cadastro de itens");
        item.pack();
        item.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        item.setVisible(true);

    }//GEN-LAST:event_btnCrudItensActionPerformed

    private void btnCrudIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudIngredienteActionPerformed
        JifIngredientesListagem ing = new JifIngredientesListagem();
        jdpPrincipal.add(ing);
        ing.setTitle("Cadastro de ingredientes");
        ing.pack();
        ing.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ing.setVisible(true);

    }//GEN-LAST:event_btnCrudIngredienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrudAgenda;
    private javax.swing.JButton btnCrudCliente;
    private javax.swing.JButton btnCrudIngrediente;
    private javax.swing.JButton btnCrudItens;
    private javax.swing.JButton btnCrudTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JDesktopPane jdpPrincipal;
    // End of variables declaration//GEN-END:variables
}
