package solid.ocp;

public class DescontoPercentual extends Desconto {
    @Override
    double calcularDesconto(double preco) {
        return preco * 0.9;
    }
}
