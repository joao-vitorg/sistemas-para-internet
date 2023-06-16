package solid.lcp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>(List.of(
                new ProdutoBoletoBancario("Ração", 112),
                new ProdutoCartaoCredito("Arranhador", 79),
                new ProdutoTransferenciaBancaria("Gato de raça", 500)
        ));

        produtos.forEach(produto -> {
            System.out.println(produto.getDescricao());
            System.out.println(produto.getPreco());
            System.out.println(produto.formaPagamento());
            System.out.println();
        });
    }
}
