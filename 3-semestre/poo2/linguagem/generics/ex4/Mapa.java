package generics.ex4;

import java.util.HashMap;

public class Mapa<K, V> {
    final HashMap<K, V> mapa = new HashMap<>();

    void adicionar(K chave, V valor) {
        mapa.put(chave, valor);
    }

    void remover(K chave) {
        mapa.remove(chave);
    }

    V obter(K chave) {
        return mapa.get(chave);
    }
}
