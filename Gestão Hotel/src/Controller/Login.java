package Controller;

import java.util.List;

import Model.Cliente;

public class Login {

    public boolean login(List<Cliente> clientes, String email, String senha) {

        for (Cliente cliente : clientes) {
            if (email.equals(cliente.getEmail()) && senha.equals(cliente.getSenha())) {
                return true;
            }

        }

        return false;

    }

    // public void tela_1(List<Cliente> clientes, Scanner in, Cliente cliente) {

    //     String resp;
    //     resp = null;

    //     while (resp != "s") {

    //         System.out.println("A - Reservar um quarto");
    //         System.out.println("B - Editar perfil");
    //         System.out.println("C - Exibir perfil");
    //         System.out.println("S - Sair");

    //         resp = in.nextLine();
    //         resp = resp.toLowerCase();

    //         switch (resp) {

    //         case "a":
    //             new Reserva().reservar(clientes, in, cliente);
    //             break;

    //         case "b":
    //             new Perfil().editar(clientes, in, cliente);
    //             break;

    //         case "c":
    //             System.out.println(cliente.toString());
    //             break;

    //         case "s":
    //             resp = "s";
    //             break;

    //         default:
    //             System.out.println("Comando não encontrado!");
    //             break;

    //         }
    //     }

    // }

}
