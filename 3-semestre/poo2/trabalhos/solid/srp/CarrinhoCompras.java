package solid.srp;

import java.util.HashMap;

public class CarrinhoCompras {
    private final HashMap<Produto, Integer> carrinho = new HashMap<>();

    public void addItem(Produto produto, Integer quantidade) {
        carrinho.put(produto, quantidade);
    }

    public void removeItem(Produto produto) {
        carrinho.remove(produto);
    }

    public double calcularPrecoTotal() {
        return carrinho.entrySet().stream().mapToDouble(value -> value.getKey().getPreco() * value.getValue()).sum();
    }

    public HashMap<Produto, Integer> getCarrinho() {
        return carrinho;
    }
}
