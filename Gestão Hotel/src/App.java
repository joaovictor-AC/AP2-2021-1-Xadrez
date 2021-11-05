import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import Model.Cliente;
import View.LoginView;

public class App {
    public static void main(String[] args) throws Exception {
     
        new LoginView(bd()).login();
    
    }

    public static List<Cliente> bd() {

        int ano, mes, dia;
        ano = Calendar.getInstance().get(Calendar.YEAR);
        mes = Calendar.getInstance().get(Calendar.MONTH);
        dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        
        List<Cliente> clientes = new ArrayList<>(51);
        Cliente admin = new Cliente("admin", "123", "admin", "abc", "123", "123");
        admin.setAdmin(true);
        Cliente cl1 = new Cliente("matheus_alc@gmail.com", "123", "Matheus Alcântra da Silva", "Rua Almirante Rodriguês Bairro Central/Teresina-PI", "60766010007", "61821059822");
        Cliente cl2 = new Cliente("marialuz@hotmail.com", "123", "Maria da Luz Perdigão", "Rua Paracatu Bairro Parque Imperial/São Paulo-SP", "38468132063", "72383187811");
        Cliente cl3 = new Cliente("aline167@outlook.com", "123", "Aline Castanho Setúbal", "Rodovia Raposo Tavares Bairro Lageadinho/Cotia-SP", "31707060045", "67235969834");
        Cliente cl4 = new Cliente("delcinho@gmail.com", "123", "Délcio Póvoas Santiago", "Avenida Tocantins Bairro Avenida Tocantins/Jataí-GO", "26495723024", "58622282815");
        Cliente cl5 = new Cliente("noemibonito@gmaail.com", "123", "Noemi Bonito Varanda", "Praça da República Bairro República/São Paulo-SP", "32347649051", "28588266980");
        Cliente cl6 = new Cliente("lilianes@hotmail.com", "123", "Lilian Belmonte Espírito Santo", "Avenida Almirante Maximiano Fonseca Bairro Zona Portuária/Rio Grande-RS", "78235568047", "15821274906");
        Cliente cl7 = new Cliente("moha@gmail.copm", "123", "Mohammad Luz Casqueira", "Rua Frederico Moura Bairro Bairro Cidade Nova/Franca-SP", "29914590004", "82385720170");
        Cliente cl8 = new Cliente("zitinha@hotmail.com", "123", "Zita Sousa Sanches", "Rua Tenente-Coronel Cardoso Bairro Centro/Campos dos Goytacazes-RJ", "14027172027", "31205889514");
        Cliente cl9 = new Cliente("alv_az@gmail.com", "123", "Azael Alvarenga Franca", "Travessa Antônio Ferreira Bairro Igrejinha/Capanema-PA", "06036236034", "13271429249");
        Cliente cl10 = new Cliente("alisa123@gmail.com", "123", "Alisa Meira Alvarenga", "Rua Barão de Vitória Bairro Casa Grande/Diadema-SP", "64146111072", "56385144370");

        cl1.setEntrada(new GregorianCalendar(ano, mes + 2, dia));
        cl2.setEntrada(new GregorianCalendar(ano, mes + 1, dia));
        cl3.setEntrada(new GregorianCalendar(ano, mes, dia + 7));
        cl4.setEntrada(new GregorianCalendar(ano, mes + 1, dia - 4));
        cl5.setEntrada(new GregorianCalendar(ano, mes + 3, dia));
        cl6.setEntrada(new GregorianCalendar(ano, mes, dia + 10));
        cl7.setEntrada(new GregorianCalendar(ano, mes + 9, dia));
        cl8.setEntrada(new GregorianCalendar(ano, mes + 5, dia + 5));
        cl9.setEntrada(new GregorianCalendar(ano, mes + 2, dia - 10));
        cl10.setEntrada(new GregorianCalendar(ano, mes + 10, dia - 20));

        cl1.setSaida(new GregorianCalendar(ano, mes + 2, dia + 4));
        cl2.setSaida(new GregorianCalendar(ano, mes + 1, dia + 3));
        cl3.setSaida(new GregorianCalendar(ano, mes, dia + 10));
        cl4.setSaida(new GregorianCalendar(ano, mes + 1, dia + 1));
        cl5.setSaida(new GregorianCalendar(ano, mes + 3, dia + 2));
        cl6.setSaida(new GregorianCalendar(ano, mes, dia + 13));
        cl7.setSaida(new GregorianCalendar(ano, mes + 9, dia + 3));
        cl8.setSaida(new GregorianCalendar(ano, mes + 5, dia + 7));
        cl9.setSaida(new GregorianCalendar(ano, mes + 2, dia - 8));
        cl10.setSaida(new GregorianCalendar(ano, mes + 10, dia - 18));


        cl1.setQuarto(45);
        cl2.setQuarto(8);
        cl3.setQuarto(1);
        cl4.setQuarto(9);
        cl5.setQuarto(7);
        cl6.setQuarto(2);
        cl7.setQuarto(3);
        cl8.setQuarto(15);
        cl9.setQuarto(23);
        cl10.setQuarto(15);

        
        cl1.setPreco(getEstadia(cl1));
        cl2.setPreco(getEstadia(cl2));
        cl3.setPreco(getEstadia(cl3));
        cl4.setPreco(getEstadia(cl4));
        cl5.setPreco(getEstadia(cl5));
        cl6.setPreco(getEstadia(cl6));
        cl7.setPreco(getEstadia(cl7));
        cl8.setPreco(getEstadia(cl8));
        cl9.setPreco(getEstadia(cl9));
        cl10.setPreco(getEstadia(cl10));

        clientes.add(admin);
        clientes.add(cl1);
        clientes.add(cl2);
        clientes.add(cl3);
        clientes.add(cl4);
        clientes.add(cl5);
        clientes.add(cl6);
        clientes.add(cl7);
        clientes.add(cl8);
        clientes.add(cl9);
        clientes.add(cl10);


        return clientes;

    }

    public static String getEstadia(Cliente cliente) {
        LocalDate l1 = LocalDate.of(cliente.getEntrada().get(Calendar.YEAR), cliente.getEntrada().get(Calendar.MONTH)+1, cliente.getEntrada().get(Calendar.DAY_OF_MONTH)); 
        LocalDate l2 = LocalDate.of(cliente.getSaida().get(Calendar.YEAR), cliente.getSaida().get(Calendar.MONTH)+1, cliente.getSaida().get(Calendar.DAY_OF_MONTH));
        long days = l1.datesUntil(l2).count();
        return NumberFormat.getCurrencyInstance().format(days*80).toString();
    }

}
