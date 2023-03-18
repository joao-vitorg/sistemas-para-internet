package heranca.exercicios.ex2;

public class Amigo extends Pessoa {
    private String diaDoAniversario;

    public Amigo() {
    }

    public Amigo(String nome, char sexo, int idade, String diaDoAniversario) {
        super(nome, sexo, idade);
        this.diaDoAniversario = diaDoAniversario;
    }

    public String getDiaDoAniversario() {
        return diaDoAniversario;
    }

    public void setDiaDoAniversario(String diaDoAniversario) {
        this.diaDoAniversario = diaDoAniversario;
    }
}
