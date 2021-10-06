import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();

        // new Cadastro().cadastrar(clientes, in);
        Cliente cl = new Cliente("admin", "123", "João", 19, "123", "123", "123");

        clientes.add(cl);
        new Login().login(clientes, in);

        in.close();
    }
}
