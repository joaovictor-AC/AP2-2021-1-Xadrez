import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>(50);

        String resp;
        resp = null;

        Cliente cl = new Cliente("admin", "123", "João", 19, "123", "123", "123");
        clientes.add(cl);
        

        while (resp != "s") {

            System.out.println("A - Cadastrar");
            System.out.println("B - Login");
            System.out.println("S - Sair");
            
            resp = in.nextLine().toLowerCase();

            switch (resp) {

                case "a":
                    new Cadastro().cadastrar(clientes, in);
                    break;
                
                case "b":
                    new Login().login(clientes, in);
                    break;

                case "s":
                    resp = "s";
                    break;

                default:
                    System.out.println("Comando inválido!");
                    break;

            }

        }


        in.close();
    }
}
