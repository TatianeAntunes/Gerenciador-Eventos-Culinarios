package view;

import controller.IngredienteController;
import javax.swing.JOptionPane;
import model.IngredienteModel;

public class JifEditarIngrediente extends javax.swing.JInternalFrame {
    
    private IngredienteController ingredienteController = new IngredienteController();
    public IngredienteController getIngredienteController() { return ingredienteController; }
    public void setIngredienteController(IngredienteController ingredienteController) { this.ingredienteController = ingredienteController; }
    
    private IngredienteModel ingredienteModel = new IngredienteModel();
    public IngredienteModel getIngredienteModel() { return ingredienteModel; }
    public void setIngredienteModel(IngredienteModel ingredienteModel) { this.ingredienteModel = ingredienteModel; }
    
    public JifEditarIngrediente() {initComponents();}
    
    public JifEditarIngrediente(IngredienteController ingredienteController, IngredienteModel ingredienteModel) {
        initComponents();
        this.setIngredienteController(ingredienteController);
        this.setIngredienteModel(ingredienteModel);
        
        // transforma o valor de vv,vv para vv.vv
        String valorFormatada = new Double(ingredienteModel.getValorIngred()).toString().replace(".", ",");
        
        this.txtNome.setText(ingredienteModel.getNomeIngred());
        this.txtUnMed.setText(ingredienteModel.getUnMedIngred());
        this.txtValor.setText(valorFormatada);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUnMed = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Nome:");

        jLabel3.setText("Unidade de medida:");

        jLabel4.setText("Valor(R$):");

        txtUnMed.setToolTipText("");

        txtValor.setToolTipText("Formato: v v,v v");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        txtNome.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtValor)
                            .addComponent(txtUnMed, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNome)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 302, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(txtUnMed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtualizar)
                    .addComponent(btnCancelar))
                .addGap(35, 35, 35))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(250, 30, 543, 221);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        if (this.txtNome.getText().equals("")|| this.txtUnMed.getText().equals("") || this.txtValor.getText().equals("")) {
            
           JOptionPane.showMessageDialog(this, "Preenchimento incorreto!\n Verifique o preenchimento dos campos");
           
        }else {
                 // pega o valor formatado
                String valorFormatado = this.txtValor.getText();
                 
                // existe o PONTO no texto?
                if( valorFormatado.indexOf(".") >= 0 ){
                    // erro
                    JOptionPane.showMessageDialog(this, "Preenchimento incorreto!\nPreencha o campo VALOR no formato bresileiro: vv,vv ");
                    // interrompe aqui o codigo
                    return;
                }
                
                // quebra o texto por VIRGULA
                String[] partes = valorFormatado.split(",");
                
                // se esta no formato certo, entao partes.length tem q ser =2
                if (partes.length!=2){
                    // erro
                    JOptionPane.showMessageDialog(this, "Preenchimento incorreto!\nPreencha o campo VALOR no formato bresileiro: vv,vv ");
                    // interrompe aqui o codigo
                    return;
                }
                
                valorFormatado = partes[0] + "." + partes[1];
                
                ingredienteModel.setNomeIngred(this.txtNome.getText());
                ingredienteModel.setUnMedIngred(this.txtUnMed.getText());
                ingredienteModel.setValorIngred(Double.parseDouble(valorFormatado));

                if (this.ingredienteController.atualizarIngred(ingredienteModel)== true) {
                    this.setVisible(false);
                }
        }        
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUnMed;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
