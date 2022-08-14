/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruliano
 */
public class IngredienteModel {
   private int codIngred;
   private String nomeIngred;
   private String unMedIngred;
   private double valorIngred;

    public int getCodIngred() {
        return codIngred;
    }

    public void setCodIngred(int codIngred) {
        this.codIngred = codIngred;
    }

    public String getNomeIngred() {
        return nomeIngred;
    }

    public void setNomeIngred(String nomeIngred) {
        this.nomeIngred = nomeIngred;
    }

    public String getUnMedIngred() {
        return unMedIngred;
    }

    public void setUnMedIngred(String unMedIngred) {
        this.unMedIngred = unMedIngred;
    }

    public double getValorIngred() {
        return valorIngred;
    }

    public void setValorIngred(double valorIngred) {
        this.valorIngred = valorIngred;
    }
   
   // fabrica de conexao
    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    // conexao propriamente dita
    private Connection connection = null;
  
     // construtor padrao
    public IngredienteModel() {}

    // construtor com parametros
    public IngredienteModel(int codIngred, String nomeIngred, String unMedIng, double valor) {
        this.setCodIngred(codIngred);
        this.setNomeIngred(nomeIngred);
        this.setUnMedIngred(unMedIng);
        this.setValorIngred(valor);
                
    }
    // remover item
    public void removerIngred(int codIngred) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "DELETE FROM ingrediente WHERE cod_ing=" + codIngred + "";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // novo tema
    public void novoIngred(IngredienteModel ingred) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "INSERT INTO ingrediente (nome_ing, un_med_ing, valor) VALUES ('" + ingred.getNomeIngred()
                + "', '"+ ingred.getUnMedIngred()+"', '"+ingred.getValorIngred()+"')";
                                                                                                                                                                 
        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // atualiza cliente
    public void atualizarIngred(IngredienteModel ingred) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();
        
        // comando a ser executado
        String query = "UPDATE ingrediente SET nome_ing='" + ingred.getNomeIngred() + "', un_med_ing='" 
                + ingred.getUnMedIngred() + "', valor='" + ingred.getValorIngred() + "' WHERE cod_ing='" 
                + ingred.getCodIngred()+ "'";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();
    }

    public DefaultTableModel getDefaultTableModel() throws SQLException {

        // estabelece a conexao
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "SELECT cod_ing, nome_ing, un_med_ing,\n" +
                        "  REPLACE(\n" +
                        "    REPLACE(\n" +
                        "      REPLACE(\n" +
                        "        FORMAT(valor, 2) # transforma o número em texto '123,456.79'\n" +
                        "      , '.', '@') # troca o ponto por @, pra nao perder '123,456@79'\n" +
                        "    , ',', '.') # troca a vírgura por ponto '123.456@79'\n" +
                        "  , '@', ',') AS valor # e por fim, troca o @ por vírgula '123.456,79'\n" +
                        "  FROM ingrediente ORDER BY nome_ing ASC";
        //System.out.println("Query: \n" + query);
        
        // conjunto de resultados que armazenará os resultados
        ResultSet rs = connection.createStatement().executeQuery(query);// executa o comando contido na var query

        // armazena informações sobre as colunas (nomes, etc.)
        ResultSetMetaData campos = rs.getMetaData();

        // um contador para nos ajudar com as colunas e com os valores de colunas
        int c = 1;
        
        // DEFININDO O CABECALHO DA TABELA VIRTUAL manualmente (voce poe o nome que quiser para as colunas)
        LinkedList<String> tableHeader = new LinkedList<>();
        tableHeader.add("Código");
        tableHeader.add("Ingrediente");
        tableHeader.add("Unidade de medida");
        tableHeader.add("Valor(R$)");
        
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
        // vamos deixar essa tabela virtual disponivel para a interface...
        return DataTableModel.getTableModel(tableBody, tableHeader);
    }
}
