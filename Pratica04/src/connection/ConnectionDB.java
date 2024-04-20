package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/aluno","root","fatec");
        }
        catch (SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
