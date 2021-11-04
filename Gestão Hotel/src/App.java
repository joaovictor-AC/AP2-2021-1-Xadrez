import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import Model.Cliente;
import View.LoginView;
import View.PerfilView;

public class App {
    public static void main(String[] args) throws Exception {

        List<Cliente> clientes = new ArrayList<>();
        Cliente cl = new Cliente("admin", "123", "admin", "123", "123", "123");
        Cliente j = new Cliente("j@gmail.com", "123", "Joao", "123", "123", "123");
        cl.setAdmin(true);
        clientes.add(cl);
        clientes.add(j);
        

        new LoginView(clientes).login();


    }
}
