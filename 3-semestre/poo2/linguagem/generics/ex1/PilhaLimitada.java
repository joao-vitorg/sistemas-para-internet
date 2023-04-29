package generics.ex1;

import java.util.Stack;

public class PilhaLimitada<T> {
    private final Stack<T> pilha = new Stack<>();

    void empilhar(T elemento) {
        pilha.push(elemento);
    }

    void desempilhar() {
        pilha.pop();
    }

    boolean estaVazia() {
        return pilha.empty();
    }

    int tamanho() {
        return pilha.size();
    }
}
