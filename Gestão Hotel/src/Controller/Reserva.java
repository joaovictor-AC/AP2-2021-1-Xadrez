package Controller;

import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Cliente;

public class Reserva {

    public boolean reservar(List<Cliente> clientes, Cliente cl, Calendar data_atual) {

        if (cl.getSaida().after(cl.getEntrada())) {
            for (int i = 0; i < clientes.size(); i++) {

                if (clientes.get(i).getQuarto() == cl.getQuarto() && clientes.get(i) != cl
                        && clientes.get(i).getQuarto() != 0) {
                    if (cl.getEntrada().after(data_atual)) {
                        if (!condicao1(cl.getEntrada(), cl.getSaida(), clientes.get(i))
                                || !condicao2(cl.getEntrada(), cl.getSaida(), clientes.get(i))) {

                            JOptionPane.showMessageDialog(new JFrame(), "Data indisponível", "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                                System.out.println(clientes.get(i).toString());

                            return false;
                        }
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Datas inválidas", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    if (i == clientes.size() - 1)
                        return true;
                    continue;
                }
            }
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Datas inválidas", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;

    }

    public boolean condicao1(Calendar calendario1, Calendar calendario2, Cliente cliente) {
        return calendario1.after(cliente.getSaida()) && calendario2.after(cliente.getSaida());

    }

    public boolean condicao2(Calendar calendario1, Calendar calendario2, Cliente cliente) {
        return calendario1.before(cliente.getEntrada()) && calendario2.before(cliente.getEntrada());
    }

}
