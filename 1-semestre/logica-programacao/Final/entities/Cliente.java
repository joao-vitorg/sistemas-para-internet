package Final.entities;

public record Cliente(String nome, String telefone, int tipo, int minutos) {
    public static final double[][] precos = new double[3][2];

    public double ValorDaConta() {
        double base = precos[tipo][0];
        if (minutos <= 90) return base;

        return base + precos[tipo][1] * (minutos - 90);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, Tipo %d, Minutos: %d, Conta = R$ %.2f", nome, telefone, tipo, minutos, ValorDaConta());
    }
}
