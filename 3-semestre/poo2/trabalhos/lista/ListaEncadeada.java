package lista;

public interface ListaEncadeada<T> {
    void adicionar(T valor);

    T remover();

    void imprimirLista();
}
