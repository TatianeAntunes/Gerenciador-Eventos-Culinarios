package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

public class ClienteModel {

    // nome do cliente
    private String nomeCli;
    public String getNomeCli() { return nomeCli; }
    public void setNomeCli(String nomeCli) { this.nomeCli = nomeCli; }

    // codigo do cliente
    private int codCli;
    public int getCodCli() { return codCli; }
    public void setCodCli(int codCli) { this.codCli = codCli; }

    // fabrica de conexao
    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    // conexao propriamente dita
    private Connection connection = null;
    
    // construtor padrao
    public ClienteModel() {}

    // construtor com parametros
    public ClienteModel(int codCli, String nomeCli) {
        this.setNomeCli(nomeCli);
        this.setCodCli(codCli);
    }

    // remover cliente
    public void removerCliente(int codCli) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "DELETE FROM cliente WHERE cod_cli=" + codCli + "";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // novo cliente
    public void novoCliente(ClienteModel cliente) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "INSERT INTO cliente (nome_cli) VALUES ('" + cliente.getNomeCli() + "')";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // atualiza cliente
    public void atualizarCliente(ClienteModel cliente) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();
        
        //

        // comando a ser executado
        String query = "UPDATE cliente SET nome_cli='" + cliente.getNomeCli() + "' WHERE cod_cli='" + cliente.getCodCli() + "'";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }

    public DefaultTableModel getDefaultTableModel() throws SQLException {

        // estabelece a conexao
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "SELECT * FROM cliente ORDER BY nome_cli ASC";

        // conjunto de resultados que armazenará os resultados
        ResultSet rs;

        // executa o comando contido na var query
        rs = connection.createStatement().executeQuery(query);

        // armazena informações sobre as colunas (nomes, etc.)
        ResultSetMetaData campos = rs.getMetaData();

        // um contador para ajudar com as colunas e com os valores de colunas
        int c = 1;

        // DEFININDO O CABECALHO DA TABELA VIRTUAL automaticamente (usando os nomes das colunas do BD)
        /*
            LinkedList<String> tableHeader = new LinkedList<>();
            // contador de colunas
            c = 1;
            // para cada coluna retornada... adiciona o nome dela na var tableHeader
            while(c <= campos.getColumnCount()) tableHeader.add(campos.getColumnName(c++));
         */
        // DEFININDO O CABECALHO DA TABELA VIRTUAL manualmente (voce poe o nome que quiser para as colunas)
        LinkedList<String> tableHeader = new LinkedList<>();
        tableHeader.add("Código");
        tableHeader.add("Nome Completo");
        
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
