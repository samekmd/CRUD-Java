package dao;

import connection.ConnectionDB;
import modelo.Aluno;

import javax.swing.*;
import java.sql.*;

public class AlunoDAO {

    private Connection connection;
    private int indice_sql;

    JOptionPane mensagem = new JOptionPane();

    public int getIndice_sql() {
        return indice_sql;
    }

    public void setIndice_sql(int indice_sql) {
        this.indice_sql = indice_sql;
    }

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


    public void atualizar_String(String cpf,  String parametro_sql)  {



       String sql = "UPDATE registro SET " + parametro_sql + "=?" + "WHERE cpf=" + cpf ;

       try{
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(getIndice_sql(),parametro_sql);
           stmt.execute();
           stmt.close();
           int linhas_afetadas = stmt.executeUpdate();
           if (linhas_afetadas > 0){
               mensagem.showMessageDialog(null,"Registro atualizado com sucesso");
           }else{
                mensagem.showMessageDialog(null,"Nenhum registro foi feito");
           }


       }catch(SQLException e){

           mensagem.showMessageDialog(null,"Erro ao atualizar");



        }








    }

    public void atualizar_Int(String cpf, int mistery){


    }



    public void consultar(String cpf){

    }


}
