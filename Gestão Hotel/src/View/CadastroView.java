package View;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.AbstractAction;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Cadastro;
import Model.Cliente;

import java.awt.event.ActionEvent;

public final class CadastroView extends Interface {

	public CadastroView(List<Cliente> arr) {

		this.arr = arr;
		this.enterAction = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (verificar()) {
					cliente = criarCliente();
					if (new Cadastro().cadastrar(arr, cliente)) {
						mudarTela();
					}
				}

			}

		};

	}

	public void cadastrar() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Cadastro");
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

		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (verificar()) {
					cliente = criarCliente();
					if (new Cadastro().cadastrar(arr, cliente)) {
						mudarTela();
					}
				}
			}
		});
		btnNewButton.setBounds(0, 165, 100, 25);
		panel.add(btnNewButton);

		frame.setVisible(true);
	}

	public void mudarTela() {
		frame.setVisible(false);
		new LoginView(arr).login();
	}

	@Override
	public boolean verificar() {

		boolean validacao = textField.getText().equals("") || textField_1.getText().equals("")
				|| textField_2.getText().equals("") || textField_3.getText().equals("")
				|| textField_4.getText().equals("") || passwordField.getPassword().length == 0;

		if (validacao)
			return false;

		return true;

	}

	public Cliente criarCliente() {

		StringBuilder password = new StringBuilder();
		password.append(passwordField.getPassword());
		Cliente cliente = new Cliente(textField_4.getText(), getSenha(), textField.getText(),
				textField_2.getText(), textField_1.getText(), textField_3.getText());
		return cliente;

	}

	@Override
	protected String getSenha() {

		StringBuilder sb = new StringBuilder();

		for (char letra : passwordField.getPassword()) {
			sb.append(letra);

		}

		return sb.toString();
	}

}
