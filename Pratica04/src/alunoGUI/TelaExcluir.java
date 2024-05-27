package alunoGUI;

import dao.AlunoDAO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaExcluir extends JFrame {

    //Excluir
    //Label
    private JLabel label_excluir = new JLabel("<html><p>Insira o cpf do aluno</p>  <p> a ser excluído</p></html>");

    //Campos de texto
    private JTextField inserir_excluir = new JTextField();

    //Botão
    private JButton botao_excluir = new JButton("OK");


    private JOptionPane mensagens = new JOptionPane();



    public TelaExcluir(){
        initComponents();
    }

    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Excluir aluno");
        setSize(800,600); //the half  -> width:683 height:384
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        //Excluir

        //JTextFields + Labels
        label_excluir.setBounds(200,50,200,50);
        add(label_excluir);
        inserir_excluir.setBounds(250,100,200,20);
        inserir_excluir.setBorder(new LineBorder(Color.black));
        add(inserir_excluir);

        //Botão Excluir
        botao_excluir.setBounds(300,300,100,20);
        botao_excluir.addActionListener(this::excluir);
        add(botao_excluir);




    }



    //Ação do botão Excluir
    private void excluir(ActionEvent actionEvent) {
        AlunoDAO dao = new AlunoDAO();
        if (dao.cpfExistente(inserir_excluir.getText())){
            dao.excluir(inserir_excluir.getText());
        }
    }

    public static void main(String[] args) {
        new TelaExcluir();
    }


}
