package view;

import connection.ConnectionFactory;
import controller.AgendamentoController;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.AgendamentoModel;

public class JifEditarAgendamento extends javax.swing.JInternalFrame {
    
    private AgendamentoController agendamentoController = new AgendamentoController();
    public AgendamentoController getAgendamentoController() { return agendamentoController; }
    public void setAgendamentoController(AgendamentoController agendamentoController) { this.agendamentoController = agendamentoController; }
    
    private ConnectionFactory cf = new ConnectionFactory();
    private Connection conexao;
    
    
    private AgendamentoModel agendamentoModel = new AgendamentoModel();
    public AgendamentoModel getAgendamentoModel() { return agendamentoModel; }
    public void setAgendamentoModel(AgendamentoModel agendamentoModel) { this.agendamentoModel = agendamentoModel; }
    
    public JifEditarAgendamento() {initComponents();}
    public JifEditarAgendamento(AgendamentoController agendamentoController, AgendamentoModel agendamentoModel) {
        
        initComponents();
        this.setAgendamentoController(agendamentoController);
        this.setAgendamentoModel(agendamentoModel);
        
        
        // transforma a data de dd/mm/AAAA para AAAA-mm-dd
        String dataFormatada = agendamentoModel.getDataAg().toString();
        String[] partes = dataFormatada.split("-");
        dataFormatada = partes[2] + "/" + partes[1] + "/" + partes[0];

        // limpa o conteúdo do JComboBox
        comboCli.setModel(new DefaultComboBoxModel<>());
        
        // linha que será selecionada após o carregamento e o contador de linhas da JComboBox
        int linhaAserSelecionada = -1, contadorDeLinhas = -1;
        
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
                contadorDeLinhas++;
                
                // se o codigo do cliente do registro atual == codigo do cliente do agendamento,
                // entao marca essa linha para ser a linha SELECIONADA no JComboBox
                if ( agendamentoModel.getCodCli() == Integer.parseInt(rsC.getString("cod_cli")) ) linhaAserSelecionada = contadorDeLinhas;
                
            }
            
            // fecha a conexao
            conexao.close();
            
        } catch (Exception e) {
        
            // nao faz nd se n tem registros...
        
        } //FIMcliente
        
        // Seleciona a linha do cliente dono do agendamento
        if ( linhaAserSelecionada > -1 ) comboCli.setSelectedIndex(linhaAserSelecionada);
       
        // usa as mesmas vars de linha para selecionar o tema correto
        linhaAserSelecionada = contadorDeLinhas = -1;
        
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
                contadorDeLinhas++;
                
                // se o codigo do tema do registro atual == codigo do tema do agendamento,
                // entao marca essa linha para ser a linha SELECIONADA no JComboBox
                if ( agendamentoModel.getCodTemaAg() == Integer.parseInt(rsT.getString("cod_t")) ) {
                    linhaAserSelecionada = contadorDeLinhas;
                    System.out.println("Linha do tema: " + contadorDeLinhas);
                }
                
            }

            // fecha a conexao
            conexao.close();
            
        } catch (Exception e) {
        
            // nao faz nd se n tem registros...
        
        }
        
        // Seleciona a linha do cliente dono do agendamento
        if ( linhaAserSelecionada > -1 ) comboTema.setSelectedIndex(linhaAserSelecionada);

        this.txtDataAg.setText(dataFormatada);
        this.txtHoraAg.setText(String.valueOf(agendamentoModel.getHoraAg()));
        this.txtNpAg.setText(String.valueOf(agendamentoModel.getnPessoas()));

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
        txtDataAg = new javax.swing.JFormattedTextField();
        txtHoraAg = new javax.swing.JFormattedTextField();
        txtNpAg = new javax.swing.JTextField();
        btnCancelarAg = new javax.swing.JButton();
        btnAtualizaAg = new javax.swing.JButton();
        comboCli = new javax.swing.JComboBox<>();
        comboTema = new javax.swing.JComboBox<>();

        setTitle("Agendamento");

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

        btnAtualizaAg.setText("Atualizar");
        btnAtualizaAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaAgActionPerformed(evt);
            }
        });

        comboCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDataAg)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHoraAg, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNpAg)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboCli, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(comboTema, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(btnCancelarAg)
                .addGap(18, 18, 18)
                .addComponent(btnAtualizaAg)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
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
                    .addComponent(btnAtualizaAg)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setBounds(250, 30, 549, 281);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizaAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaAgActionPerformed
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

                // transforma a data de dd/mm/AAAA para AAAA-mm-dd
                String dataFormatada = String.valueOf(this.txtDataAg.getText());
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

                agendamentoModel.setDataAg(Date.valueOf(dataFormatada));
                agendamentoModel.setHoraAg(Time.valueOf(horaDigitada));
                agendamentoModel.setCodCli(codCli);
                agendamentoModel.setCodTemaAg(codTema);
                agendamentoModel.setnPessoas(Integer.parseInt(this.txtNpAg.getText()));

                if (this.agendamentoController.atualizarAgenda(agendamentoModel)== true) {
                    this.setVisible(false);
                }
        }
    }//GEN-LAST:event_btnAtualizaAgActionPerformed

    private void btnCancelarAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAgActionPerformed
         this.setVisible(false);
    }//GEN-LAST:event_btnCancelarAgActionPerformed

    private void comboCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizaAg;
    private javax.swing.JButton btnCancelarAg;
    private javax.swing.JComboBox<String> comboCli;
    private javax.swing.JComboBox<String> comboTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField txtDataAg;
    private javax.swing.JFormattedTextField txtHoraAg;
    private javax.swing.JTextField txtNpAg;
    // End of variables declaration//GEN-END:variables
}
