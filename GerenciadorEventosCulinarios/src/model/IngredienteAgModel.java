package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;


public class IngredienteAgModel {
    
    // fabrica de conexao
    private final ConnectionFactory conectaBanco= new ConnectionFactory();

    // conexao propriamente dita
    private Connection connection = null;
    
    // construtor padrao
    public IngredienteAgModel() {}

    // atualiza ingrediente do item
    public void atualizarIngred(Map<Integer, Double[]> dados, ItemModel itemModel) throws SQLException {

        int codItem = itemModel.getCodItem();
        
        // conecta ao BD
        this.connection = conectaBanco.getConnection();
        
        // tenta...
        try {
            
            // define a escrita no BD como "NAO AUTOMATICA" (manual)
            this.connection.setAutoCommit(false);
            
            // remove todos os itens atuais do cardapio padrao para este item
            String query = "DELETE FROM ingred_itens_ag WHERE cod_item='" + codItem + "'";
            //cod_item, cod_ing, qtd_ing, valor
            
            // executa o comando acima
            connection.createStatement().execute(query);
            
            //criar um vetor para dados
            // para cada item...
            for(Integer codIng : dados.keySet()) {
                
                // variaveis
                int codIngred      = codIng;
                
                Double[] info = dados.get(codIng);
                Double qtdIng = info[0];
                Double valor = info[1];
                
                // cria o comando
                query = "INSERT INTO ingred_itens_ag (cod_item, cod_ing, qtd_ing, valor) VALUES (" + codItem+ "," + codIngred + "," + qtdIng + "," + valor + ")";

                // executa o comando
                connection.createStatement().execute(query);

            }
            
            // confirma a escrita no BD
            this.connection.commit();

        }
        
        catch(Exception e) {
            
            // cancela todas as operações da transação
            this.connection.rollback();
            
            throw new SQLException(e.getMessage());
           
        }
        
        // fecha a conexao
        this.connection.close();

    }
                                                   
    public DefaultTableModel getDefaultTableModel(ItemModel itemModel) throws SQLException {

        // estabelece a conexao
        this.connection = conectaBanco.getConnection();
              
                String query = "SELECT \n" +
                                "ing.cod_ing, \n" +
                                "ing.nome_ing,\n" +
                                "ii.qtd_ing,\n" +
                                "\n" +
                                "REPLACE(\n" +
                                "    REPLACE(\n" +
                                "      REPLACE(\n" +
                                "        FORMAT(ing.valor, 2)\n" +
                                "      , '.', '@') \n" +
                                "    , ',', '.')\n" +
                                "  , '@', ',') AS valor,\n" +
                                "  \n" +
                                "  REPLACE(\n" +
                                "    REPLACE(\n" +
                                "      REPLACE(\n" +
                                "        CONCAT('', FORMAT((ing.valor * ii.qtd_ing), 2))\n" +
                                "      , '.', '@') \n" +
                                "    , ',', '.')\n" +
                                "  , '@', ',')  AS total \n" +
                                "FROM ingred_item ii\n" +
                                "LEFT JOIN item i ON i.cod_i=ii.cod_item\n" +
                                "LEFT JOIN ingrediente ing ON ing.cod_ing=ii.cod_ing\n" +
                                "WHERE ii.cod_item=" + itemModel.getCodItem();
        System.out.println("Query: \n" + query);
       
                
        // conjunto de resultados que armazenará os resultados
        ResultSet rs;

        // executa o comando contido na var query
        rs = connection.createStatement().executeQuery(query);

        // armazena informações sobre as colunas (nomes, etc.)
        ResultSetMetaData campos = rs.getMetaData();

        // um contador para nos ajudar com as colunas e com os valores de colunas
        int c = 1;

        // DEFININDO O CABECALHO DA TABELA VIRTUAL manualmente (pode dar o nome que quiser para as colunas)
        LinkedList<String> tableHeader = new LinkedList<>();
        tableHeader.add("Código");
        tableHeader.add("Ingrediente");
        tableHeader.add("Qtde");
        tableHeader.add("Valor (R$)");
        tableHeader.add("Total (R$)");
        
        // DEFININDO O CORPO DA TABELA VIRTUAL
        LinkedList<String[]> tableBody = new LinkedList<>();

        // para cada registro encontrado...
        while (rs.next()) {

            // cria um array de Strings que conterá os valores daquele registro
            String[] instancia = new String[campos.getColumnCount()];

            // reinicia o contador de colunas
            c = 1;

            // para cada coluna...
            while (c <= campos.getColumnCount()) instancia[c - 1] = rs.getString(c++);

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


