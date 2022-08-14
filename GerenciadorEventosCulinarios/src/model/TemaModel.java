package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

public class TemaModel {
    private int codTema;
    private String nomeTema;

    public int getCodTema() {
        return codTema;
    }

    public void setCodTema(int codTema) {
        this.codTema = codTema;
    }

    public String getNomeTema() {
        return nomeTema;
    }

    public void setNomeTema(String nomeTema) {
        this.nomeTema = nomeTema;
    }
    // fabrica de conexao
    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    // conexao propriamente dita
    private Connection connection = null;
    
     // construtor padrao
    public TemaModel() {}

    // construtor com parametros
    public TemaModel(int codTema, String nomeTema) {
        this.setNomeTema(nomeTema);
        this.setCodTema(codTema);
    }

    // remover cliente
    public void removerTema(int codTema) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "DELETE FROM tema WHERE cod_t=" + codTema + "";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
  // novo tema
    public void novoTema(TemaModel tema) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "INSERT INTO tema (nome_t) VALUES ('" + tema.getNomeTema() + "')";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // atualiza cliente
    public void atualizarTema(TemaModel tema) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();
        
        // comando a ser executado
        String query = "UPDATE tema SET nome_t='" + tema.getNomeTema() + "' WHERE cod_t='" + tema.getCodTema() + "'";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();
    }
    
    public DefaultTableModel getDefaultTableModel() throws SQLException {

        // estabelece a conexao
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "SELECT * FROM tema ORDER BY nome_t ASC";

        // conjunto de resultados que armazenará os resultados
        ResultSet rs = connection.createStatement().executeQuery(query);// executa o comando contido na var query

        // armazena informações sobre as colunas (nomes, etc.)
        ResultSetMetaData campos = rs.getMetaData();

        // um contador para ajudar com as colunas e com os valores de colunas
        int c = 1;
        
        // DEFININDO O CABECALHO DA TABELA VIRTUAL manualmente (permite dar o nome que quiser para as colunas)
        LinkedList<String> tableHeader = new LinkedList<>();
        tableHeader.add("Código");
        tableHeader.add("Nome tema");
        
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
