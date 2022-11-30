package composicao.etapa2;

public class Remedio {
    private String nome, laboratorio, unidade;

    public Remedio() {
    }

    public Remedio(String nome, String laboratorio, String unidade) {
        this.nome = nome;
        this.laboratorio = laboratorio;
        setUnidade(unidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        if (!(unidade.length() == 2)) throw new IllegalArgumentException();
        this.unidade = unidade;
    }

    @Override
    public String toString() {
        return "Remedio{" +
                "nome='" + nome + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", unidade='" + unidade + '\'' +
                '}';
    }
}
