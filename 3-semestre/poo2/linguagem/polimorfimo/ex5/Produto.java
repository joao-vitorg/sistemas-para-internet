package polimorfimo.ex5;

public class Produto {
    private double preco;

    public Produto(double preco) {
        this.preco = preco;
    }

    public double calcularDesconto() {
        return 0;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
