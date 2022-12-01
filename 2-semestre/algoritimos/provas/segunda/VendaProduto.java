import java.util.Scanner;

class VendaProduto {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String nome = s.nextLine();
        String data = s.nextLine();

        Venda venda = new Venda(nome, data);

        while (true) {
            String nomeProduto = s.nextLine();
            if (nomeProduto.equals("fim")) break;

            double preco = s.nextDouble();
            int quantidade = s.nextInt();
            s.nextLine();

            venda.getProdutos().add(new Produto(nomeProduto, preco, quantidade));
        }

        System.out.printf("%s - %s - R$ %.2f\n", venda.getData(), venda.getCliente(), venda.calcularTotal());
    }
}