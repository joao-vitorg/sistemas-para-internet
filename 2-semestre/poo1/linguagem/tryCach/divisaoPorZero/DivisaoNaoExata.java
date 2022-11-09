package tryCach.divisaoPorZero;

public class DivisaoNaoExata extends Exception {
    public DivisaoNaoExata(int num, int den) {
        super("Resultado de "+ num + "/" + den + " não é inteiro");
    }
}
