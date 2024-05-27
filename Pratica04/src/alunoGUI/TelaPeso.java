package alunoGUI;

import javax.swing.*;

public class TelaPeso extends JFrame {

    public TelaPeso(){
        initComponents();
    }

    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Histórico de Peso");
        setSize(1366,768); //the half  -> width:683 height:384
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
    }
}
