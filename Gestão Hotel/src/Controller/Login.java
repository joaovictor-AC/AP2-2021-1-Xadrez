package Controller;

import java.util.List;
import java.util.Scanner;

import Model.Cliente;

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
                conta_encontrada = true;
                tela_1(clientes, in, cliente);
                break;
            }

        }

        if (!conta_encontrada) {
            System.out.println("Conta não encontrada!");
            new Login().login(clientes, in);
        }

    }

    public void tela_1(List<Cliente> clientes, Scanner in, Cliente cliente) {

        String resp;
        resp = null;

        while (resp != "s") {

            System.out.println("A - Reservar um quarto");
            System.out.println("B - Editar perfil");
            System.out.println("C - Exibir perfil");
            System.out.println("S - Sair");

            resp = in.nextLine();
            resp = resp.toLowerCase();

            switch (resp) {

            case "a":
                new Reserva().reservar(clientes, in, cliente);
                break;

            case "b":
                new Perfil().editar(clientes, in, cliente);
                break;

            case "c":
                System.out.println(cliente.toString());
                break;

            case "s":
                resp = "s";
                break;

            default:
                System.out.println("Comando não encontrado!");
                break;

            }
        }

    }

}
