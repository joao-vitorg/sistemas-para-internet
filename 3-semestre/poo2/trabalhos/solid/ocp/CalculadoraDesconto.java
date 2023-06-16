package solid.ocp;

public class CalculadoraDesconto {
    public static double aplicarDesconto(Produto produto, Desconto desconto) {
        double valor = desconto.calcularDesconto(produto.getPreco());
        produto.setPreco(valor);
        return valor;
    }
}
