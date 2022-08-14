package view;

import controller.ClienteController;
import model.ClienteModel;

public class JifEditarCliente extends javax.swing.JInternalFrame {
    
    private ClienteController clienteController = null;
    public ClienteController getClienteController() { return clienteController; }
    public void setClienteController(ClienteController clienteController) { this.clienteController = clienteController; }
    
    private ClienteModel clienteModel = null;
    public ClienteModel getClienteModel() { return clienteModel; }
    public void setClienteModel(ClienteModel clienteModel) { this.clienteModel = clienteModel; }
    
    public JifEditarCliente() {initComponents();}
    public JifEditarCliente(ClienteController clienteController, ClienteModel clienteModel) {
        initComponents();
        this.setClienteController(clienteController);
        this.setClienteModel(clienteModel);
        this.txtNomeCli.setText(clienteModel.getNomeCli());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelarAg = new javax.swing.JButton();
        btnAtualizarCli = new javax.swing.JButton();
        txtNomeCli = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Nome completo ou razão social:");

        btnCancelarAg.setText("Cancelar");
        btnCancelarAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAgActionPerformed(evt);
            }
        });

        btnAtualizarCli.setText("Atualizar");
        btnAtualizarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 299, Short.MAX_VALUE)
                        .addComponent(btnCancelarAg)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizarCli))
                    .addComponent(txtNomeCli))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtualizarCli)
                    .addComponent(btnCancelarAg))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        setBounds(250, 30, 540, 214);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarCliActionPerformed
         clienteModel.setNomeCli(this.txtNomeCli.getText());
        if (this.clienteController.atualizarCliente(clienteModel) == true) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnAtualizarCliActionPerformed

    private void btnCancelarAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_btnCancelarAgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarCli;
    private javax.swing.JButton btnCancelarAg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNomeCli;
    // End of variables declaration//GEN-END:variables
}
