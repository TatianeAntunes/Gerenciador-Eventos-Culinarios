package view;

import connection.ConnectionFactory;
import controller.CardapioPadraoController;
import controller.ItemController;
import controller.ItensAgendController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import model.AgendamentoModel;
import model.ClienteModel;
import model.ItemModel;
import model.TemaModel;

public class JifItensAgendamento extends javax.swing.JInternalFrame {

    private CardapioPadraoController cardapioPadraoController;
    private ItemController itemC = new ItemController();
    private AgendamentoModel agModel;
    private ClienteModel clienteModel;
    private ItensAgendController itensAgendController;
    
    private ConnectionFactory cf = new ConnectionFactory();
    private Connection conexao;
       
    
    CellEditorListener changeNotification = new CellEditorListener() { 
        @Override
        public void editingCanceled(ChangeEvent e) { updateTotal(); }
        @Override
        public void editingStopped(ChangeEvent e) { updateTotal(); }
    };
     
    private void updateTotal() {
       
        // cria a conexao
        conexao = cf.getConnection();
        
        // busca os dados que queremos exibir
        String query = 
        "SELECT SUM(iag.qtd_itens * (SELECT SUM( ii.qtd_ing * i.valor ) AS total\n" +
        "FROM ingred_item ii, ingrediente i, item it WHERE ii.cod_ing = i.cod_ing\n" +
        "AND ii.cod_item = it.cod_i AND it.cod_i = iag.cod_item)) as total_dos_itens_do_ag\n" +
        "FROM itens_ag iag WHERE iag.cod_ag="+ agModel.getCodAg();
        
        // tem que tratar as exceções lançadas pela classe ConnectionFactory
        try {
            
            // realiza a busca
            ResultSet rsC = conexao.createStatement().executeQuery(query);
            
            // para cada um dos registros encontrados (só vai ter UM registro aqui)
            if(rsC.next()) {
                DecimalFormat df = new DecimalFormat("#.00");
                double v = Double.parseDouble(rsC.getString("total_dos_itens_do_ag"));
                this.txtTotalItem.setText(df.format(v));
            } else {
                this.txtTotalItem.setText("0,00");
            }
            
            // fecha a conexao
            conexao.close();
            
        } catch (Exception e) {// nao faz nd se n tem registros...
       }
    }
                                                                                                                                 
    public JifItensAgendamento(AgendamentoModel agModel, TemaModel temaModel, ClienteModel clienteModel){
        
        initComponents();
        
        this.agModel = agModel;
        this.clienteModel = clienteModel;

        cardapioPadraoController = new CardapioPadraoController(temaModel);
        this.tabelaItens.setModel(cardapioPadraoController.getTableModel());
        
        this.tabelaItensDoCardapio.getDefaultEditor(String.class).addCellEditorListener(changeNotification);
        
        itensAgendController = new ItensAgendController(agModel);
        this.tabelaItensDoCardapio.setModel(itensAgendController.getTableModel());

        this.txtNomeTema.setText( this.clienteModel.getNomeCli() );
        
        updateTotal();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DesktopPane = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeTema = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaItensDoCardapio = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSelecIngred = new javax.swing.JButton();
        txtTotalItem = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(930, 465));

        DesktopPane.setBackground(java.awt.SystemColor.controlHighlight);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Você está definindo os itens do agendamento do cliente: ");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setPreferredSize(new java.awt.Dimension(890, 382));

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

        btnRemover.setText(" Remover");
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAdicionar))
                        .addGap(9, 9, 9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)
                        .addGap(327, 327, 327))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemover)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        btnSelecIngred.setText("Definir ingredientes do item");
        btnSelecIngred.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecIngredActionPerformed(evt);
            }
        });

        txtTotalItem.setBackground(new java.awt.Color(240, 240, 240));
        txtTotalItem.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txtTotalItem.setEnabled(false);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar itens do agendamento");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Custo total dos itens:");

        DesktopPane.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(btnSelecIngred, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(txtTotalItem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(btnCancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(btnSalvar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        DesktopPane.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DesktopPaneLayout.createSequentialGroup()
                        .addComponent(btnSelecIngred)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE))
                .addContainerGap())
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecIngred)
                    .addComponent(txtTotalItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPane)
        );

        setBounds(0, 1, 1030, 510);
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
        String nomeIng = tabelaItens.getValueAt(linha, 1).toString();
        
        // deve adicionar o item? inicialmente sim.... soh nao vai adicionar, se ele ja existir na outra tabela
        boolean adicionar = true;
        
        // a outra tabela tem itens?
        if (tabelaItensDoCardapio.getModel() != null && tabelaItensDoCardapio.getModel().getRowCount() > 0) {
            for(int c = 0; c < tabelaItensDoCardapio.getRowCount(); c++) {
                if ( Integer.parseInt(tabelaItensDoCardapio.getValueAt(c, 0).toString()) == codI)
                {
                    adicionar = false;
                    break;
                }
            }
        }
        
        // se ainda n tem o item, entao adiciona
        if (adicionar == true) {
            
            DefaultTableModel model = (DefaultTableModel) tabelaItensDoCardapio.getModel();
            model.addRow(new Object[]{ codI, nomeIng, 1 });
            
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

        itensAgendController.atualizarItens(dados, this.agModel);
        updateTotal();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        
        // info da linha selecionada
        DefaultTableModel model = (DefaultTableModel) tabelaItensDoCardapio.getModel();
        model.removeRow( tabelaItensDoCardapio.getSelectedRow() );
        updateTotal();
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnSelecIngredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecIngredActionPerformed
                
        // evita abrir os ingredientes padrão sem um item selecionado (o que seria um erro)
        if ( tabelaItensDoCardapio.getSelectedRow() < 0 ) {
            JOptionPane.showMessageDialog(null, "Selecione um item para editar seus ingredientes.");
            return;
        }
        
        // cria um modelo com os dados do item selecionado
        ItemModel itemSelecionado = new ItemModel();
        itemSelecionado.setCodItem( Integer.parseInt( tabelaItensDoCardapio.getValueAt(tabelaItensDoCardapio.getSelectedRow(), 0 ).toString()) );
        itemSelecionado.setNomeItem( tabelaItensDoCardapio.getValueAt(tabelaItensDoCardapio.getSelectedRow(), 1 ).toString() );
        
        // abre o itens do ag passando para ele o modelo do item selecionado
        JifIngredienteAgListagem ingAgSelec = new JifIngredienteAgListagem(itemSelecionado);
        ingAgSelec.setTitle("Ingredientes do item");
        ingAgSelec.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DesktopPane.add(ingAgSelec);
        ingAgSelec.setVisible(true);


    }//GEN-LAST:event_btnSelecIngredActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSelecIngred;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTable tabelaItensDoCardapio;
    private javax.swing.JTextField txtNomeTema;
    private javax.swing.JTextField txtTotalItem;
    // End of variables declaration//GEN-END:variables
}
