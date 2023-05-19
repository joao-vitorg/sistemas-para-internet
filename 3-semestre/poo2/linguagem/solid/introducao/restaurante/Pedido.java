package solid.introducao.restaurante;

import java.time.Instant;
import java.util.List;

public record Pedido(Instant data, List<Item> items) {
    public Pedido(List<Item> items) {
        this(Instant.now(), items);
    }

    public double valorTotal() {
        return items.stream().mapToDouble(Item::preco).sum();
    }
}
