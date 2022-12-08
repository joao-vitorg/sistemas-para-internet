package prova2_joaoSouza_q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Transacao {
    private final List<Movimento> movimentos;

    public Transacao() {
        movimentos = new ArrayList<>();
    }

    public boolean realizarTransacao(Date data, Conta conta, String historico, float valor, int operacao) {
        Movimento movimento = new Movimento(data, conta, historico, valor, operacao);
        if (movimento.movimentar()) return movimentos.add(movimento);
        else return false;
    }

    public void estornarTransacao() {
        Collections.fill(movimentos, null);
    }

    public List<Movimento> getMovimentos() {
        return movimentos;
    }
}
