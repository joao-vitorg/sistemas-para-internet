package generics.ex3;

import java.util.LinkedList;
import java.util.Queue;

public class Fila<T> {
    private final Queue<T> fila = new LinkedList<>();

    void enfileirar(T elemento) {
        fila.add(elemento);
    }

    void desenfileirar() {
        fila.remove();
    }

    int tamanho() {
        return fila.size();
    }
}
