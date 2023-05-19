package solid.introducao.restaurante;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Restaurante sorveteria = new Restaurante("Sorveteria popular", "Av. Rondon Pacheco 76");

        Item baunilha = new Item("Sorvete de baunilha", 3.5);
        Item chocolate = new Item("Sorvete de chocolate", 3);
        Item morango = new Item("Sorvete de morango", 2.9);

        sorveteria.adicionarMenu(baunilha);
        sorveteria.adicionarMenu(chocolate);
        sorveteria.adicionarMenu(morango);
        System.out.println(sorveteria);

        sorveteria.adicionarPedido(new Pedido(List.of(baunilha)));
        sorveteria.adicionarPedido(new Pedido(List.of(baunilha)));
        sorveteria.adicionarPedido(new Pedido(List.of(chocolate, morango)));
        sorveteria.adicionarPedido(new Pedido(List.of(morango)));
        System.out.println(sorveteria.getPedidos());

        sorveteria.removerPedido(sorveteria.getPedidos().get(0));

        System.out.println(sorveteria.totalPedido());
    }
}
