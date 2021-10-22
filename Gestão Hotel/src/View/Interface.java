package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;

import javax.swing.Action;
import javax.swing.JButton;
// import Model.Cliente;

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
    protected JButton btnNewButton;
    // protected Cliente cliente;

    public Interface() {
        this.frame = new JFrame();
    }

}
