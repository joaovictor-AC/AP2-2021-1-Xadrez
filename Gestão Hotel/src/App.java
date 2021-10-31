import java.util.ArrayList;
import java.util.List;

import Model.Cliente;
import View.LoginView;

public class App {
    public static void main(String[] args) throws Exception {

        List<Cliente> clientes = new ArrayList<>();
        Cliente cl = new Cliente("admin", "123", "admin", "123", "123", "123");
        cl.setAdmin(true);
        clientes.add(cl);

        new LoginView(clientes).login();

    }
}
