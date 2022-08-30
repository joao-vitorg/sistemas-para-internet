package entities;

public class Pessoa<T, U> {
    private String nome;
    private T cpf;
    private U rg;

    public Pessoa(String nome, T cpf, U rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public T getCpf() {
        return cpf;
    }

    public void setCpf(T cpf) {
        this.cpf = cpf;
    }

    public U getRg() {
        return rg;
    }

    public void setRg(U rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", rg=" + rg +
                '}';
    }
}
