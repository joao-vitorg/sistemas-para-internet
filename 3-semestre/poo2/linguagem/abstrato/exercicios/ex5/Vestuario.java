package abstrato.exercicios.ex5;

public class Vestuario extends Produto {
    public Vestuario(double preco) {
        super(preco);
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * 0.2;
    }
}
