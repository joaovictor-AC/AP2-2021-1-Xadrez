package Controller;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


import Model.Cliente;

public class Reserva {

    public boolean reservar(List<Cliente> clientes, Cliente cl) {

        if (cl.getSaida().after(cl.getEntrada())) {

            for (int i = 0; i < clientes.size(); i++) {

                if (clientes.get(i).getQuarto() == cl.getQuarto() && clientes.get(i) != cl && clientes.get(i).getQuarto() != 0) {

                    if (cl.getEntrada().getTime().after(new GregorianCalendar().getTime())) {

                        if (condicao1(cl.getEntrada(), cl.getSaida(), clientes.get(i))
                                || condicao2(cl.getEntrada(), cl.getSaida(), clientes.get(i))) {

                            if (i == clientes.size() - 1) {
                                System.out.println("Reserva Cadastrada!");
                            }

                        } else {
                            System.out.println("Data indisponível!");
                            return false;
                        }
                    } else {
                        System.out.println("Datas inválidas!");
                        return false;
                    }
                } else {
                    if (i == clientes.size() - 1) {
                        System.out.println("Reserva Cadastrada!");
                        return true;
                    }
                    continue;
                }
            }
        } else {
            System.out.println("Datas inválidas!");
            return false;
        }

        return true;

    }

    // public void data(Scanner in, Cliente cl, List<Cliente> clientes, int quarto_escolhido) {

    //     boolean quarto_reservado;
    //     quarto_reservado = false;
    //     Calendar calendario1 = null;
    //     Calendar calendario2 = null;
    //     String data, datas[];
    //     int dia, mes, ano;
    //     dia = 0;
    //     mes = 0;
    //     ano = 0;

    //     while (!quarto_reservado) {

    //         System.out.println("Escolha a data de entrada(dd/mm/yyyy): ");
    //         data = in.nextLine();
    //         datas = data.split("/");
    //         dia = Integer.parseInt(datas[0]);
    //         mes = Integer.parseInt(datas[1]) - 1;
    //         ano = Integer.parseInt(datas[2]);

    //         calendario1 = new GregorianCalendar(ano, mes, dia, 12, 0, 0);
    //         System.out.println(calendario1.getTime());

    //         System.out.println("Escolha a data de saída(dd/mm/yyyy): ");
    //         data = in.nextLine();
    //         datas = data.split("/");
    //         dia = Integer.parseInt(datas[0]);
    //         mes = Integer.parseInt(datas[1]) - 1;
    //         ano = Integer.parseInt(datas[2]);

    //         calendario2 = new GregorianCalendar(ano, mes, dia, 12, 0, 0);
    //         System.out.println(calendario2.getTime());

    //         if (calendario2.after(calendario1)) {

    //             for (int i = 0; i < clientes.size(); i++) {

    //                 if (clientes.get(i).getQuarto() == quarto_escolhido) {

    //                     if (calendario1.getTime().after(new GregorianCalendar().getTime())) {

    //                         if (condicao1(calendario1, calendario2, clientes.get(i))
    //                                 || condicao2(calendario1, calendario2, clientes.get(i))) {

    //                             if (i == clientes.size() - 1) {
    //                                 System.out.println("Reserva Cadastrada!");
    //                                 quarto_reservado = true;
    //                             }

    //                         } else {
    //                             System.out.println("Data indisponível!");
    //                             break;
    //                         }
    //                     } else {
    //                         System.out.println("Datas inválidas!");
    //                         break;
    //                     }
    //                 } else {
    //                     if (i == clientes.size() - 1) {
    //                         System.out.println("Reserva Cadastrada!");
    //                         quarto_reservado = true;
    //                     }
    //                     continue;
    //                 }
    //             }
    //         } else {
    //             System.out.println("Datas inválidas!");
    //         }

    //     }

    //     cl.setEntrada(calendario1);
    //     cl.setSaida(calendario2);

    // }

    public boolean condicao1(Calendar calendario1, Calendar calendario2, Cliente cliente) {
        return calendario1.after(cliente.getSaida()) && calendario2.after(cliente.getSaida());

    }

    public boolean condicao2(Calendar calendario1, Calendar calendario2, Cliente cliente) {
        return calendario1.before(cliente.getEntrada()) && calendario2.before(cliente.getEntrada());
    }

}
