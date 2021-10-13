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

            System.out.println("Escolha um quarto: (1-50)");
            quarto_escolhido = in.nextInt();
            in.nextLine();
            for (Cliente cliente : clientes) {

                if (cliente.getQuarto() == quarto_escolhido) {
                    num = 2;
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

    }

}
