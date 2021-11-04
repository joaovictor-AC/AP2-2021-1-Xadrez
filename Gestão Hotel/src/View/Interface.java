package View;

import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import Model.Cliente;

public abstract class Interface {

    protected Action enterAction;
    protected JPanel panel;
    protected JFrame frame;
    protected JPanel contentPane;
    protected JTable table;
    protected JTextField textField;
    protected JTextField textField_1;
    protected JTextField textField_2;
    protected JTextField textField_3;
    protected JTextField textField_4;
    protected JPasswordField passwordField;
    protected JLabel lblNewLabel;
    protected JLabel lblNewLabel_1;
    protected JLabel lblNewLabel_2;
    protected JLabel lblNewLabel_3;
    protected JLabel lblNewLabel_4;
    protected JLabel lblNewLabel_5;
    protected JLabel lblNewLabel_6;
    protected JLabel lblNewLabel_7;
    protected JButton btnNewButton;
    protected JButton btnNewButton_1;
    protected JButton btnNewButton_2;
    protected JButton btnNewButton_3;
    protected JButton btnNewButton_4;
    protected JSpinner spinner;
    protected JSpinner spinner_1;
    protected JSpinner spinner_2;
    protected JSpinner spinner_3;
    protected Cliente cliente;
    protected List<Cliente> arr;

    public Interface() {
        this.frame = new JFrame();
    }

    protected Cliente criarCliente() {

        StringBuilder password = new StringBuilder();
        password.append(passwordField.getPassword());
        Cliente cliente = new Cliente(textField_4.getText(), getSenha(), textField.getText(), textField_2.getText(),
                textField_1.getText(), textField_3.getText());
        return cliente;

    }

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
