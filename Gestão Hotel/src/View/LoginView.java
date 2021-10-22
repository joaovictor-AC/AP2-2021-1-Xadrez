package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public final class LoginView extends Interface {

    public LoginView() {
        this.enterAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Enter");
            }

        };
    }

    public void login() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Login");
        lblNewLabel.setBounds(5, 5, 426, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        contentPane.add(lblNewLabel);

        panel = new JPanel();
        panel.setBounds(5, 80, 400, 151);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel_1 = new JLabel("Email:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(5, 5, 60, 20);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(70, 5, 150, 20);
        panel.add(textField);
        textField.setColumns(10);
        textField.addActionListener(enterAction);

        lblNewLabel_2 = new JLabel("Senha:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(5, 45, 60, 20);
        panel.add(lblNewLabel_2);

        passwordField = new JPasswordField();
        passwordField.setBounds(70, 45, 150, 20);
        panel.add(passwordField);
        passwordField.addActionListener(enterAction);

        table = new JTable();
        table.setBounds(289, 91, 1, 1);
        panel.add(table);

        btnNewButton = new JButton("Entrar");
        btnNewButton.setBounds(0, 126, 100, 25);
        panel.add(btnNewButton);

        lblNewLabel_3 = new JLabel("Cadastrar-se");
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                new CadastroView().cadastrar();
                ;
            }
        });
        lblNewLabel_3.setForeground(Color.BLUE);
        lblNewLabel_3.setBounds(5, 79, 80, 15);
        panel.add(lblNewLabel_3);

        frame.setVisible(true);
    }

}
