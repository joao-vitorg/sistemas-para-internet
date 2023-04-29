package generics.ex5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConjuntoOrdenado<T extends Comparable<T>> {
    private final List<T> conjunto = new ArrayList<>();

    void adicionar(T elemento) {
        conjunto.add(elemento);
        Collections.sort(conjunto);
    }

    void remover(T elemento) {
        conjunto.remove(elemento);
    }

    T obter(int indice) {
        return conjunto.get(indice);
    }
}
