import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

public class Reserva {

    public void reservar(List<Cliente> clientes, Scanner in, Cliente cl) {

        boolean quarto_encontrado;
        quarto_encontrado = true;
        int num;
        num = 0;
        int quarto_escolhido;
        quarto_escolhido = 0;

        while (quarto_encontrado) {

            quarto_escolhido = in.nextInt();
            in.nextLine();
            for (Cliente cliente : clientes) {

                if (cliente.getQuarto() == quarto_escolhido) {
                    num = 1; // NÃO ESQUECE DE TROCAR O NUM
                    break;
                }

            }

            if (num == 2) {
                System.out.println("Quarto já reservado!");
                num = 0;
            } else {
                quarto_encontrado = false;
            }
        }

        cl.setQuarto(quarto_escolhido);
        data(in, cl, clientes);

    }

    public void data(Scanner in, Cliente cl, List<Cliente> clientes) {

        Calendar calendario1;
        Calendar calendario2;
        new GregorianCalendar();
        Calendar data_atual = Calendar.getInstance();
        String data, datas[];
        int dia, mes, ano;
        dia = 0;
        mes = 0;
        ano = 0;

        while (true) {

            System.out.println("Escolha a data de entrada(dd/mm/yyyy): ");
            data = in.nextLine();
            datas = data.split("/");
            dia = Integer.parseInt(datas[0]);
            mes = Integer.parseInt(datas[1]) - 1;
            ano = Integer.parseInt(datas[2]);

            calendario1 = new GregorianCalendar(ano, mes, dia, 12, 0, 0);
            System.out.println(calendario1.getTime());

            System.out.println("Escolha a data de saída(dd/mm/yyyy): ");
            data = in.nextLine();
            datas = data.split("/");
            dia = Integer.parseInt(datas[0]);
            mes = Integer.parseInt(datas[1]) - 1;
            ano = Integer.parseInt(datas[2]);

            calendario2 = new GregorianCalendar(ano, mes, dia, 12, 0, 0);
            System.out.println(calendario2.getTime());

            for (Cliente cliente : clientes) {

                if (cliente.getEntrada().compareTo(Calendar.getInstance()) < 0) {
                    continue;
                }
                if (calendario1.compareTo(cliente.getSaida()) > 0 && calendario2.compareTo(cliente.getEntrada()) < 0) {

                } else {
                    System.out.println(cliente.getEntrada().getTime() + " - " + cliente.getSaida().getTime());
                    System.out.println("Quarto indisponível!");
                    break;
                }
            }

            if (calendario2.compareTo(calendario1) > 0) {
                break;
            }

            if (calendario1.compareTo(Calendar.getInstance()) < 0) {
                System.out.println("Data inválida!");
                new Reserva().data(in, cl, clientes);
            }

            System.out.println("Datas inválidas!");
        }

        cl.setEntrada(calendario1);
        cl.setSaida(calendario2);

    }

}
