package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.Cliente;

public class PerfilView extends Interface {

    public PerfilView(List<Cliente> arr, Cliente cliente) {
        this.arr = arr;
        this.cliente = cliente;
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
                

            }
        });
        btnNewButton_1.setBounds(40, 120, 150, 20);
        contentPane.add(btnNewButton_1);

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

    @Override
    protected boolean verificar() {
        return false;
    }

    @Override
    protected String getSenha() {
        return null;
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
}
