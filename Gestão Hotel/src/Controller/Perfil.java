package Controller;
import java.util.List;
import java.util.Scanner;

import Model.Cliente;

public class Perfil {

    public void editar(List<Cliente> clientes, Scanner in, Cliente cl) {

        boolean email_correto;
        email_correto = false;
        String email;
        email = null;

        System.out.print("Nome: ");
        cl.setNome(in.nextLine());
        System.out.print("CPF: ");
        in.nextLine();
        cl.setCpf(in.nextLine());
        System.out.print("Telefone: ");
        cl.setTelefone(in.nextLine());
        System.out.print("Endereço: ");
        cl.setEndereco(in.nextLine());

        while (!email_correto) {

            email_correto = true;

            System.out.print("Novo email: ");
            email = in.nextLine();
            if (clientes.size() == 0) {
                break;

            } else {
                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).getEmail().equals(email)) {
                        System.out.println("Email já cadastrado");
                        email_correto = false;
                        break;
                    }

                }
            }

        }

        cl.setEmail(email);

        System.out.print("Nova senha: ");
        cl.setSenha(in.nextLine());
        System.out.println();

    }

}
