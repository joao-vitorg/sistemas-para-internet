package revisao.ex8;

public class ContaCorrente {
    private String nome;
    private String senha;
    private double saldo;

    public ContaCorrente(String nome, String senha, double saldo) {
        this.nome = nome;
        this.senha = senha;
        this.saldo = saldo;
    }

    public void cadastrarSenha(String senha) {
        this.senha = senha;
    }

    public void alterarSenha(String senhaAntiga, String senhaNova) {
        if (senhaAntiga.equals(senha)) senha = senhaNova;
    }

    public void credito(String senha, int valor) {
        if (senha.equals(this.senha)) saldo += valor;
    }

    public void debito(String senha, int valor) {
        if (senha.equals(this.senha)) saldo -= valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }
}
