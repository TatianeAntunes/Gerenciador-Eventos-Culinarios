package model;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;


public class ItensAgendModel {
    
    // fabrica de conexao
    private final ConnectionFactory conectaBanco= new ConnectionFactory();

    // conexao propriamente dita
    private Connection connection = null;
    
    // construtor padrao
    public ItensAgendModel() {}

        
    // atualiza cliente
    public void atualizarItens(Map<Integer, Double> dados, AgendamentoModel agendaModel) throws SQLException {

        int codAg = agendaModel.getCodAg();
        
        // conecta ao BD
        this.connection = conectaBanco.getConnection();
        
        // tenta...
        try {
            
            // define a escrita no BD como "NAO AUTOMATICA" (manual)
            this.connection.setAutoCommit(false);
            
            // remove todos os itens atuais do agendamento para este agendamento
            String query = "DELETE FROM itens_ag WHERE cod_ag='" + codAg + "'";
            
            // executa o comando acima
            connection.createStatement().execute(query);

            // para cada item...
            for(Integer codI : dados.keySet()) {
                
                // variaveis
                int codigoItem      = codI;
                double qtdeItens    = dados.get(codI);

                // cria o comando
                query = "INSERT INTO itens_ag (cod_ag, cod_item, qtd_itens) VALUES (" + codAg + "," + codigoItem + "," + qtdeItens + ")";

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

    public DefaultTableModel getDefaultTableModel(AgendamentoModel agModel) throws SQLException {
                                                   
        // estabelece a conexao
        this.connection = conectaBanco.getConnection();
        
        String query =  "SELECT \n" +
                            "i.cod_i,\n" +
                            "i.nome_i,\n" +
                            "qtd_itens\n" +
                        "FROM itens_ag ia\n" +
                        "LEFT JOIN agenda ag ON ag.cod_ag=ia.cod_ag\n" +
                        "LEFT JOIN item i ON i.cod_i=ia.cod_item\n" +
                        "WHERE ia.cod_ag=" + agModel.getCodAg();

        // conjunto de resultados que armazenará os resultados
        ResultSet rs;

        // executa o comando contido na var query
        rs = connection.createStatement().executeQuery(query);

        // armazena informações sobre as colunas (nomes, etc.)
        ResultSetMetaData campos = rs.getMetaData();

        // um contador para nos ajudar com as colunas e com os valores de colunas
        int c = 1;
        
        // DEFININDO O CABECALHO DA TABELA VIRTUAL manualmente (voce poe o nome que quiser para as colunas)
        LinkedList<String> tableHeader = new LinkedList<>();
        tableHeader.add("Código");
        tableHeader.add("Nome");
        tableHeader.add("Qtd");
        
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


