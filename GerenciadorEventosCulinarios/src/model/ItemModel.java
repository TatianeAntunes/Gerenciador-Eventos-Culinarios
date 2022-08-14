package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;


public class ItemModel {
    private int codItem;
    private String nomeItem;

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }
    
    // fabrica de conexao
    private final ConnectionFactory connectionFactory = new ConnectionFactory();

    // conexao propriamente dita
    private Connection connection = null;
   
    // construtor padrao
    public ItemModel() {}

    // construtor com parametros
    public ItemModel(int codItem, String nomeItem) {
        this.setNomeItem(nomeItem);
        this.setCodItem(codItem);
    }
    
    // remover item
    public void removerItem(int codItem) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "DELETE FROM item WHERE cod_i=" + codItem + "";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // novo item
    public void novoItem(ItemModel item) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "INSERT INTO item (nome_i) VALUES ('" + item.getNomeItem() + "')";

        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();

    }
    
    // atualiza item
    public void atualizarItem(ItemModel item) throws SQLException {

        // conecta ao BD
        this.connection = connectionFactory.getConnection();
        
        // comando a ser executado
        String query = "UPDATE item SET nome_i='" + item.getNomeItem() + "' WHERE cod_i='" + item.getCodItem() + "'";
        
        // executa o comando contido na var query
        connection.createStatement().execute(query);

        // fecha a conexao
        this.connection.close();
    }

    public DefaultTableModel getDefaultTableModel() throws SQLException {

        // estabelece a conexao
        this.connection = connectionFactory.getConnection();

        // comando a ser executado
        String query = "SELECT * FROM item ORDER BY nome_i ASC";

        // conjunto de resultados que armazenará os resultados
        ResultSet rs = connection.createStatement().executeQuery(query);// executa o comando contido na var query

        // armazena informações sobre as colunas (nomes, etc.)
        ResultSetMetaData campos = rs.getMetaData();

        // um contador para nos ajudar com as colunas e com os valores de colunas
        int c = 1;
        
        // DEFININDO O CABECALHO DA TABELA VIRTUAL manualmente (voce poe o nome que quiser para as colunas)
        LinkedList<String> tableHeader = new LinkedList<>();
        tableHeader.add("Código");
        tableHeader.add("Nome");

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
    

