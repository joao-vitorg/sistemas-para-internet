package solid.introducao.banco;

import java.time.Instant;

public record Transacao(Instant data, double valor, double saldo) {
    public Transacao(double valor, double saldo) {
        this(Instant.now(), valor, saldo);
    }
}
