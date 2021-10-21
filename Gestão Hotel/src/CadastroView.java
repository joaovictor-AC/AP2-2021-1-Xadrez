import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class CadastroView {
    
    public CadastroView() {

        JPanel contentPane;
        JTextField textField;
        JTable table;
        JTextField textField_1;
        JTextField textField_2;
        JTextField textField_3;
        JTextField textField_4;
        JPasswordField passwordField;
        JLabel lblNewLabel_3;
        JLabel lblNewLabel_4;
        JLabel lblNewLabel_5;
        JLabel lblNewLabel_6;
        JButton btnNewButton;
        JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setBounds(5, 5, 426, 43);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 64, 400, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(5, 5, 70, 15);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(96, 5, 150, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
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
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(96, 55, 150, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(96, 80, 150, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(96, 105, 150, 20);
		panel.add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(96, 130, 150, 20);
		panel.add(passwordField);
		
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
                frame.setVisible(false);
                new LoginView();
			}
		});
		btnNewButton.setBounds(0, 165, 100, 25);
		panel.add(btnNewButton);

        frame.setVisible(true);
	}

}
