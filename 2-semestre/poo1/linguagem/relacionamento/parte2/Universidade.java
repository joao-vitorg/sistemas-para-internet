package relacionamento.parte2;

public class Universidade {
    private String nome;
    private Departamento departamento;

    public Universidade() {
    }

    public Universidade(String nome, String departamentoNome) {
        this.nome = nome;
        this.departamento = new Departamento(departamentoNome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String nome) {
        this.departamento = new Departamento(nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
