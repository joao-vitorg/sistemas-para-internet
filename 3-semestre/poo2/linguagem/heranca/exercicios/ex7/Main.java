package heranca.exercicios.ex7;

public class Main {
    public static void main(String[] args) {
        // Sobrecarga é quando um metodo é reescrito porem com
        // parametros diferentes

        // Toda pessoa pode comprimentar outra de forma
        // generica, porem ela tambem pode falar o nome dela

        Pessoa pessoa = new Pessoa();

        pessoa.comprimentar();
        pessoa.comprimentar("João");
    }
}
