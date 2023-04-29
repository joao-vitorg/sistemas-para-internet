package generics.ex5;

public class Main {
    public static void main(String[] args) {
        ConjuntoOrdenado<Integer> integerConjuntoOrdenado = new ConjuntoOrdenado<>();

        integerConjuntoOrdenado.adicionar(2);
        integerConjuntoOrdenado.adicionar(5);
        integerConjuntoOrdenado.adicionar(1);

        System.out.println(integerConjuntoOrdenado.obter(0));

        integerConjuntoOrdenado.remover(1);

        System.out.println(integerConjuntoOrdenado.obter(0));
    }
}
