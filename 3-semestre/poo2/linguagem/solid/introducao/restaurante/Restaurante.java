package solid.introducao.restaurante;

import java.util.*;

public class Restaurante {
    private final Set<Item> menu = new HashSet<>();
    private final List<Pedido> pedidos = new ArrayList<>();
    private String nome;
    private String endereco;

    public Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void adicionarMenu(Item item) {
        menu.add(item);
    }

    public void removerMenu(Item item) {
        menu.remove(item);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public double totalPedido() {
        return pedidos.stream().mapToDouble(Pedido::valorTotal).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Set<Item> getMenu() {
        return Collections.unmodifiableSet(menu);
    }

    public List<Pedido> getPedidos() {
        return Collections.unmodifiableList(pedidos);
    }

    @Override
    public String toString() {
        return menu.toString();
    }
}
