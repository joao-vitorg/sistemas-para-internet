package abstrato.ex1;

public class Professor extends Pessoa {
    private String formacao;

    public Professor(String nome, String formacao) {
        super(nome);
        this.formacao = formacao;
    }

    @Override
    public void apresentar() {
        System.out.println("Eu sou " + getNome() + ", Formado em " + formacao);
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
}
