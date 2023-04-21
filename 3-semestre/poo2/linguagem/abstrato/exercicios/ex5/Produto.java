package abstrato.exercicios.ex5;

public abstract class Produto {
    private double preco;

    public Produto(double preco) {
        this.preco = preco;
    }

    public abstract double calcularDesconto();

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
