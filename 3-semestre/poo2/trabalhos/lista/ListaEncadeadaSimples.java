package lista;

public class ListaEncadeadaSimples<T> implements ListaEncadeada<T> {
    private No<T> inicio;

    @Override
    public void adicionar(T valor) {
        No<T> novoNo = new No<>(valor);
        novoNo.setProximo(inicio);
        inicio = novoNo;
    }

    @Override
    public T remover() {
        No<T> noRemovido = inicio;
        inicio = noRemovido.getProximo();
        return noRemovido.getValor();
    }

    @Override
    public void imprimirLista() {
        if (inicio == null) {
            System.out.println("Lista vazia");
            return;
        }

        No<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.getValor() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
