package solid.ocp;

public class Main {
    public static void main(String[] args) {
        Produto arroz = new Produto("Arroz", 28);
        DescontoPercentual descontoPercentual = new DescontoPercentual();
        CalculadoraDesconto.aplicarDesconto(arroz, descontoPercentual);
        System.out.println(arroz.getPreco());

        Produto picanha = new Produto("Picanha", 55);
        DescontoFixo descontoFixo = new DescontoFixo();
        CalculadoraDesconto.aplicarDesconto(picanha, descontoFixo);
        System.out.println(picanha.getPreco());
    }
}
