package prova2_joaoSouza_q1;

public class Restricoes extends Exception {
    public Restricoes(String message) {
        super("Erro: " + message + "!!!");
    }
}
