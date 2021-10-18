import java.util.List;
import java.util.Scanner;

public class Cadastro {

    public void cadastrar(List<Cliente> clientes, Scanner in) {
        Cliente cliente;
        String nome, cpf, telefone, endereco, email, senha;
        email = "";
        int idade;
        boolean email_correto;
        email_correto = false;
        idade = 0;

        System.out.print("Nome: ");
        nome = in.nextLine();
        System.out.print("Idade: ");
        idade = in.nextInt();
        System.out.print("CPF: ");
        in.nextLine();
        cpf = in.nextLine();
        System.out.print("Telefone: ");
        telefone = in.nextLine();
        System.out.print("Endereço: ");
        endereco = in.nextLine();

        while (!email_correto) {

            email_correto = true;

            System.out.print("Email: ");
            email = in.nextLine();
            if (clientes.size() == 0) {
                email_correto = true;

            } else {
                for (int i = 0; i < clientes.size(); i++) {

                    if (clientes.get(i).getEmail().equals(email)) {
                        System.out.println("Email já cadastrado");
                        break;
                    }

                }
            }

        }
        System.out.print("Senha: ");
        senha = in.nextLine();

        cliente = new Cliente(email, senha, nome, idade, endereco, cpf, telefone);
        clientes.add(cliente);

        System.out.println(cliente.toString());

    }

}
