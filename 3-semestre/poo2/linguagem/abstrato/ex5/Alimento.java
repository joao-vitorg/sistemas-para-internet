package abstrato.ex5;

public class Alimento extends Produto {
    public Alimento(double preco) {
        super(preco);
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * 0.1;
    }
}
