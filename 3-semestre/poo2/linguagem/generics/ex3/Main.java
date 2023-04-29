package generics.ex3;

public class Main {
    public static void main(String[] args) {
        Fila<Integer> integerFila = new Fila<>();

        integerFila.enfileirar(1);
        integerFila.enfileirar(2);
        integerFila.enfileirar(3);

        System.out.println(integerFila.tamanho());

        integerFila.desenfileirar();

        System.out.println(integerFila.tamanho());
    }
}
