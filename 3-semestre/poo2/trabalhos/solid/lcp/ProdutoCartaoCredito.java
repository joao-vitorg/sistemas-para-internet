package solid.lcp;

public class ProdutoCartaoCredito extends Produto {
    public ProdutoCartaoCredito(String descricao, double preco) {
        super(descricao, preco);
    }

    @Override
    public String formaPagamento() {
        return "Cartão Credito";
    }
}
