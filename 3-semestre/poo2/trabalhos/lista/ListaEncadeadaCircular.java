package lista;

public class ListaEncadeadaCircular<T> implements ListaEncadeada<T> {
    private No<T> inicio;
    private No<T> fim;

    @Override
    public void adicionar(T valor) {
        No<T> novoNo = new No<>(valor);

        if (fim == null) {
            fim = novoNo;
        }

        novoNo.setProximo(inicio);
        fim.setProximo(novoNo);
        inicio = novoNo;
    }

    @Override
    public T remover() {
        No<T> noRemovido = inicio;
        inicio = noRemovido.getProximo();
        fim.setProximo(inicio);
        return noRemovido.getValor();
    }


    @Override
    public void imprimirLista() {
        if (inicio == null) {
            System.out.println("Lista vazia");
            return;
        }

        No<T> atual = inicio;
        do {
            System.out.print(atual.getValor() + " ");
            atual = atual.getProximo();
        } while (atual != inicio);
        System.out.println();
    }
}
