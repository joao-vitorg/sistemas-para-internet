package generics.ex1;

public class Main {
    public static void main(String[] args) {
        PilhaLimitada<Integer> integerPilha = new PilhaLimitada<>();

        integerPilha.empilhar(1);
        integerPilha.empilhar(2);
        integerPilha.empilhar(3);

        System.out.println(integerPilha.tamanho());

        integerPilha.desempilhar();

        System.out.println(integerPilha.tamanho());

        System.out.println(integerPilha.estaVazia());
    }
}
