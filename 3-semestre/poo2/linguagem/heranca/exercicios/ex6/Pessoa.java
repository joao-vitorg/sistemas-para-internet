package heranca.exercicios.ex6;

public class Pessoa extends Animal {
    String nome;

    public Pessoa(String nome) {
        super();
        this.nome = nome;
    }

    @Override
    public void emitirSom() {
        System.out.printf("Ola! eu sou %s\n", nome);
    }
}
