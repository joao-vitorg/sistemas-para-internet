package solid.srp;

public class Pagamento {
    private final CarrinhoCompras carrinhoCompras;
    private boolean pago;

    public Pagamento(CarrinhoCompras carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }

    public void processaPagemento() {
        pago = true;
    }

    public boolean isPago() {
        return pago;
    }

    public CarrinhoCompras getCarrinhoCompras() {
        return carrinhoCompras;
    }
}
