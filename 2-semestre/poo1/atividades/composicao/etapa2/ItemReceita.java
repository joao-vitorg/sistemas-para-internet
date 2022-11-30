package composicao.etapa2;

public class ItemReceita {
    private double dose;
    private int duracao;

    public ItemReceita() {
    }

    public ItemReceita(double dose, int duracao) {
        this.dose = dose;
        this.duracao = duracao;
    }

    public double getDose() {
        return dose;
    }

    public void setDose(double dose) {
        this.dose = dose;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "ItemReceita{" + "dose=" + dose + ", duracao=" + duracao + '}';
    }
}
