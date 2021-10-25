package View;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

public class PerfilView extends Interface {

    public void perfil() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNewButton_2 = new JButton("Reservas");
        btnNewButton_2.setBounds(40, 40, 150, 20);
        contentPane.add(btnNewButton_2);

        btnNewButton_3 = new JButton("Visualizar perfil");
        btnNewButton_3.setBounds(40, 80, 150, 20);
        contentPane.add(btnNewButton_3);

        btnNewButton_1 = new JButton("Editar perfil");
        btnNewButton_1.setBounds(40, 120, 150, 20);
        contentPane.add(btnNewButton_1);

        btnNewButton = new JButton("Deslogar");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBackground(new Color(250, 128, 145));
        btnNewButton.setBounds(330, 210, 90, 30);
        contentPane.add(btnNewButton);

        frame.setVisible(true);
    }

    @Override
    protected boolean verificar() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected String getSenha() {
        // TODO Auto-generated method stub
        return null;
    }

}
