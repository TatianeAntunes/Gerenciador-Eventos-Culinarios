/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruliano
 */
public class AgendamentoModel {
    private int codAg;
    private Date dataAg;
    private Time horaAg;
    private int codCli;
    private int codTemaAg;
    private int nPessoas;

    public int getCodAg() {
        return codAg;
    }

    public void setCodAg(int codAg) {
        this.codAg = codAg;
    }

    public Date getDataAg() {
        return dataAg;
    }

    public void setDataAg(Date dataAg) {
        this.dataAg = dataAg;
    }

    public Time getHoraAg() {
        return horaAg;
    }

    public void setHoraAg(Time horaAg) {
        this.horaAg = horaAg;
    }

    public int getCodCli() {
        return codCli;
    }

    public void setCodCli(int codCli) {
        this.codCli = codCli;
    }

    public int getCodTemaAg() {
        return codTemaAg;
    }

    public void setCodTemaAg(int codTemaAg) {
        this.codTemaAg = codTemaAg;
    }

    public int getnPessoas() {
        return nPessoas;
    }

    public void setnPessoas(int nPessoas) {
        this.nPessoas = nPessoas;
    }
    
    // fabrica de conexao
    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    // conexao propriamente dita
    private Connection connection = null;
    
    // construtor padrao
    public AgendamentoModel() {}

    // construtor com parametros
    public AgendamentoModel(int codAg, Date dataAg, Time horaAg, int codCli, int codTemaAg, int nPessoas) {
        this.setCodAg(codAg);
        this.setDataAg(dataAg);
        this.setHoraAg(horaAg);
        this.setCodCli(codCli);
        this.setCodTemaAg(codTemaAg);
        this.setnPessoas(nPessoas);
        
    }
    
    // remover cliente                 
    public void removerAgenda(int codAg) throws SQLException {
        
        // conecta ao BD
        this.connection = connectionFactory.getConnection();
        
        // comando a ser executado
        String query = "DELETE FROM agenda WHERE cod_ag=" + codAg + "";
        
        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // novo agenda
    public void novoAgenda(AgendamentoModel agenda) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "INSERT INTO agenda (data_ag, hora_ag, cod_cli, cod_tema_ag, n_pessoas) VALUES ('" + agenda.getDataAg() 
                + "', " + "'" + agenda.getHoraAg() + "', '" + agenda.getCodCli() + "', '" + agenda.getCodTemaAg() 
                + "', '" + agenda.getnPessoas() + "')";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // atualiza cliente
    public void atualizarAgenda(AgendamentoModel agenda) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();
        
        //

        // comando a ser executado
         String query = "UPDATE agenda SET data_ag='" + agenda.getDataAg() + "', hora_ag='" 
                + agenda.getHoraAg()+ "', cod_cli='" + agenda.getCodCli() + "', cod_tema_ag='" + agenda.getCodTemaAg() 
                + "', n_pessoas='" + agenda.getnPessoas() + "'  WHERE cod_ag='" 
                + agenda.getCodAg()+ "'";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }

    public DefaultTableModel getDefaultTableModel() throws SQLException {

        // estabelece a conexao
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        //String query = "SELECT * FROM agenda ORDER BY nome_cli ASC";
        String query = "SELECT\n" +
                    "a.cod_ag,\n" +
                    "DATE_FORMAT(a.data_ag, \"%d/%m/%Y\"),\n" +
                    "a.hora_ag,\n" +
                    "a.cod_cli,\n" +
                    "c.nome_cli,\n" +
                    "a.cod_tema_ag,\n" +
                    "a.n_pessoas as data_ag\n" +
                    "FROM agenda a\n" +
                    "NATURAL JOIN cliente c";
                    
        // conjunto de resultados que armazenará os resultados
        ResultSet rs = connection.createStatement().executeQuery(query);// executa o comando contido na var query
        

        // armazena informações sobre as colunas (cod_ag, etc.)
        ResultSetMetaData campos = rs.getMetaData();

        // um contador para nos ajudar com as colunas e com os valores de colunas
        int c = 1;

        // DEFININDO O CABECALHO DA TABELA VIRTUAL manualmente (permite colocar o nome que quiser para as colunas)
        LinkedList<String> tableHeader = new LinkedList<>();
        tableHeader.add("Código");
        tableHeader.add("Data");
        tableHeader.add("Hora");
        tableHeader.add("Cód. Cliente");
        tableHeader.add("Cliente");
        tableHeader.add("Cód. tema");
        //tableHeader.add("Tema");
        tableHeader.add("Qtd de pessoas");

        // DEFININDO O CORPO DA TABELA VIRTUAL
        LinkedList<String[]> tableBody = new LinkedList<>();

        // para cada registro encontrado...
        while (rs.next()) {

            // cria um array de Strings que conterá os valores daquele registro
            String[] instancia = new String[campos.getColumnCount()];

            // reinicia o contador de colunas
            c = 1;

            // para cada coluna...
            while (c <= campos.getColumnCount()) {
                instancia[c - 1] = rs.getString(c++);
            }

            // agora que a var instancia contem todos os valores das colunas
            // adiciona ela ao corpo da tabela
            tableBody.add(instancia);

        }

        // fecha a conexao
        this.connection.close();

        // agora que tableHeader e tableBody estao preenchidas
        //vou deixar essa tabela virtual disponivel para a interface...
        return DataTableModel.getTableModel(tableBody, tableHeader);

    }

    
}
