package alunoGUI;

import dao.AlunoDAO;
import modelo.Aluno;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Screen  extends JFrame {

    //Criação dos Campos de textos
    private JTextField inserir_cpf = new JTextField();
    private JTextField inserir_nome = new JTextField();
    private JTextField inserir_dataNasc = new JTextField();
    private JTextField inserir_peso = new JTextField();
    private JTextField inserir_altura = new JTextField();


    //Criação dos Labels
    private JLabel cpf = new JLabel("CPF : ");
    private JLabel nome = new JLabel("Nome : ");
    private JLabel  dataNasc = new JLabel("Data de nascimento : ");
    private JLabel peso = new JLabel("Peso : ");
    private JLabel altura = new JLabel("Altura : ");







    //Criação do Botão
    private JButton botao = new JButton("Cadastrar");


    //Criação do JOptionPane
    private JOptionPane mensagens = new JOptionPane();


    public Screen(){
           initScreen();
    }

    private void  initScreen(){
        //Cofigurações básicas
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Aluno");
        setSize(1366,768);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);



        //TextFields + Label

        //CPF
        cpf.setBounds(20,50,75,20);
        add(cpf);
        inserir_cpf.setBounds(70,50,200,20);
        inserir_cpf.setBorder(new LineBorder(Color.black));
        add(inserir_cpf);

        //Nome
        nome.setBounds(20,100,75,20);
        add(nome);
        inserir_nome.setBounds(70, 100,200,20);
        inserir_nome.setBorder(new LineBorder(Color.black));
        add(inserir_nome);


        //Data de nascimento
        dataNasc.setBounds(20,150,150,20);
        add(dataNasc);
        inserir_dataNasc.setBounds(150,150,200,20);
        inserir_dataNasc.setBorder(new LineBorder(Color.black));
        add(inserir_dataNasc);

        //Peso
        peso.setBounds(20,200,75,20);
        add(peso);
        inserir_peso.setBounds(70,200,200,20);
        inserir_peso.setBorder(new LineBorder(Color.black));
        add(inserir_peso);

        //Altura
        altura.setBounds(20,250,75,20);
        add(altura);
        inserir_altura.setBounds(70,250,200,20);
        inserir_altura.setBorder(new LineBorder(Color.black));
        add(inserir_altura);


        //Botão
        botao.setBounds(200,350,100,20);
        add(botao);
        botao.addActionListener(this::cadastrar);





    }

    //Ação do botão
    private void cadastrar(ActionEvent actionEvent) {
        //Atribuição de dados
        Aluno aluno = new Aluno();
        aluno.setCpf(inserir_cpf.getText());
        aluno.setNome(inserir_nome.getText());
        aluno.setDataNasc(inserir_dataNasc.getText());
        aluno.setAltura(Integer.parseInt(inserir_altura.getText()));
        aluno.setPeso(Integer.parseInt(inserir_peso.getText()));

       //Validação de dados
        if (inserir_cpf.getText().isEmpty() ||
                inserir_nome.getText().isEmpty() ||
                inserir_dataNasc.getText().isEmpty() ||
                inserir_altura.getText().isEmpty() ||
                inserir_peso.getText().isEmpty()
        ){

           mensagens.showMessageDialog(null,"Há campos vazios");

        }else{
            AlunoDAO dao = new AlunoDAO();
            dao.adiciona(aluno);
            mensagens.showMessageDialog(null,"Cadastrado com sucesso");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Screen());
    }
}
