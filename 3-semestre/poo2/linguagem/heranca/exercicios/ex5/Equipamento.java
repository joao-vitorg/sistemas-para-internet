package heranca.exercicios.ex5;

public class Equipamento {
    private boolean ligado;

    public Equipamento(boolean ligado) {
        this.ligado = ligado;
    }

    public void liga() {
        ligado = true;
    }

    public void desliga() {
        ligado = false;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
}
