package generics.ex2;

public class Main {
    public static void main(String[] args) {
        Conjunto<Integer> integerConjunto = new Conjunto<>();

        integerConjunto.adicionar(1);
        integerConjunto.adicionar(2);
        integerConjunto.adicionar(3);

        System.out.println(integerConjunto.contem(3));

        integerConjunto.remover(3);

        System.out.println(integerConjunto.contem(3));
    }
}
