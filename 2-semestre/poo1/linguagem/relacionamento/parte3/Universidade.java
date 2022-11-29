package relacionamento.parte3;

public class Universidade {
    private String nome;
    private Departamento departamento;

    public Universidade() {
        this.departamento = new Departamento();
    }

    public Universidade(String nome, Departamento departamento) {
        this.nome = nome;
        this.departamento = departamento;
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

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return nome;
    }
}
