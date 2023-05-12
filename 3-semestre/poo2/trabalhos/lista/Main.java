package lista;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> listaSimples = new ListaEncadeadaSimples<>();
        ListaEncadeada<String> listaCircular = new ListaEncadeadaCircular<>();

        // Lista simples
        listaSimples.adicionar(10);
        listaSimples.adicionar(20);
        listaSimples.adicionar(30);
        listaSimples.imprimirLista();

        listaSimples.remover();
        listaSimples.imprimirLista();

        System.out.println();

        // Lista circular
        listaCircular.adicionar("A");
        listaCircular.adicionar("B");
        listaCircular.adicionar("C");
        listaCircular.imprimirLista();

        listaCircular.remover();
        listaCircular.imprimirLista();
    }
}
