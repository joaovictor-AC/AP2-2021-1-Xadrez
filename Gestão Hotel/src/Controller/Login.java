package Controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Cliente;

public class Login {

    public Cliente login(List<Cliente> clientes, String email, String senha) {

        for (Cliente cliente : clientes) {
            if (email.equals(cliente.getEmail()) && senha.equals(cliente.getSenha())) {
                return cliente;
            }

        }

        JOptionPane.showMessageDialog(new JFrame(), "Conta não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
        return null;

    }

}
