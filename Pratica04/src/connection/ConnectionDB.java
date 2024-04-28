package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Dupla Samuel Machado e Matheus Santos

public class ConnectionDB {
    public Connection getConnection(){
        /*try{
            return DriverManager.getConnection("jdbc:mysql://localhost/aluno","root","fatec");
        }
        catch (SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }*/
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/aluno", "root", "fatec");
        } catch (ClassNotFoundException | SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
