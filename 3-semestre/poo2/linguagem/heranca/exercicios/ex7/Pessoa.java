package heranca.exercicios.ex7;

public class Pessoa {
    public Pessoa() {
    }

    public void comprimentar() {
        System.out.println("Ola! como vai?");
    }

    public void comprimentar(String nome) {
        System.out.printf("Ola! %s, como vai?", nome);
    }
}
