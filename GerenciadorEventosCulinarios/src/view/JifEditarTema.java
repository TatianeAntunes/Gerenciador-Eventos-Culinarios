package view;

import controller.TemaController;
import model.TemaModel;

public class JifEditarTema extends javax.swing.JInternalFrame {
    
    private TemaController temaController = null;
    public TemaController getTemaController() { return temaController; }
    public void setTemaController(TemaController temaController) { this.temaController = temaController; }
    
    private TemaModel temaModel = null;
    public TemaModel getTemaModel() { return temaModel; }
    public void setTemaModel(TemaModel temaModel) { this.temaModel = temaModel; }
    
    public JifEditarTema() {initComponents();}
    public JifEditarTema(TemaController temaController, TemaModel temaModel) {
        initComponents();
        this.setTemaController(temaController);
        this.setTemaModel(temaModel);
        this.txtNomeTema.setText(temaModel.getNomeTema());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCancelarAg = new javax.swing.JButton();
        btnCadastrarTema = new javax.swing.JButton();
        txtNomeTema = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Nome:");

        btnCancelarAg.setText("Cancelar");
        btnCancelarAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAgActionPerformed(evt);
            }
        });

        btnCadastrarTema.setText("Atualizar");
        btnCadastrarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarTemaActionPerformed(evt);
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
                        .addGap(0, 309, Short.MAX_VALUE)
                        .addComponent(btnCancelarAg)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrarTema))
                    .addComponent(txtNomeTema))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarTema)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(250, 30, 550, 194);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarTemaActionPerformed
        temaModel.setNomeTema(this.txtNomeTema.getText());
        if (this.temaController.atualizarTema(temaModel) == true) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnCadastrarTemaActionPerformed

    private void btnCancelarAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_btnCancelarAgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarTema;
    private javax.swing.JButton btnCancelarAg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNomeTema;
    // End of variables declaration//GEN-END:variables
}
