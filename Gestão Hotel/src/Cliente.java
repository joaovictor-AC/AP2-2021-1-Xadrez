public class Cliente {

    private String email;
    private String senha;
    private String nome;
    private int idade;
    private String endereco;
    private String cpf;
    private String telefone;

    public Cliente(String email, String senha, String nome, int idade, String endereco, String cpf, String telefone) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.telefone = telefone;
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

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", email=" + email + ", endereco=" + endereco + ", idade=" + idade + ", nome="
                + nome + ", senha=" + senha + ", telefone=" + telefone + "]";
    }

    

}
