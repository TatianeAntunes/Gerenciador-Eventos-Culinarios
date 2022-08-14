package view;

import controller.IngredienteController;
import controller.IngredienteAgController;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import model.ItemModel;

public class JifIngredienteAgListagem extends javax.swing.JInternalFrame {

    private IngredienteController ingredC = new IngredienteController();
    private ItemModel itemModel;
    private double totalDoItem = 0;
    
    private IngredienteAgController ingredienteAgController;
    public IngredienteAgController getIngredienteAgController() { return ingredienteAgController; }
    public void setIngredienteAgController(IngredienteAgController ingredienteAgController) { this.ingredienteAgController = ingredienteAgController; }
    
    CellEditorListener changeNotification = new CellEditorListener() { 
        @Override
        public void editingCanceled(ChangeEvent e) { updateTotal(); }
        @Override
        public void editingStopped(ChangeEvent e) { updateTotal(); }
    };
        
    private void updateTotal() {
        DecimalFormat df = new DecimalFormat("#.00");
        this.totalDoItem = 0;
        for(int c = 0; c < tabelaIngredDoCardapio.getRowCount(); c++) {
            double
                qtde = Double.valueOf(tabelaIngredDoCardapio.getValueAt(c, 2).toString().toString().replace(",",".")),
                valor = Double.valueOf(tabelaIngredDoCardapio.getValueAt(c, 3).toString().toString().replace(",","."));
            tabelaIngredDoCardapio.setValueAt(df.format(qtde * valor), c, 4);
            this.totalDoItem += qtde*valor;
        }
         
        this.txtTotalItem.setText("" + df.format(this.totalDoItem));
    }
            
    public JifIngredienteAgListagem(ItemModel itemModel){
        
        initComponents();
        this.itemModel = itemModel;
        this.tabelaIngred.setModel(ingredC.getTableModel());
       
        this.tabelaIngredDoCardapio.getDefaultEditor(String.class).addCellEditorListener(changeNotification);
        
        ingredienteAgController = new IngredienteAgController(itemModel);//novo
        this.tabelaIngredDoCardapio.setModel(ingredienteAgController.getTableModel());
        this.txtNome.setText(this.itemModel.getNomeItem());
        
        updateTotal();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaIngred = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaIngredDoCardapio = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        txtTotalItem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(860, 445));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabelaIngred.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaIngred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaIngredMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaIngred);

        tabelaIngredDoCardapio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaIngredDoCardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaIngredDoCardapioMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaIngredDoCardapio);

        btnAdicionar.setText("Adicionar ->");
        btnAdicionar.setEnabled(false);
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.setEnabled(false);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel2.setText("Ingredientes disponíveis:");

        jLabel3.setText("Ingredientes selecionados:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Você está definindo os ingredientes do item: ");

        txtNome.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNome.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar ingredientes do item");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        txtTotalItem.setEditable(false);

        jLabel4.setText("Preço do item: R$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(txtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(17, 17, 17))
        );

        setBounds(10, 40, 1000, 430);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaIngredMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaIngredMouseReleased
        btnAdicionar.setEnabled( tabelaIngred.getSelectedRowCount() > 0 );
    }//GEN-LAST:event_tabelaIngredMouseReleased

    private void tabelaIngredDoCardapioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaIngredDoCardapioMouseReleased
       btnRemover.setEnabled(tabelaIngredDoCardapio.getSelectedRowCount() > 0 );
    }//GEN-LAST:event_tabelaIngredDoCardapioMouseReleased

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        // info da linha selecionada
        int linha = tabelaIngred.getSelectedRow();
        int codIng = Integer.parseInt(tabelaIngred.getValueAt(linha, 0).toString());
        String nomeIng = tabelaIngred.getValueAt(linha, 1).toString();
        String valorFormatado = (tabelaIngred.getValueAt(linha, 3).toString());
        
        // deve adicionar o item? inicialmente sim.... soh nao vai adicionar, se ele ja existir na outra tabela
        boolean adicionar = true;

        // a outra tabela tem itens?
        if (tabelaIngredDoCardapio.getModel() != null && tabelaIngredDoCardapio.getModel().getRowCount() > 0) {
            for(int c = 0; c < tabelaIngredDoCardapio.getRowCount(); c++) {
                if ( Integer.parseInt(tabelaIngredDoCardapio.getValueAt(c, 0).toString()) == codIng) {
                    adicionar = false;
                    break;
                }
            }
        }
        
        // se ainda n tem o item, entao adiciona
        if (adicionar == true) {

            DefaultTableModel model = (DefaultTableModel) tabelaIngredDoCardapio.getModel();
            model.addRow(new Object[]{ codIng, nomeIng, 10, valorFormatado, });
            updateTotal();

        }
    }//GEN-LAST:event_btnAdicionarActionPerformed
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        // cria um mapa <Integer, Double> para adicionar o código do ingrediente q será incluido juntamente com a qtde
        Map<Integer, Double[]> dados = new TreeMap<>();
        
        // verifica se todos os ingrediente possuem qtde indicada no formato de inteiro
        boolean continua = true;
        for(int c = 0; c < tabelaIngredDoCardapio.getRowCount(); c++) {
           
            //tratamento de erro
            if ( tabelaIngredDoCardapio.getValueAt(c, 2).toString().equals("") ) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos Quantidade desta tabela.");
                return;
            }
            
            // se tem qtde <= 0, NAO continua... e da um erro
            if (Double.parseDouble(tabelaIngredDoCardapio.getValueAt(c, 2).toString()) <= 0) {
                
                continua = false;
                break;
            }
            
            // adiciona no mapa o código do item e a qtde
            dados.put(
                Integer.parseInt(tabelaIngredDoCardapio.getValueAt(c, 0).toString()),
                
                new Double[]{
                    Double.parseDouble(tabelaIngredDoCardapio.getValueAt(c, 2).toString()),
                    Double.parseDouble(tabelaIngredDoCardapio.getValueAt(c, 3).toString().toString().replace(",","."))    
                }
            );
            
        }

        // se deu algum erro... ou seja, se continua == false
        if (continua == false) {

            JOptionPane.showMessageDialog(null, "Há ingredientes com quantidade menor ou igual a zero. Favor verificar.");
            return;

        }
        
        ingredienteAgController.atualizarIngred(dados, this.itemModel);
        
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    //funcionou tudo
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
        // info da linha selecionada
        DefaultTableModel model = (DefaultTableModel) tabelaIngredDoCardapio.getModel();
        model.removeRow( tabelaIngredDoCardapio.getSelectedRow() );
        updateTotal();

    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaIngred;
    private javax.swing.JTable tabelaIngredDoCardapio;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTotalItem;
    // End of variables declaration//GEN-END:variables
}
