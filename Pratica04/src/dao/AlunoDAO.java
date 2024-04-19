package dao;

import connection.ConnectionDB;
import modelo.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlunoDAO {

    private Connection connection;

public AlunoDAO(){
    this.connection = new ConnectionDB().getConnection();
}

public void adiciona(Aluno aluno){
    String sql = "INSERT INTO registro(cpf,nome,data_nascimento,peso,altura) VALUES(?,?,?,?,?)";
    try{
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, aluno.getCpf());
        stmt.setString(2, aluno.getNome());
        stmt.setString(3, aluno.getDataNasc());
        stmt.setInt(4,aluno.getPeso());
        stmt.setInt(5, aluno.getAltura());
        stmt.execute();
        stmt.close();
    }
    catch (SQLException u){
        throw new RuntimeException(u);
    }

    }


}
