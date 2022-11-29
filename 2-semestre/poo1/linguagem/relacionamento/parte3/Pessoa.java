package relacionamento.parte3;

public class Pessoa {
    private String nome;
    private Universidade universidade;
    private Departamento departamento;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Universidade universidade, Departamento departamento) {
        this.nome = nome;
        this.universidade = universidade;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
        departamento = universidade.getDepartamento();
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", universidade=" + universidade +
                ", departamento=" + departamento +
                '}';
    }
}
