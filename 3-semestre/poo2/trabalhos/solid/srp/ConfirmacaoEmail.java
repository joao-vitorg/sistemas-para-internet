package solid.srp;

public class ConfirmacaoEmail {
    private final Pagamento pagamento;

    public ConfirmacaoEmail(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void enviarEmailConfirmacao() {
        if (pagamento.isPago()) System.out.println("O Boleto foi pago");
    }

    public Pagamento getPagamento() {
        return pagamento;
    }
}
