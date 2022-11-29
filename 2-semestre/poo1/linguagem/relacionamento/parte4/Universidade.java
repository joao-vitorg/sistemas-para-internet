package relacionamento.parte4;

import java.util.ArrayList;

public class Universidade {
    private final ArrayList<Departamento> departamentos = new ArrayList<>();
    private String nome;

    public Universidade() {
    }

    public Universidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamentos.add(departamento);
        departamento.setFiliada(this);
    }

    @Override
    public String toString() {
        return nome;
    }
}
