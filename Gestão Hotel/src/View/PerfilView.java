package View;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionEvent;

import Controller.Cadastro;
import Controller.Reserva;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import Model.Cliente;

public class PerfilView extends Interface {

    private int ano, mes, dia, quarto;
    private SpinnerNumberModel model_dia, model_mes, model_ano;
    private Calendar data_atual;

    public PerfilView(List<Cliente> arr, Cliente cliente) {

        this.arr = arr;
        this.cliente = cliente;
        this.data_atual = Calendar.getInstance();
        this.model_dia = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.DAY_OF_MONTH), 1, 31, 1);
        this.model_mes = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.MONTH) + 1, 1, 12, 1);
        this.model_ano = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.YEAR), 3000, 1);

        this.enterAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("OK");

                if (verificar()) {

                    if (new Cadastro().cadastrar(arr, criarCliente())) {
                        alterarCliente();
                        perfil();
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "É necessário preencher todos os espaços", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }

        };
    }

    public void perfil() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        if (!cliente.isAdmin()) {

            btnNewButton_2 = new JButton((cliente.getQuarto() == 0) ? "Reservar um quarto" : "Editar reserva");
            btnNewButton_2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.setVisible(false);
                    reservas_entrada();

                }

            });
            btnNewButton_2.setBounds(40, 40, 150, 20);
            contentPane.add(btnNewButton_2);

        } else {

            btnNewButton_2 = new JButton("Visualizar clientes");
            btnNewButton_2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.setVisible(false);
                    verClientes();

                }

            });
            btnNewButton_2.setBounds(40, 40, 150, 20);
            contentPane.add(btnNewButton_2);
        }

        btnNewButton_3 = new JButton("Visualizar perfil");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                visualizarPerfil(cliente);

            }
        });
        btnNewButton_3.setBounds(40, 80, 150, 20);
        contentPane.add(btnNewButton_3);

        btnNewButton_1 = new JButton("Editar perfil");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                editarPerfil(cliente);

            }
        });
        btnNewButton_1.setBounds(40, 120, 150, 20);
        contentPane.add(btnNewButton_1);

        if (cliente.isAdmin()) {

        }

        btnNewButton = new JButton("Deslogar");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                new LoginView(arr).login();

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBackground(new Color(250, 128, 145));
        btnNewButton.setBounds(330, 210, 90, 30);
        contentPane.add(btnNewButton);

        frame.setVisible(true);
    }

    public void reservas_entrada() {

        SpinnerNumberModel model_quarto = new SpinnerNumberModel(1, 1, 50, 1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(5, 64, 400, 200);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel = new JLabel("Entrada");
        lblNewLabel.setBounds(5, 5, 426, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Dia:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(5, 20, 70, 15);
        panel.add(lblNewLabel_1);

        spinner = new JSpinner();
        spinner.setBounds(80, 20, 80, 20);
        spinner.setModel(model_dia);
        panel.add(spinner);

        lblNewLabel_2 = new JLabel("Mês:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(5, 70, 70, 15);
        panel.add(lblNewLabel_2);

        spinner_1 = new JSpinner();
        spinner_1.setBounds(80, 70, 80, 20);
        spinner_1.setModel(model_mes);
        panel.add(spinner_1);

        lblNewLabel_3 = new JLabel("Ano:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(5, 120, 70, 15);
        panel.add(lblNewLabel_3);

        spinner_2 = new JSpinner();
        spinner_2.setBounds(80, 120, 80, 20);
        spinner_2.setModel(model_ano);
        panel.add(spinner_2);

        lblNewLabel_4 = new JLabel("Quarto:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_4.setBounds(200, 20, 70, 15);
        panel.add(lblNewLabel_4);

        spinner_3 = new JSpinner();
        spinner_3.setBounds(275, 20, 80, 20);
        spinner_3.setModel(model_quarto);
        panel.add(spinner_3);

        btnNewButton = new JButton("Reservar");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                alterarCliente_entrada();
                reservas_saida();
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(300, 150, 100, 25);
        panel.add(btnNewButton);

        frame.setVisible(true);

    }

    public void reservas_saida() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        panel = new JPanel();
        panel.setBounds(5, 64, 400, 200);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Saída");
        lblNewLabel.setBounds(5, 5, 426, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        contentPane.add(lblNewLabel);

        lblNewLabel_1 = new JLabel("Dia:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(5, 20, 70, 15);
        panel.add(lblNewLabel_1);

        spinner = new JSpinner();
        spinner.setBounds(80, 20, 80, 20);
        spinner.setModel(model_dia);
        panel.add(spinner);

        lblNewLabel_2 = new JLabel("Mês:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(5, 70, 70, 15);
        panel.add(lblNewLabel_2);

        spinner_1 = new JSpinner();
        spinner_1.setBounds(80, 70, 80, 20);
        spinner_1.setModel(model_mes);
        panel.add(spinner_1);

        lblNewLabel_3 = new JLabel("Ano:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(5, 120, 70, 15);
        panel.add(lblNewLabel_3);

        spinner_2 = new JSpinner();
        spinner_2.setBounds(80, 120, 80, 20);
        spinner_2.setModel(model_ano);
        panel.add(spinner_2);

        btnNewButton = new JButton("Reservar");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                alterarCliente_saida();
                frame.setVisible(false);
                if (new Reserva().reservar(arr, cliente, data_atual)) {
                    cliente.setPreco(getEstadia());
                    JOptionPane.showMessageDialog(new JFrame(), "Sua estadia ficou em " + cliente.getPreco(), "Erro",
                            JOptionPane.INFORMATION_MESSAGE);
                    perfil();
                } else {
                    reservas_entrada();
                }

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(300, 150, 100, 25);
        panel.add(btnNewButton);

        frame.setVisible(true);

    }

    public void visualizarPerfil(Cliente cliente) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Perfil:");
        lblNewLabel.setBounds(5, 5, 426, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        contentPane.add(lblNewLabel);

        panel = new JPanel();
        panel.setBounds(5, 64, 400, 200);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel_1 = new JLabel("Nome: " + cliente.getNome());
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(5, 0, 450, 15);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("CPF: " + cliente.getCpf());
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(5, 20, 450, 15);
        panel.add(lblNewLabel_2);

        table = new JTable();
        table.setBounds(289, 91, 1, 1);
        panel.add(table);

        lblNewLabel_3 = new JLabel("Endere\u00E7o: " + cliente.getEndereco());
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(5, 40, 450, 15);
        panel.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Telefone: " + cliente.getTelefone());
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(5, 60, 450, 15);
        panel.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("Email: " + cliente.getEmail());
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(5, 80, 450, 15);
        panel.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel(
                (cliente.getEntrada().equals(new GregorianCalendar(0, 0, 0)) ? "Data: Nenhuma data reservada"
                        : "Data: " + new SimpleDateFormat("dd/MM/yyyy").format(cliente.getEntrada().getTime()) + " - "
                                + new SimpleDateFormat("dd/MM/yyyy").format(cliente.getSaida().getTime())));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(5, 100, 450, 15);
        panel.add(lblNewLabel_6);

        lblNewLabel_7 = new JLabel(
                (cliente.getQuarto() == 0) ? "Quarto: Nenhum quarto reservado" : "Quarto: " + cliente.getQuarto());
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_7.setBounds(5, 120, 450, 15);
        panel.add(lblNewLabel_7);

        btnNewButton = new JButton("Voltar");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setVisible(false);
                perfil();
            }
        });
        btnNewButton.setBounds(0, 165, 100, 25);
        panel.add(btnNewButton);

        frame.setVisible(true);

    }

    public void editarPerfil(Cliente cliente) {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNewLabel = new JLabel("Editar perfil:");
        lblNewLabel.setBounds(5, 5, 426, 43);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
        contentPane.add(lblNewLabel);

        panel = new JPanel();
        panel.setBounds(5, 64, 400, 200);
        contentPane.add(panel);
        panel.setLayout(null);

        lblNewLabel_1 = new JLabel("Nome:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(5, 5, 70, 15);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        panel.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(96, 5, 150, 20);
        panel.add(textField);
        textField.setColumns(10);
        textField.addActionListener(enterAction);

        lblNewLabel_2 = new JLabel("CPF:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(5, 30, 70, 15);
        panel.add(lblNewLabel_2);

        table = new JTable();
        table.setBounds(289, 91, 1, 1);
        panel.add(table);

        textField_1 = new JTextField();
        textField_1.setBounds(96, 30, 150, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);
        textField_1.addActionListener(enterAction);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(96, 55, 150, 20);
        panel.add(textField_2);
        textField_2.addActionListener(enterAction);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(96, 80, 150, 20);
        panel.add(textField_3);
        textField_3.addActionListener(enterAction);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(96, 105, 150, 20);
        panel.add(textField_4);
        textField_4.addActionListener(enterAction);

        passwordField = new JPasswordField();
        passwordField.setBounds(96, 130, 150, 20);
        panel.add(passwordField);
        passwordField.addActionListener(enterAction);

        lblNewLabel_3 = new JLabel("Endere\u00E7o:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(5, 55, 70, 15);
        panel.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Telefone:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(5, 80, 70, 15);
        panel.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("Email:");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(5, 105, 70, 15);
        panel.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("Senha:");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(5, 130, 70, 15);
        panel.add(lblNewLabel_6);

        btnNewButton = new JButton("Concluir");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (verificar()) {

                    if (new Cadastro().cadastrar(arr, criarCliente())) {
                        alterarCliente();
                        perfil();
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "É necessário preencher todos os espaços", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnNewButton.setBounds(0, 165, 100, 25);
        panel.add(btnNewButton);
        frame.setVisible(true);

    }

    public void verClientes() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 450, 300);

        String[] colunas = { "Nome", "Quarto", "Data de Entrada", "Data de saída", "Estadia" };
        List<String[]> arrList = new ArrayList<>();

        for (Cliente cl : this.arr) {
            if (!cl.isAdmin()) {
                String[] clAtributos = { cl.getNome(),
                        (cl.getQuarto() == 0) ? "Nenhum quarto cadastrado" : Integer.toString(cl.getQuarto()),
                        (cl.getEntrada().equals(new GregorianCalendar(0, 0, 0))) ? "Nenhuma data cadastrada"
                                : new SimpleDateFormat("dd/MM/yyyy").format(cl.getEntrada().getTime()).toString(),
                        (cl.getEntrada().equals(new GregorianCalendar(0, 0, 0))) ? "Nenhuma data cadastrada"
                                : new SimpleDateFormat("dd/MM/yyyy").format(cl.getSaida().getTime()).toString(),
                        (cl.getPreco().equals("0")) ? "Sem valor" : cl.getPreco() };
                arrList.add(clAtributos);
            }
        }

        String[][] datas = {};
        datas = arrList.toArray(datas);
        JTable table = new JTable(datas, colunas);

        DefaultTableModel model = new DefaultTableModel(datas, colunas);
        table.setRowSorter(new TableRowSorter<>(model));

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String nome = table.getValueAt(table.getSelectedRow(), 0).toString();

                for (Cliente cl : arr) {

                    if (cl.getNome().equals(nome)) {
                        frame.setVisible(false);
                        visualizarPerfil(cl);
                    }

                }
            }

        });

        frame.add(new JScrollPane(table));

        frame.setVisible(true);

    }

    public void alterarCliente() {
        cliente.setEmail(textField_4.getText());
        cliente.setSenha(getSenha());
        cliente.setNome(textField.getText());
        cliente.setEndereco(textField_2.getText());
        cliente.setCpf(textField_1.getText());
        cliente.setTelefone(textField_3.getText());

    }

    public void alterarCliente_entrada() {
        ano = Integer.parseInt(spinner_2.getValue().toString());
        mes = Integer.parseInt(spinner_1.getValue().toString());
        dia = Integer.parseInt(spinner.getValue().toString());
        quarto = Integer.parseInt(spinner_3.getValue().toString());
        int horas = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minutos = Calendar.getInstance().get(Calendar.MINUTE);
        int segundos = Calendar.getInstance().get(Calendar.SECOND);
        cliente.setEntrada(new GregorianCalendar(ano, --mes, dia, horas, minutos, segundos));
        cliente.setQuarto(quarto);

    }

    public void alterarCliente_saida() {
        ano = Integer.parseInt(spinner_2.getValue().toString());
        mes = Integer.parseInt(spinner_1.getValue().toString());
        dia = Integer.parseInt(spinner.getValue().toString());
        cliente.setSaida(new GregorianCalendar(ano, --mes, dia, 12, 0, 0));

    }

    public String getEstadia() {
        LocalDate l1 = LocalDate.of(cliente.getEntrada().get(Calendar.YEAR),
                cliente.getEntrada().get(Calendar.MONTH) + 1, cliente.getEntrada().get(Calendar.DAY_OF_MONTH));
        LocalDate l2 = LocalDate.of(cliente.getSaida().get(Calendar.YEAR), cliente.getSaida().get(Calendar.MONTH) + 1,
                cliente.getSaida().get(Calendar.DAY_OF_MONTH));
        long days = l1.datesUntil(l2).count();
        return NumberFormat.getCurrencyInstance().format(days * 80).toString();
    }

}
