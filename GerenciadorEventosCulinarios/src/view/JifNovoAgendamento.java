package view;

import connection.ConnectionFactory;
import controller.AgendamentoController;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class JifNovoAgendamento extends javax.swing.JInternalFrame {
    
    private AgendamentoController agendamentoController = new AgendamentoController();
    public AgendamentoController getAgendamentoController() { return agendamentoController; }
    public void setAgendamentoController(AgendamentoController agendamentoController) { this.agendamentoController = agendamentoController; }
    
    private ConnectionFactory cf = new ConnectionFactory();
    private Connection conexao;
    
    public JifNovoAgendamento() {initComponents();}
    public JifNovoAgendamento(AgendamentoController agendamentoController) {
        initComponents();
        
        this.setAgendamentoController(agendamentoController);
        
        // limpa o conteúdo do JComboBox
        comboCli.setModel(new DefaultComboBoxModel<>());
        
        // cria a conexao
        conexao = cf.getConnection();
        
        // busca os dados que queremos exibir
        String queryC = "SELECT cod_cli, nome_cli FROM cliente";
        
        // tem que tratar as exceções lançadas pela classe ConnectionFactory
        try {
            
            // realiza a busca
            ResultSet rsC = conexao.createStatement().executeQuery(queryC);
            
            // para cada um dos registros encontrados
            while(rsC.next()) {
                
                // adiciona na JComboBox
                comboCli.addItem(rsC.getString("cod_cli") + " - " + rsC.getString("nome_cli"));
                
            }
            
            // fecha a conexao
            conexao.close();
            
        } catch (Exception e) {
        
            // nao faz nd se n tem registros...
        
        }//FIMcliente
       
        // comboTema
        comboTema.setModel(new DefaultComboBoxModel<>());
        
        // cria a conexao
        conexao = cf.getConnection();
        String queryT = "SELECT cod_t, nome_t FROM tema";
        
        try {
            
            // realiza a busca
            ResultSet rsT = conexao.createStatement().executeQuery(queryT);
            
            // para cada um dos registros encontrados
            while(rsT.next()) {
                
                // adiciona na JComboBox
                comboTema.addItem(rsT.getString("cod_t") + " - " + rsT.getString("nome_t"));
                
            }

            // fecha a conexao
            conexao.close();
            
        } catch (Exception e) {
        
            // nao faz nd se n tem registros...
        
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNpAg = new javax.swing.JTextField();
        btnCancelarAg = new javax.swing.JButton();
        btnCadastrarAg = new javax.swing.JButton();
        txtDataAg = new javax.swing.JTextField();
        txtHoraAg = new javax.swing.JTextField();
        comboCli = new javax.swing.JComboBox<>();
        comboTema = new javax.swing.JComboBox<>();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Data:");

        jLabel2.setText("Hora:");

        jLabel3.setText("Nome do cliente:");

        jLabel4.setText("Tema selecionado:");

        jLabel5.setText("Nº de pessoas:");

        btnCancelarAg.setText("Cancelar");
        btnCancelarAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAgActionPerformed(evt);
            }
        });

        btnCadastrarAg.setText("Cadastrar");
        btnCadastrarAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAgActionPerformed(evt);
            }
        });

        txtDataAg.setToolTipText("Formato da data: dd/mm/AAAA");

        txtHoraAg.setToolTipText("Formato: hh:mm");

        comboCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboTema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtDataAg, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtHoraAg, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNpAg)
                            .addComponent(comboCli, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboTema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelarAg)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCadastrarAg)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtDataAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoraAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNpAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCadastrarAg)
                    .addComponent(btnCancelarAg))
                .addGap(6, 6, 6))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(250, 30, 550, 271);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAgActionPerformed
        
        int codCli, codTema, linha;

        // pega o codigo do Cliente
        linha = comboCli.getSelectedIndex();
        String textoDaLinha = comboCli.getItemAt(linha);
        String[] cliente = textoDaLinha.split(" - ");
        codCli = Integer.valueOf(cliente[0]);
       
        // pega o codigo do Tema
        linha = comboTema.getSelectedIndex();
        textoDaLinha = comboTema.getItemAt(linha);
        String[] tema = textoDaLinha.split(" - ");
        codTema = Integer.valueOf(tema[0]);
        
        if (this.txtDataAg.getText().equals("")|| this.txtHoraAg.getText().equals("") || this.txtNpAg.getText().equals("")) {
            
           JOptionPane.showMessageDialog(this, "Preenchimento incorreto!\n Verifique o preenchimento dos campos");
           
        }else {
        
                // transforma data de dd/mm/AAAA para AAAA-mm-dd
                String dataFormatada = this.txtDataAg.getText();
                String[] partes = dataFormatada.split("/");
                dataFormatada = partes[2] + "-" + partes[1] + "-" + partes[0];

                // verifica se a hora digitada é valida
                String horaDigitada = this.txtHoraAg.getText();
                partes = horaDigitada.split(":");
                if (partes.length < 2) {
                    JOptionPane.showMessageDialog(this, "Formato da hora: HH:MM:SS ou HH:MM");
                } else {
                    // verificação da hora
                    if (Integer.valueOf(partes[0]) > 23 || Integer.valueOf(partes[0]) < 0) {
                        JOptionPane.showMessageDialog(this, "Hora fora do intervalo. Horas são entre 0 e 23.");
                        return;
                    }
                    // verificação da hora
                    if (Integer.valueOf(partes[1]) > 59 || Integer.valueOf(partes[1]) < 0) {
                        JOptionPane.showMessageDialog(this, "Minutos fora do intervalo. Minutos são entre 0 e 59.");
                        return;
                    }
                    // se partes.length == 3
                    if (partes.length == 3) {
                        // verifica os segundos
                        if (Integer.valueOf(partes[2]) > 59 || Integer.valueOf(partes[2]) < 0) {
                            JOptionPane.showMessageDialog(this, "Segundos fora do intervalo. Segundos são entre 0 e 59.");
                            return;
                        }
                    } else {
                        horaDigitada += ":00";
                    }
                }

                if (this.agendamentoController.novoAgenda(
                    Date.valueOf(dataFormatada),
                    Time.valueOf(horaDigitada),
                    codCli,
                    codTema,
                    Integer.parseInt(this.txtNpAg.getText())) == true){
                this.setVisible(false);}
        }
    }//GEN-LAST:event_btnCadastrarAgActionPerformed
    
    private void btnCancelarAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_btnCancelarAgActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarAg;
    private javax.swing.JButton btnCancelarAg;
    private javax.swing.JComboBox<String> comboCli;
    private javax.swing.JComboBox<String> comboTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtDataAg;
    private javax.swing.JTextField txtHoraAg;
    private javax.swing.JTextField txtNpAg;
    // End of variables declaration//GEN-END:variables
}
