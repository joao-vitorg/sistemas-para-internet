package polimorfimo.ex5;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Eletronico(1000);
        Produto produto2 = new Vestuario(100);
        Produto produto3 = new Alimento(10);

        System.out.println(produto1.calcularDesconto());
        System.out.println(produto2.calcularDesconto());
        System.out.println(produto3.calcularDesconto());
    }
}
