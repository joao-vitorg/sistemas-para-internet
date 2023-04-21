package abstrato.exercicios.ex5;

public class Eletronico extends Produto {
    public Eletronico(double preco) {
        super(preco);
    }

    @Override
    public double calcularDesconto() {
        return getPreco() * 0.3;
    }
}
