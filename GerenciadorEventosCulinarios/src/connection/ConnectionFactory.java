package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    public Connection getConnection() {
        
        String host = "jdbc:mysql://localhost:3306/eventos_culinario";
        String user = "root";
        String senha = "";

        try {

            Class.forName("com.mysql.jdbc.Driver");
                        
            return DriverManager.getConnection(host, user, senha);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

    }

}
