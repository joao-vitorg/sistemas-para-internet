package tiposGeometricos.entities;

public class Vetor<T> {
    private final T[] vet;
    private int tam;

    public Vetor(int tam) {
        this.tam = tam;
        vet = (T[]) new Object[tam];
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public T getVet(int n) {
        return vet[n];
    }

    public void setVet(int n, T data) {
        vet[n] = data;
    }
}
