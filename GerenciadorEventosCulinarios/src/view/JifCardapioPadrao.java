package view;

import controller.CardapioPadraoController;
import controller.ItemController;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TemaModel;

public class JifCardapioPadrao extends javax.swing.JInternalFrame {

    private ItemController itemC = new ItemController();
    private TemaModel temaModel;
    
    private CardapioPadraoController cardapioPadraoController;
    public CardapioPadraoController getCardapioPadraoController() { return cardapioPadraoController; }
    public void setCardapioPadraoController(CardapioPadraoController cardapioPadraoController) { this.cardapioPadraoController = cardapioPadraoController; }
    
    public JifCardapioPadrao(TemaModel temaModel){
        initComponents();
        this.temaModel = temaModel;
        this.tabelaItens.setModel(itemC.getTableModel());
        
        cardapioPadraoController = new CardapioPadraoController(temaModel);//novo
        this.tabelaItensDoCardapio.setModel(cardapioPadraoController.getTableModel());
        this.txtNomeTema.setText(this.temaModel.getNomeTema());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaItensDoCardapio = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeTema = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(860, 445));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaItensMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaItens);

        tabelaItensDoCardapio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaItensDoCardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tabelaItensDoCardapioMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaItensDoCardapio);

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

        jLabel2.setText("Itens disponíveis:");

        jLabel3.setText("Itens selecionados:");

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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
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

        jLabel1.setText("Você está definindo os itens do Tema: ");

        txtNomeTema.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtNomeTema.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeTema)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar itens do Cardápio");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

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
                    .addComponent(btnCancelar))
                .addGap(17, 17, 17))
        );

        setBounds(90, 30, 876, 447);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaItensMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaItensMouseReleased
        btnAdicionar.setEnabled( tabelaItens.getSelectedRowCount() > 0 );
    }//GEN-LAST:event_tabelaItensMouseReleased

    private void tabelaItensDoCardapioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaItensDoCardapioMouseReleased
       btnRemover.setEnabled(tabelaItensDoCardapio.getSelectedRowCount() > 0 );
    }//GEN-LAST:event_tabelaItensDoCardapioMouseReleased

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        // info da linha selecionada
        int linha = tabelaItens.getSelectedRow();
        int codI = Integer.parseInt(tabelaItens.getValueAt(linha, 0).toString());
        String nomeItem = tabelaItens.getValueAt(linha, 1).toString();
        
        // deve adicionar o item? inicialmente sim.... soh nao vai adicionar, se ele ja existir na outra tabela
        boolean adicionar = true;

        // a outra tabela tem itens?
        if (tabelaItensDoCardapio.getModel() != null && tabelaItensDoCardapio.getModel().getRowCount() > 0) {
            for(int c = 0; c < tabelaItensDoCardapio.getRowCount(); c++) {
                if ( Integer.parseInt(tabelaItensDoCardapio.getValueAt(c, 0).toString()) == codI) {
                    adicionar = false;
                    break;
                }
            }
        }
        
        // se ainda n tem o item, entao adiciona
        if (adicionar == true) {

            DefaultTableModel model = (DefaultTableModel) tabelaItensDoCardapio.getModel();
            model.addRow(new Object[]{ codI, nomeItem, 1 });

        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        // cria um mapa <Integer, Double> para adicionar o código do item q será incluido juntamente com a qtde
        Map<Integer, Double> dados = new TreeMap<>();

        // verifica se todos os itens possuem qtde indicada no formato de inteiro
        boolean continua = true;
        for(int c = 0; c < tabelaItensDoCardapio.getRowCount(); c++) {

            // se tem qtde <= 0, NAO continua... e da um erro
            if (Integer.parseInt(tabelaItensDoCardapio.getValueAt(c, 2).toString()) <= 0) {
                continua = false;
                break;
            }

            // adiciona no mapa o código do item e a qtde
            dados.put(
                Integer.parseInt(tabelaItensDoCardapio.getValueAt(c, 0).toString()),
                Double.parseDouble(tabelaItensDoCardapio.getValueAt(c, 2).toString())
            );

        }

        // se deu algum erro... ou seja, se continua == false
        if (continua == false) {

            JOptionPane.showMessageDialog(null, "Há itens com quantidade menor ou igual a zero. Favor verificar.");
            return;

        }

        cardapioPadraoController.atualizarItens(dados, this.temaModel);

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
        // info da linha selecionada
        DefaultTableModel model = (DefaultTableModel) tabelaItensDoCardapio.getModel();
        model.removeRow( tabelaItensDoCardapio.getSelectedRow() );

    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTable tabelaItensDoCardapio;
    private javax.swing.JTextField txtNomeTema;
    // End of variables declaration//GEN-END:variables
}
