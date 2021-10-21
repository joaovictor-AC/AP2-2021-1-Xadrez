import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente {

    private String email;
    private String senha;
    private String nome;
    private int idade;
    private String endereco;
    private String cpf;
    private String telefone;
    private int quarto;
    private Calendar entrada;
    private Calendar saida;

    public Cliente(String email, String senha, String nome, int idade, String endereco, String cpf, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
        this.entrada = new GregorianCalendar(0, 0, 0);
        this.saida = new GregorianCalendar(0, 0, 0);
        this.quarto = 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getQuarto() {
        return quarto;
    }

    public void setQuarto(int quarto) {
        this.quarto = quarto;
    }

    public Calendar getEntrada() {
        return entrada;
    }

    public void setEntrada(Calendar entrada) {
        this.entrada = entrada;
    }

    public Calendar getSaida() {
        return saida;
    }

    public void setSaida(Calendar saida) {
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nIdade: " + this.idade + "\nTelefone: " + this.telefone + "\nCPF: " + this.cpf
                + "\nEndereço: " + this.endereco + "\nQuarto: Quarto " + this.quarto + "\nEmail: " + this.email
                + "\nEntrada: " + this.entrada.getTime() + "\nSaída: " + this.saida.getTime();
    }

}
