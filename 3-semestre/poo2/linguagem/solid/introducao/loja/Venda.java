package solid.introducao.loja;

import java.time.Instant;
import java.util.List;

public record Venda(Instant data, List<Produto> produtos) {
    public Venda(List<Produto> produtos) {
        this(Instant.now(), produtos);
    }

    public double total() {
        return produtos.stream().mapToDouble(Produto::preco).sum();
    }
}
