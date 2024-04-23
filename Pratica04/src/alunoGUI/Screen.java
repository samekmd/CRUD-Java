package alunoGUI;

import dao.AlunoDAO;
import modelo.Aluno;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;

public class Screen  extends JFrame {

    //Cadastrar

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
    private JLabel peso = new JLabel("Peso (kg) : ");
    private JLabel altura = new JLabel("Altura (cm) : ");

    //Criação do Botão
    private JButton botao_cadastrar = new JButton("Cadastrar");



    //Excluir
    //Label
    private JLabel label_excluir = new JLabel("<html><p>Insira o cpf do aluno</p>  <p> a ser excluído</p></html>");

    //Campos de texto
    private JTextField inserir_excluir = new JTextField();

    //Botão
    private JButton botao_excluir = new JButton("OK");

    private void excluir(ActionEvent actionEvent) {
        AlunoDAO dao = new AlunoDAO();
        if (dao.cpfExistente(inserir_excluir.getText())){
            dao.excluir(inserir_excluir.getText());
            mensagens.showMessageDialog(null, "CPF excluido com sucesso");
        }else {
            mensagens.showMessageDialog(null,"O CPF digitado nao existe");
        }
    }


    //Atualizar
    //Label
    private JLabel label_atualizar1 = new JLabel("Insira o cpf do aluno: ");
    private JLabel label_atualizar2 = new JLabel("<html><p>Digite o componente a ser atulizado</p> <p>(Digitar tudo em letra minúscula) :</p></html> ");
    private JLabel mistery_label = new JLabel("BOA");

    //Campos de texto
    private JTextField inserir_cpf_atualizar = new JTextField();
    private JTextField mistery_JTextField = new JTextField();
    private JTextField inserir_atualizar = new JTextField();

    //Botões
     private JButton mistery_button = new JButton("OK");
     private JButton botao_atualizar = new JButton("Atualizar");



    //Consultar

    //Labels
    private JLabel label_consulta = new JLabel("Insira o cpf do aluno a ser consultado :");
    private JLabel receiver_label = new JLabel();

    //Campos de Texto
    private JTextField inserir_consulta = new JTextField();

    //Botões
    private JButton botao_consultar = new JButton("Consultar");








    //Criação do JOptionPane
    private JOptionPane mensagens = new JOptionPane();


    public Screen(){
           initScreen();
    }

    private void  initScreen(){
        //Cofigurações básicas
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Aluno");
        setSize(1366,768); //the half  -> width:683 height:384
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        //Cadastro
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
        inserir_peso.setBounds(90,200,200,20);
        inserir_peso.setBorder(new LineBorder(Color.black));
        add(inserir_peso);

        //Altura
        altura.setBounds(20,250,75,20);
        add(altura);
        inserir_altura.setBounds(90,250,200,20);
        inserir_altura.setBorder(new LineBorder(Color.black));
        add(inserir_altura);


        //Botão
        botao_cadastrar.setBounds(200,300,100,20);
        add(botao_cadastrar);
        botao_cadastrar.addActionListener(this::cadastrar);


        //Excluir

        //JTextFields + Labels
        label_excluir.setBounds(720,120,200,80);
        add(label_excluir);
        inserir_excluir.setBounds(800,190,200,20);
        inserir_excluir.setBorder(new LineBorder(Color.black));
        add(inserir_excluir);

        //Botão Excluir
        botao_excluir.setBounds(850,220,100,20);
        add(botao_excluir);


        //Atualizar

        //JTextFields + Labels
        label_atualizar1.setBounds(20,430,200,20);
        add(label_atualizar1);

        label_atualizar2.setBounds(20,470,230,80);
        add(label_atualizar2);

        mistery_label.setBounds(20,570,70,20);
        add(mistery_label);

        inserir_cpf_atualizar.setBounds(150,432,200,20);
        inserir_cpf_atualizar.setBorder(new LineBorder(Color.black));
        add(inserir_cpf_atualizar);

        mistery_JTextField.setBounds(220,512,200,20);
        mistery_JTextField.setBorder(new LineBorder(Color.black));
        add(mistery_JTextField);

        inserir_atualizar.setBounds(70,572,200,20);
        inserir_atualizar.setBorder(new LineBorder(Color.black));
        add(inserir_atualizar);

        //Buttons
        mistery_button.setBounds(430,512,70,20);
        mistery_button.setBorder(new LineBorder(Color.black));
        add(mistery_button);

        botao_atualizar.setBounds(290,572,120,20);
        botao_atualizar.setBorder(new LineBorder(Color.black));
        botao_atualizar.addActionListener(this::atualizar);
        add(botao_atualizar);


        //Consultar

        //JTextFields + Labels
        label_consulta.setBounds(700,400,220,20);
        add(label_consulta);

        receiver_label.setBounds(750,450,400,250);
        receiver_label.setBorder(new LineBorder(Color.black));
        add(receiver_label);

        inserir_consulta.setBounds(930,402,200,20);
        inserir_consulta.setBorder(new LineBorder(Color.black));
        add(inserir_consulta);


        //Botões
        botao_consultar.setBounds(1150,402,70,20);
        botao_consultar.setBorder(new LineBorder(Color.black));
        add(botao_consultar);


















    }

    private void atualizar(ActionEvent actionEvent)  {
        AlunoDAO dao = new AlunoDAO();
        if(dao.cpfExistente(inserir_cpf_atualizar.getText())) {
           if (mistery_JTextField.getText().equals("nome")){
               dao.setIndice_sql(2);
               dao.atualizar_String(inserir_cpf_atualizar.getText(),mistery_JTextField.getText());
               mensagens.showMessageDialog(null,"Certo");


           }else{
               mensagens.showMessageDialog(null,"Errado");
           }
        }


}

    //Ação do botão cadastrar
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
        ) {

            mensagens.showMessageDialog(null, "Há campos vazios");

        } else {
            AlunoDAO dao = new AlunoDAO();
            if (dao.cpfExistente(aluno.getCpf())) {
                mensagens.showMessageDialog(null, "CPF já existente");
            } else {
                dao.adiciona(aluno);
                mensagens.showMessageDialog(null, "Cadastrado com sucesso");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Screen());
    }
}


