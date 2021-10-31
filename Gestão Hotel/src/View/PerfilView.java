package View;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;

import Controller.Cadastro;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.Cliente;

public class PerfilView extends Interface {

    public PerfilView(List<Cliente> arr, Cliente cliente) {
        this.arr = arr;
        this.cliente = cliente;
        this.enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (verificar()) {

                    if (new Cadastro().cadastrar(arr, criarCliente())) {
                        alterarCliente();
                        perfil();
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "É necessário preencher todos os espaços", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

        };
    }

    public void perfil() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        btnNewButton_2 = new JButton("Reservas");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);

            }
        });
        btnNewButton_2.setBounds(40, 40, 150, 20);
        contentPane.add(btnNewButton_2);

        btnNewButton_3 = new JButton("Visualizar perfil");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                visualizarPerfil(cliente);

            }
        });
        btnNewButton_3.setBounds(40, 80, 150, 20);
        contentPane.add(btnNewButton_3);

        btnNewButton_1 = new JButton("Editar perfil");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                editarPerfil(cliente);

            }
        });
        btnNewButton_1.setBounds(40, 120, 150, 20);
        contentPane.add(btnNewButton_1);

        if (cliente.isAdmin()) {

            btnNewButton_4 = new JButton("Ver clientes");
            btnNewButton_4.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.setVisible(false);
                    editarPerfil(cliente);
    
                }
            });
            btnNewButton_4.setBounds(40, 160, 150, 20);
            contentPane.add(btnNewButton_4);
    

        }

        btnNewButton = new JButton("Deslogar");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                new LoginView(arr).login();

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBackground(new Color(250, 128, 145));
        btnNewButton.setBounds(330, 210, 90, 30);
        contentPane.add(btnNewButton);

        frame.setVisible(true);
    }

    public void visualizarPerfil(Cliente cliente) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Perfil:");
        lblNewLabel.setBounds(5, 5, 426, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        contentPane.add(lblNewLabel);

        panel = new JPanel();
        panel.setBounds(5, 64, 400, 200);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel_1 = new JLabel("Nome: " + cliente.getNome());
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(5, 5, 450, 15);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("CPF: " + cliente.getCpf());
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(5, 30, 450, 15);
        panel.add(lblNewLabel_2);

        table = new JTable();
        table.setBounds(289, 91, 1, 1);
        panel.add(table);

        lblNewLabel_3 = new JLabel("Endere\u00E7o: " + cliente.getEndereco());
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(5, 55, 450, 15);
        panel.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Telefone: " + cliente.getTelefone());
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(5, 80, 450, 15);
        panel.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("Email: " + cliente.getEmail());
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(5, 105, 450, 15);
        panel.add(lblNewLabel_5);

        btnNewButton = new JButton("Voltar");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                perfil();
            }
        });
        btnNewButton.setBounds(0, 165, 100, 25);
        panel.add(btnNewButton);

        frame.setVisible(true);

    }

    public void editarPerfil(Cliente cliente) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Editar perfil:");
        lblNewLabel.setBounds(5, 5, 426, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        contentPane.add(lblNewLabel);

        panel = new JPanel();
        panel.setBounds(5, 64, 400, 200);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel_1 = new JLabel("Nome:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(5, 5, 70, 15);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(96, 5, 150, 20);
        panel.add(textField);
        textField.setColumns(10);
        textField.addActionListener(enterAction);

        lblNewLabel_2 = new JLabel("CPF:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(5, 30, 70, 15);
        panel.add(lblNewLabel_2);

        table = new JTable();
        table.setBounds(289, 91, 1, 1);
        panel.add(table);

        textField_1 = new JTextField();
        textField_1.setBounds(96, 30, 150, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        textField_1.addActionListener(enterAction);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(96, 55, 150, 20);
        panel.add(textField_2);
        textField_2.addActionListener(enterAction);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(96, 80, 150, 20);
        panel.add(textField_3);
        textField_3.addActionListener(enterAction);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(96, 105, 150, 20);
        panel.add(textField_4);
        textField_4.addActionListener(enterAction);

        passwordField = new JPasswordField();
        passwordField.setBounds(96, 130, 150, 20);
        panel.add(passwordField);
        passwordField.addActionListener(enterAction);

        lblNewLabel_3 = new JLabel("Endere\u00E7o:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(5, 55, 70, 15);
        panel.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Telefone:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(5, 80, 70, 15);
        panel.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("Email:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(5, 105, 70, 15);
        panel.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("Senha:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(5, 130, 70, 15);
        panel.add(lblNewLabel_6);

        btnNewButton = new JButton("Concluir");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (verificar()) {

                    if (new Cadastro().cadastrar(arr, criarCliente())) {
                        alterarCliente();
                        perfil();
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "É necessário preencher todos os espaços", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(0, 165, 100, 25);
        panel.add(btnNewButton);
        frame.setVisible(true);

    }

    public Cliente criarCliente() {

        StringBuilder password = new StringBuilder();
        password.append(passwordField.getPassword());
        Cliente cliente = new Cliente(textField_4.getText(), getSenha(), textField.getText(), textField_2.getText(),
                textField_1.getText(), textField_3.getText());
        return cliente;

    }

    public void alterarCliente() {
        cliente.setEmail(textField_4.getText());
        cliente.setSenha(getSenha());
        cliente.setNome(textField.getText());
        cliente.setEndereco(textField_2.getText());
        cliente.setCpf(textField_1.getText());
        cliente.setTelefone(textField_3.getText());

    }

    @Override
    protected boolean verificar() {

        boolean validacao = textField.getText().equals("") || textField_1.getText().equals("")
                || textField_2.getText().equals("") || textField_3.getText().equals("")
                || textField_4.getText().equals("") || passwordField.getPassword().length == 0;

        if (validacao)
            return false;

        return true;

    }

    protected String getSenha() {

        StringBuilder sb = new StringBuilder();

        for (char letra : passwordField.getPassword()) {
            sb.append(letra);

        }

        return sb.toString();
    }

}
