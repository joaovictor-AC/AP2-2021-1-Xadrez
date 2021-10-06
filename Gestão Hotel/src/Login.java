import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {

    public void login(List<Cliente> clientes, Scanner in) {

        String email;
        String senha;
        boolean conta_encontrada;
        conta_encontrada = false;

        System.out.print("Email: ");
        email = in.nextLine();
        System.out.print("Senha: ");
        senha = in.nextLine();

        for (Cliente cliente : clientes) {
            if (email.equals(cliente.getEmail()) && senha.equals(cliente.getSenha())) {
                System.out.println(cliente.toString());
                conta_encontrada = true;
                break;
            }

        }

        if (!conta_encontrada) {
            System.out.println("Conta não encontrada!");
            new Login().login(clientes, in);
        }

    }

}
