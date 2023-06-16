package solid.isp;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Promocao implements Reajuste, ImpostoRenda {
    private final BigDecimal valor;
    private final LocalDate data;
    private final BigDecimal valorImpostoDeRenda;

    public Promocao(BigDecimal valor, LocalDate data, BigDecimal valorImpostoDeRenda) {
        this.valor = valor;
        this.data = LocalDate.now();
        this.valorImpostoDeRenda = valorImpostoDeRenda;
    }

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public LocalDate data() {
        return data;
    }

    @Override
    public BigDecimal valorImpostoDeRenda() {
        return valorImpostoDeRenda;
    }
}
