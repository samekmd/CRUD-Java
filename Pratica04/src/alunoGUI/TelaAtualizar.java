package alunoGUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class TelaAtualizar  extends JFrame {

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

    public TelaAtualizar(){
        initComponents();
    }

    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Aluno");
        setSize(1366,768); //the half  -> width:683 height:384
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);


        //Atualizar

        //JTextFields + Labels
        label_atualizar1.setBounds(20,430,200,20);
        add(label_atualizar1);

        label_atualizar2.setBounds(20,470,230,80);
        add(label_atualizar2);

        mistery_label.setBounds(20,570,150,20);
        mistery_label.setVisible(false);
        add(mistery_label);

        inserir_cpf_atualizar.setBounds(150,432,200,20);
        inserir_cpf_atualizar.setBorder(new LineBorder(Color.black));
        add(inserir_cpf_atualizar);

        mistery_JTextField.setBounds(220,512,200,20);
        mistery_JTextField.setBorder(new LineBorder(Color.black));
        add(mistery_JTextField);

        inserir_atualizar.setBounds(70,572,200,20);
        inserir_atualizar.setBorder(new LineBorder(Color.black));
        inserir_atualizar.setVisible(false);
        add(inserir_atualizar);

        //Buttons
        mistery_button.setBounds(430,512,70,20);
        mistery_button.setBorder(new LineBorder(Color.black));
        mistery_button.addActionListener(this::aparecer);
        add(mistery_button);

        botao_atualizar.setBounds(290,572,120,20);
        botao_atualizar.setBorder(new LineBorder(Color.black));
        botao_atualizar.setVisible(false);
        botao_atualizar.addActionListener(this::atualizar);
        add(botao_atualizar);






    }

}
