package relacionamento.parte4;

public class Departamento {
    private String nome;
    private Universidade filiada;

    public Departamento() {
    }

    public Departamento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Universidade getFiliada() {
        return filiada;
    }

    public void setFiliada(Universidade filiada) {
        this.filiada = filiada;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nome='" + nome + '\'' +
                ", filiada=" + filiada +
                '}';
    }
}
