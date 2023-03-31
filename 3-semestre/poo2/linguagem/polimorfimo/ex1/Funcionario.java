package polimorfimo.ex1;

public class Funcionario extends Pessoa {
    private String funcao;

    public Funcionario(String nome, String formacao) {
        super(nome);
        this.funcao = formacao;
    }

    @Override
    public void apresentar() {
        super.apresentar();
        System.out.println("A minha função é " + funcao);
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
