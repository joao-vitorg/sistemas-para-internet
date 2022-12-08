package prova2_joaoSouza_q1;

public class Conta {
    public final static int SACAR = 0;
    public final static int DEPOSITAR = 1;
    private int numero;
    private Cliente correntista;
    private float saldo;

    public Conta() {
    }

    public Conta(int numero, Cliente correntista, float saldo) {
        this.numero = numero;
        this.correntista = correntista;
        this.saldo = saldo;
    }

    public void depositar(float valor) {
        this.saldo += valor;
    }

    public boolean sacar(float valor) throws Restricoes {
        if (this.saldo < valor) throw new Restricoes("Saldo insuficiente");
        this.saldo -= valor;
        return true;
    }

    public boolean movimentar(float valor, int operacao) {
        try {
            if (operacao == SACAR) sacar(valor);
            else if (operacao == DEPOSITAR) depositar(valor);
        } catch (Restricoes e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Cliente correntista) {
        this.correntista = correntista;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
