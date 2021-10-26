package Controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Cliente;

public class Cadastro {

    private JFrame frame;
    private String regex;
    private Pattern pattern;
    private Matcher matcher;

    public Cadastro() {
        this.frame = new JFrame();
    }

    public boolean cadastrar(List<Cliente> clientes, Cliente cl) {

        boolean validacao = emailValid(cl, clientes, frame) && numeroValid(cl.getCpf(), clientes, frame, "CPF inválido")
                && numeroValid(cl.getTelefone(), clientes, frame, "Telefone inválido");

        return validacao;

    }

    public boolean emailValid(Cliente cl, List<Cliente> clientes, JFrame frame) {

        regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(cl.getEmail());

        if (matcher.matches()) {

            if (clientes.size() == 0) {
                clientes.add(cl);
                return true;
            } else {
                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).getEmail().equals(cl.getEmail()) && clientes.get(i) != cl) {
                        JOptionPane.showMessageDialog(frame, "Email já cadastrado", "ERRO", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }

                }
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Email inválido", "ERRO", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }

    public boolean numeroValid(String num, List<Cliente> clientes, JFrame frame, String mensagem) {
        regex = "\\s+|[A-Za-z]+";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(num);

        if (matcher.find()) {
            JOptionPane.showMessageDialog(frame, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }

}
