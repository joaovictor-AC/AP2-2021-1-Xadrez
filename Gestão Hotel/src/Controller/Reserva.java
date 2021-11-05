package Controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Cliente;

public class Reserva {

    public boolean reservar(List<Cliente> clientes, Cliente cl, Calendar data_atual) {

        String data_entrada = new SimpleDateFormat("dd/MM/yyyy").format(cl.getEntrada().getTime());
        String data_saida = new SimpleDateFormat("dd/MM/yyyy").format(cl.getSaida().getTime());

        if (cl.getSaida().after(cl.getEntrada()) && !data_saida.equals(data_entrada) && cl.getEntrada().after(data_atual)) {
            for (int i = 0; i < clientes.size(); i++) {

                if (clientes.get(i).getQuarto() == cl.getQuarto() && clientes.get(i) != cl
                        && clientes.get(i).getQuarto() != 0) {
                    if (!condicao1(cl.getEntrada(), cl.getSaida(), clientes.get(i))
                            && !condicao2(cl.getEntrada(), cl.getSaida(), clientes.get(i))) {

                        JOptionPane.showMessageDialog(new JFrame(), "Data indisponível", "Erro",
                                JOptionPane.ERROR_MESSAGE);
                        System.out.println(clientes.get(i).toString());

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

    public boolean condicao1(Calendar entrada, Calendar saida, Cliente cliente_array) {
        return entrada.after(cliente_array.getSaida()) && saida.after(cliente_array.getSaida());

    }

    public boolean condicao2(Calendar entrada, Calendar saida, Cliente cliente_array) {
        return entrada.before(cliente_array.getEntrada()) && saida.before(cliente_array.getEntrada());
    }

}
