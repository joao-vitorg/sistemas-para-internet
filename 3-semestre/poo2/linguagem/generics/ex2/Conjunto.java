package generics.ex2;

import java.util.ArrayList;
import java.util.List;

public class Conjunto<T> {
    private final List<T> conjunto = new ArrayList<>();

    void adicionar(T elemento) {
        conjunto.add(elemento);
    }

    void remover(T elemento) {
        conjunto.remove(elemento);
    }

    boolean contem(T elemento) {
        return conjunto.contains(elemento);
    }
}
