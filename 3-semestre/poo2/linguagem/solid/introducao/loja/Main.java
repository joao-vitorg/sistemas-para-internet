package solid.introducao.loja;

public class Main {
    public static void main(String[] args) {
        Produto mesa = new Produto("Mesa", 300);
        Produto cadeira = new Produto("Cadeira", 200);
        Produto vaso = new Produto("Vaso", 50);

        LojaVirtual moveisECia = new LojaVirtual("Moveis e CIA", "Av. Liberdade 45");

        moveisECia.adicionarCatalogo(mesa);
        moveisECia.adicionarCatalogo(cadeira);
        moveisECia.adicionarCatalogo(vaso);
        System.out.println(moveisECia);

        Cliente joao = new Cliente("João", "Av. 123", moveisECia);

        joao.adicionarCarrinho(cadeira);
        System.out.println(joao);

        joao.comprar();

        System.out.println(moveisECia.getVendas());
        System.out.println(moveisECia.total());
    }
}
