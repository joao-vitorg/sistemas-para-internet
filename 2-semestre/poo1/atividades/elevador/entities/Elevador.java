package elevador.entities;

public class Elevador {
    private int totalAndares;
    private int capacidadeElevador;
    private int andarAtual;
    private int pessoasElevador;

    public Elevador(int totalAndares, int capacidadeElevador) {
        andarAtual = pessoasElevador = 0;
        this.totalAndares = totalAndares;
        this.capacidadeElevador = capacidadeElevador;
    }

    public boolean entrar() {
        if (pessoasElevador == capacidadeElevador) return false;
        pessoasElevador++;
        return true;
    }

    public boolean sair() {
        if (pessoasElevador == 0) return false;
        pessoasElevador--;
        return true;
    }

    public boolean subir() {
        if (andarAtual == totalAndares) return false;
        andarAtual++;
        return true;
    }

    public boolean descer() {
        if (andarAtual == 0) return false;
        andarAtual--;
        return true;
    }

    public String exibir() {
        return String.format("""
                Total de Andares = %d
                Capacidade do Elevador = %d
                Lotação do Elevador = %d
                Andar atual do Elevador = %d""", totalAndares, capacidadeElevador, pessoasElevador, andarAtual);
    }

    public int getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(int totalAndares) {
        this.totalAndares = totalAndares;
    }

    public int getCapacidadeElevador() {
        return capacidadeElevador;
    }

    public void setCapacidadeElevador(int capacidadeElevador) {
        this.capacidadeElevador = capacidadeElevador;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getPessoasElevador() {
        return pessoasElevador;
    }

    public void setPessoasElevador(int pessoasElevador) {
        this.pessoasElevador = pessoasElevador;
    }
}
