package generics.ex4;

public class Main {
    public static void main(String[] args) {
        Mapa<String, Integer> stringIntegerMapa = new Mapa<>();

        stringIntegerMapa.adicionar("joao", 19);
        stringIntegerMapa.adicionar("pedro", 18);
        stringIntegerMapa.adicionar("Maria", 20);

        System.out.println(stringIntegerMapa.obter("joao"));

        stringIntegerMapa.remover("joao");

        System.out.println(stringIntegerMapa.obter("joao"));
    }
}
