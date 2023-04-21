package abstrato.exercicios.ex1;

public abstract class Pessoa {
    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public abstract void apresentar();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
