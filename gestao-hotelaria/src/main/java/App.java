import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {

        ArrayList<Opcao_de_cadastro> usuario = new ArrayList<Opcao_de_cadastro>();
        ArrayList<Opcao_de_cadastro> senha = new ArrayList<Opcao_de_cadastro>();
        Scanner in = new Scanner(System.in);

        String em, se;
        em = in.nextLine();
        se = in.nextLine();

        Opcao_de_cadastro cl = new Opcao_de_cadastro(em, se);
        usuario.add(cl);

        Iterator<Opcao_de_cadastro> it = usuario.iterator();

        while(it.hasNext()) {
            System.out.println(it.next().getPassword());
        }

    }
}
