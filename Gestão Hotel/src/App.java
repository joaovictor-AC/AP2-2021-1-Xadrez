import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        String em, ps;

        ArrayList<Cadastro> user = new ArrayList<Cadastro>();
        ArrayList<Cadastro> password = new ArrayList<Cadastro>();

        em = in.nextLine();
        ps = in.nextLine();

        Cadastro cd = new Cadastro(em, ps);
        user.add(cd);

        for (int i = 0; i < user.size(); i++) {
            System.out.println(user.get(i).getEmail());
        }

        in.close();

    }
}
