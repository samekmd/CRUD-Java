package dao;

import connection.ConnectionDB;
import modelo.Aluno;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//Dupla Samuel Machado e Matheus Santos

public class AlunoDAO {

    private Connection connection;
    private String coluna_sql;
    List<String> results = new ArrayList<>();

    JOptionPane mensagem = new JOptionPane();

    public String getColuna_sql() {
        return coluna_sql;
    }

    public void setColuna_sql(String coluna_sql) {
        this.coluna_sql = coluna_sql;
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
       String sql = "DELETE FROM registro WHERE cpf=" + cpf;
       try{
           PreparedStatement stmt = connection.prepareStatement(sql);
           int linhas_afetadas = stmt.executeUpdate();
           if (linhas_afetadas > 0) {
               mensagem.showMessageDialog(null, "Aluno excluído com sucesso");
           }
        }catch (SQLException e){
           mensagem.showMessageDialog(null, "Não foi possível excluir o aluno");


       }


    }


    public void atualizar_String(String cpf,  String atributo_sql) {
        String sql = "UPDATE registro SET *=? WHERE cpf=?";
        if (getColuna_sql().equals("nome")) {
            sql = "UPDATE registro SET nome=? WHERE cpf=?";
        } else if (getColuna_sql().equals("data de nascimento")) {
            sql = "UPDATE registro SET data_nascimento=? WHERE cpf=?";
        } else if (getColuna_sql().equals("peso")) {
            sql = "UPDATE registro SET peso=? WHERE cpf=?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(atributo_sql));
                stmt.setString(2, cpf);
                int linhas_afetadas = stmt.executeUpdate();
                if (linhas_afetadas > 0) {
                    mensagem.showMessageDialog(null, "Registro atualizado com sucesso");
                } else {
                    mensagem.showMessageDialog(null, "Nenhum registro foi feito");
                }
            } catch (SQLException e) {

                mensagem.showMessageDialog(null, "Erro ao atualizar");
            }
        }else if(getColuna_sql().equals("altura")){
            sql = "UPDATE registro SET altura=? WHERE cpf=?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(atributo_sql));
                stmt.setString(2, cpf);
                int linhas_afetadas = stmt.executeUpdate();
                if (linhas_afetadas > 0) {
                    mensagem.showMessageDialog(null, "Registro atualizado com sucesso");
                } else {
                    mensagem.showMessageDialog(null, "Nenhum registro foi feito");
                }
            } catch (SQLException e) {

                mensagem.showMessageDialog(null, "Erro ao atualizar");
            }
        }
        try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, atributo_sql);
                stmt.setString(2, cpf);
                int linhas_afetadas = stmt.executeUpdate();
                if (linhas_afetadas > 0) {
                    mensagem.showMessageDialog(null, "Registro atualizado com sucesso");
                } else {
                    mensagem.showMessageDialog(null, "Nenhum registro foi feito");
                }
            } catch (SQLException e) {

                mensagem.showMessageDialog(null, "Erro ao atualizar");
            }
        }












    public List<String> consultar(String cpf){
        String sql = "SELECT * FROM registro WHERE cpf=" + cpf;
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columCount = metaData.getColumnCount();

            while(rs.next()){
                StringBuilder row = new StringBuilder();
                for (int i = 1; i <= columCount; i++) {
                    if (i == 1) {
                        row.append("<html><p> Cpf: ");
                    }else if(i == 2){
                        row.append("</p> <br> <p> Nome: ");
                    }else if(i == 3){
                        row.append("</p> <br> <p>Data de nascimento: ");
                    } else if (i == 4) {
                        row.append("</p> <br> <p>Peso: ");
                    }else if(i == 5){
                        row.append("kg" + "</p> <br> Altura (cm): ");
                    }else{
                        row.append(  "</html>"  );
                    }
                    String columnValue = rs.getString(i);
                    row.append(columnValue);
                }
                results.add(row.toString());

            }
            rs.close();
            stmt.close();

        }catch (SQLException e){
          new RuntimeException(e);
        }
        return results;
    }


}
