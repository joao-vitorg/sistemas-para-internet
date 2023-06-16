package solid.ocp;

public class DescontoFixo extends Desconto {
    @Override
    double calcularDesconto(double preco) {
        return preco - 10;
    }
}
