package abstrato.exercicios.ex8;

public class Notebook extends Computador {
    @Override
    public void iniciar() {
        System.out.println("Notebook Demorou 10s para iniciar");
    }
}
