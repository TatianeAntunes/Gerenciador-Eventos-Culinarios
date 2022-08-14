package view;

import controller.AgendamentoController;
import java.sql.Date;
import java.sql.Time;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import model.AgendamentoModel;
import model.ClienteModel;
import model.TemaModel;

public class JifAgendamentoListagem extends javax.swing.JInternalFrame {
    
    AgendamentoController agC = new AgendamentoController();
    
    
    private int codCli;
    private String nomeCli;    
    
    public JifAgendamentoListagem() {
        
        initComponents();
        
        this.btnRemoverAg.setEnabled(false);
        this.btnEditarAg.setEnabled(false);

        // atualiza a tabela tblAgenda
        this.JTable.setModel(agC.getTableModel());
        
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDesktopPane = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable = new javax.swing.JTable();
        barraDeFerramentas = new javax.swing.JToolBar();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        btnNovoAg = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnEditarAg = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnRemoverAg = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnAtualizarLst = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        jSeparator21 = new javax.swing.JToolBar.Separator();
        jSeparator20 = new javax.swing.JToolBar.Separator();
        jSeparator19 = new javax.swing.JToolBar.Separator();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jSeparator17 = new javax.swing.JToolBar.Separator();
        jSeparator15 = new javax.swing.JToolBar.Separator();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jSeparator22 = new javax.swing.JToolBar.Separator();
        jSeparator23 = new javax.swing.JToolBar.Separator();
        jSeparator24 = new javax.swing.JToolBar.Separator();
        jSeparator25 = new javax.swing.JToolBar.Separator();
        jSeparator26 = new javax.swing.JToolBar.Separator();
        jSeparator34 = new javax.swing.JToolBar.Separator();
        jSeparator35 = new javax.swing.JToolBar.Separator();
        jSeparator41 = new javax.swing.JToolBar.Separator();
        jSeparator42 = new javax.swing.JToolBar.Separator();
        jSeparator43 = new javax.swing.JToolBar.Separator();
        jSeparator44 = new javax.swing.JToolBar.Separator();
        jSeparator45 = new javax.swing.JToolBar.Separator();
        jSeparator46 = new javax.swing.JToolBar.Separator();
        jSeparator47 = new javax.swing.JToolBar.Separator();
        jSeparator48 = new javax.swing.JToolBar.Separator();
        jSeparator49 = new javax.swing.JToolBar.Separator();
        jSeparator50 = new javax.swing.JToolBar.Separator();
        jSeparator51 = new javax.swing.JToolBar.Separator();
        jSeparator52 = new javax.swing.JToolBar.Separator();
        jSeparator55 = new javax.swing.JToolBar.Separator();
        jSeparator60 = new javax.swing.JToolBar.Separator();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jSeparator30 = new javax.swing.JToolBar.Separator();
        jSeparator31 = new javax.swing.JToolBar.Separator();
        jSeparator33 = new javax.swing.JToolBar.Separator();
        jSeparator39 = new javax.swing.JToolBar.Separator();
        jSeparator59 = new javax.swing.JToolBar.Separator();
        jSeparator66 = new javax.swing.JToolBar.Separator();
        jSeparator72 = new javax.swing.JToolBar.Separator();
        jSeparator77 = new javax.swing.JToolBar.Separator();
        jSeparator79 = new javax.swing.JToolBar.Separator();
        jSeparator81 = new javax.swing.JToolBar.Separator();
        jSeparator78 = new javax.swing.JToolBar.Separator();
        jSeparator80 = new javax.swing.JToolBar.Separator();
        jSeparator32 = new javax.swing.JToolBar.Separator();
        jSeparator67 = new javax.swing.JToolBar.Separator();
        jSeparator68 = new javax.swing.JToolBar.Separator();
        jSeparator82 = new javax.swing.JToolBar.Separator();
        jSeparator36 = new javax.swing.JToolBar.Separator();
        btnSelecItem = new javax.swing.JButton();

        setClosable(true);
        setTitle("Agendamento de eventos");
        setPreferredSize(new java.awt.Dimension(1038, 600));

        JDesktopPane.setBackground(new java.awt.Color(255, 255, 255));
        JDesktopPane.setMaximumSize(new java.awt.Dimension(984, 449));
        JDesktopPane.setMinimumSize(new java.awt.Dimension(984, 449));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(452, 802));

        JTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable);

        JDesktopPane.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout JDesktopPaneLayout = new javax.swing.GroupLayout(JDesktopPane);
        JDesktopPane.setLayout(JDesktopPaneLayout);
        JDesktopPaneLayout.setHorizontalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JDesktopPaneLayout.setVerticalGroup(
            JDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        barraDeFerramentas.setRollover(true);
        barraDeFerramentas.add(jSeparator8);

        btnNovoAg.setText("Novo");
        btnNovoAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoAgActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(btnNovoAg);
        barraDeFerramentas.add(jSeparator4);

        btnEditarAg.setText("Editar");
        btnEditarAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAgActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(btnEditarAg);
        barraDeFerramentas.add(jSeparator3);

        btnRemoverAg.setText("Remover");
        btnRemoverAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverAgActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(btnRemoverAg);
        barraDeFerramentas.add(jSeparator2);

        btnAtualizarLst.setText("Atualizar lista");
        btnAtualizarLst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarLstActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(btnAtualizarLst);
        barraDeFerramentas.add(jSeparator1);
        barraDeFerramentas.add(jSeparator6);
        barraDeFerramentas.add(jSeparator5);
        barraDeFerramentas.add(jSeparator7);
        barraDeFerramentas.add(jSeparator10);
        barraDeFerramentas.add(jSeparator11);
        barraDeFerramentas.add(jSeparator12);
        barraDeFerramentas.add(jSeparator14);
        barraDeFerramentas.add(jSeparator21);
        barraDeFerramentas.add(jSeparator20);
        barraDeFerramentas.add(jSeparator19);
        barraDeFerramentas.add(jSeparator18);
        barraDeFerramentas.add(jSeparator17);
        barraDeFerramentas.add(jSeparator15);
        barraDeFerramentas.add(jSeparator9);
        barraDeFerramentas.add(jSeparator16);
        barraDeFerramentas.add(jSeparator22);
        barraDeFerramentas.add(jSeparator23);
        barraDeFerramentas.add(jSeparator24);
        barraDeFerramentas.add(jSeparator25);
        barraDeFerramentas.add(jSeparator26);
        barraDeFerramentas.add(jSeparator34);
        barraDeFerramentas.add(jSeparator35);
        barraDeFerramentas.add(jSeparator41);
        barraDeFerramentas.add(jSeparator42);
        barraDeFerramentas.add(jSeparator43);
        barraDeFerramentas.add(jSeparator44);
        barraDeFerramentas.add(jSeparator45);
        barraDeFerramentas.add(jSeparator46);
        barraDeFerramentas.add(jSeparator47);
        barraDeFerramentas.add(jSeparator48);
        barraDeFerramentas.add(jSeparator49);
        barraDeFerramentas.add(jSeparator50);
        barraDeFerramentas.add(jSeparator51);
        barraDeFerramentas.add(jSeparator52);
        barraDeFerramentas.add(jSeparator55);
        barraDeFerramentas.add(jSeparator60);
        barraDeFerramentas.add(jSeparator13);
        barraDeFerramentas.add(jSeparator30);
        barraDeFerramentas.add(jSeparator31);
        barraDeFerramentas.add(jSeparator33);
        barraDeFerramentas.add(jSeparator39);
        barraDeFerramentas.add(jSeparator59);
        barraDeFerramentas.add(jSeparator66);
        barraDeFerramentas.add(jSeparator72);
        barraDeFerramentas.add(jSeparator77);
        barraDeFerramentas.add(jSeparator79);
        barraDeFerramentas.add(jSeparator81);
        barraDeFerramentas.add(jSeparator78);
        barraDeFerramentas.add(jSeparator80);
        barraDeFerramentas.add(jSeparator32);
        barraDeFerramentas.add(jSeparator67);
        barraDeFerramentas.add(jSeparator68);
        barraDeFerramentas.add(jSeparator82);
        barraDeFerramentas.add(jSeparator36);

        btnSelecItem.setText(" Editar itens do agendamento");
        btnSelecItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecItemActionPerformed(evt);
            }
        });
        barraDeFerramentas.add(btnSelecItem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraDeFerramentas, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)
            .addComponent(JDesktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(barraDeFerramentas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(150, 10, 1100, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void JTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableMouseClicked
        this.btnRemoverAg.setEnabled(this.JTable.getSelectedRow() > -1);
        this.btnEditarAg.setEnabled(this.btnRemoverAg.isEnabled());
    }//GEN-LAST:event_JTableMouseClicked

    private void btnSelecItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecItemActionPerformed
        // evita abrir o item sem um agendamento selecionado (o que seria um erro)
        if ( JTable.getSelectedRow() < 0 ) {
            JOptionPane.showMessageDialog(null, "Selecione um agendamento para editar seus itens.");
            return;
        }

        // cria um modelo com os dados do agendamento selecionado
        AgendamentoModel agSelecionado = new AgendamentoModel();
        agSelecionado.setCodAg(Integer.parseInt( JTable.getValueAt(JTable.getSelectedRow(), 0 ).toString()) );

        TemaModel temaM = new TemaModel();
        temaM.setCodTema(Integer.parseInt(JTable.getValueAt(JTable.getSelectedRow(), 5  ).toString()));

        codCli = Integer.parseInt(JTable.getValueAt(JTable.getSelectedRow(), 3).toString());
        nomeCli = JTable.getValueAt(JTable.getSelectedRow(), 4).toString();

        ClienteModel clienteModel = new ClienteModel(codCli, String.valueOf(nomeCli));//Integer.parseInt(partes[0]), partes[1]);

        // abre o cardapio padrao passando para ele o modelo do tema selecionado
        JifItensAgendamento temaSelec = new JifItensAgendamento(agSelecionado, temaM, clienteModel);
        temaSelec.setTitle("Itens do agendamento");
        temaSelec.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDesktopPane.add(temaSelec);
        temaSelec.setVisible(true);
    }//GEN-LAST:event_btnSelecItemActionPerformed

    private void btnAtualizarLstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarLstActionPerformed
        this.JTable.setModel(agC.getTableModel());
        this.btnRemoverAg.setEnabled(false);
        this.btnEditarAg.setEnabled(false);
    }//GEN-LAST:event_btnAtualizarLstActionPerformed

    private void btnRemoverAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverAgActionPerformed
        // tem linha selecionada
        if (JTable.getSelectedRow() >= 0) {

            // confirma remoção
            if (JOptionPane.showConfirmDialog(this, "Deseja realmente remover o registro selecionado?") == 0) {

                // pega os dados selecionados
                int linha   = this.JTable.getSelectedRow();
                int codAg  = Integer.parseInt( (String) this.JTable.getValueAt(linha, 0) ); // 0 pq o codCli ta na coluna 0, ok?

                // se o usuario confirmou, entao remove
                agC.removerAgenda(codAg);

                // atualiza a tabela
                this.JTable.setModel(agC.getTableModel());

                // desabilita os botoes
                this.btnRemoverAg.setEnabled(false);
                this.btnEditarAg.setEnabled(false);

            }
        }
    }//GEN-LAST:event_btnRemoverAgActionPerformed

    private void btnEditarAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAgActionPerformed
        
        if (this.JTable.getSelectedRowCount() == 1) {

            // transforma a data de dd/mm/AAAA para AAAA-mm-dd
            String dataFormatada = this.JTable.getValueAt(this.JTable.getSelectedRow(), 1).toString();

            String[] partes = dataFormatada.split("/");
            dataFormatada = partes[2] + "-" + partes[1] + "-" + partes[0];

            AgendamentoModel agendaM = new AgendamentoModel();
            agendaM.setCodAg(Integer.parseInt((String) this.JTable.getValueAt(this.JTable.getSelectedRow(), 0)));
            agendaM.setDataAg(Date.valueOf(dataFormatada));
            agendaM.setHoraAg(Time.valueOf((String) this.JTable.getValueAt(this.JTable.getSelectedRow(), 2)));
            agendaM.setCodCli(Integer.parseInt((String) this.JTable.getValueAt(this.JTable.getSelectedRow(), 3)));
            agendaM.setCodTemaAg(Integer.parseInt((String) this.JTable.getValueAt(this.JTable.getSelectedRow(), 5)));
            agendaM.setnPessoas(Integer.parseInt((String) this.JTable.getValueAt(this.JTable.getSelectedRow(), 6)));
            
            JifEditarAgendamento editaAg = new JifEditarAgendamento(this.agC, agendaM);
            editaAg.setTitle("Editar agendamento");
            editaAg.pack();
            editaAg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            JDesktopPane.add(editaAg);
            editaAg.setVisible(true);

        }
    }//GEN-LAST:event_btnEditarAgActionPerformed

    private void btnNovoAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoAgActionPerformed
        JifNovoAgendamento novoAg = new JifNovoAgendamento(this.agC);
        novoAg.setTitle("Novo agendamento");
        novoAg.pack();
        novoAg.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JDesktopPane.add(novoAg);
        novoAg.setVisible(true);
    }//GEN-LAST:event_btnNovoAgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JDesktopPane;
    private javax.swing.JTable JTable;
    private javax.swing.JToolBar barraDeFerramentas;
    private javax.swing.JButton btnAtualizarLst;
    private javax.swing.JButton btnEditarAg;
    private javax.swing.JButton btnNovoAg;
    private javax.swing.JButton btnRemoverAg;
    private javax.swing.JButton btnSelecItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JToolBar.Separator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JToolBar.Separator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JToolBar.Separator jSeparator19;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator20;
    private javax.swing.JToolBar.Separator jSeparator21;
    private javax.swing.JToolBar.Separator jSeparator22;
    private javax.swing.JToolBar.Separator jSeparator23;
    private javax.swing.JToolBar.Separator jSeparator24;
    private javax.swing.JToolBar.Separator jSeparator25;
    private javax.swing.JToolBar.Separator jSeparator26;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator30;
    private javax.swing.JToolBar.Separator jSeparator31;
    private javax.swing.JToolBar.Separator jSeparator32;
    private javax.swing.JToolBar.Separator jSeparator33;
    private javax.swing.JToolBar.Separator jSeparator34;
    private javax.swing.JToolBar.Separator jSeparator35;
    private javax.swing.JToolBar.Separator jSeparator36;
    private javax.swing.JToolBar.Separator jSeparator39;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator41;
    private javax.swing.JToolBar.Separator jSeparator42;
    private javax.swing.JToolBar.Separator jSeparator43;
    private javax.swing.JToolBar.Separator jSeparator44;
    private javax.swing.JToolBar.Separator jSeparator45;
    private javax.swing.JToolBar.Separator jSeparator46;
    private javax.swing.JToolBar.Separator jSeparator47;
    private javax.swing.JToolBar.Separator jSeparator48;
    private javax.swing.JToolBar.Separator jSeparator49;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar.Separator jSeparator50;
    private javax.swing.JToolBar.Separator jSeparator51;
    private javax.swing.JToolBar.Separator jSeparator52;
    private javax.swing.JToolBar.Separator jSeparator55;
    private javax.swing.JToolBar.Separator jSeparator59;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator60;
    private javax.swing.JToolBar.Separator jSeparator66;
    private javax.swing.JToolBar.Separator jSeparator67;
    private javax.swing.JToolBar.Separator jSeparator68;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator72;
    private javax.swing.JToolBar.Separator jSeparator77;
    private javax.swing.JToolBar.Separator jSeparator78;
    private javax.swing.JToolBar.Separator jSeparator79;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator80;
    private javax.swing.JToolBar.Separator jSeparator81;
    private javax.swing.JToolBar.Separator jSeparator82;
    private javax.swing.JToolBar.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
