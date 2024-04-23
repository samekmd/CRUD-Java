package dao;

import connection.ConnectionDB;
import modelo.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public boolean cpfExistente(String cpf) {
        String sql = "SELECT cpf FROM registro WHERE cpf = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            boolean existe = rs.next();
            rs.close();
            stmt.close();
            return existe;
        } catch (SQLException e) {
            // Manipule a exceção de alguma forma apropriada, por exemplo, imprimindo uma mensagem de erro
            e.printStackTrace();
            return false; // Ou lance uma exceção específica para ser tratada no método cadastrar
        }
    }


    public void excluir(String cpf){
        int cpfExcluir =  1;                                                 //dados a serem excluidos
        try {
            String sql = "DELETE FROM registro WHERE id = " + cpfExcluir;    //consulta de exclusão
            Statement statement = connection.createStatement();              //instrução sql
            int linhasAfetadas = statement.executeUpdate(sql);               //executando a exclusao
            if (linhasAfetadas > 0) {
                System.out.println("Dados excluidos com sucesso");
            }else {
                System.out.println("Nenhum dado foi excluido");
            }
            //fechando recursos
            statement.close();
            connection.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void atualizar(){

    }

    public void consultar(String cpf){

    }


}
