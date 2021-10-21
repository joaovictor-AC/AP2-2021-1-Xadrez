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
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class LoginView {
    

    public LoginView() {

        JPanel contentPane;
        JTextField textField;
        JPasswordField passwordField;
        JTable table;
        JFrame frame = new JFrame();
        
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(5, 5, 426, 43);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 80, 400, 151);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(5, 5, 60, 20);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(70, 5, 150, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(5, 45, 60, 20);
		panel.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(70, 45, 150, 20);
		panel.add(passwordField);
		
		table = new JTable();
		table.setBounds(289, 91, 1, 1);
		panel.add(table);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(0, 126, 100, 25);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Cadastrar-se");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
                new CadastroView();
			}
		});
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(5, 79, 80, 15);
		panel.add(lblNewLabel_3);
        
        frame.setVisible(true);
	}
}
