package abstrato.exercicios.ex8;

public class Servidor extends Computador {
    @Override
    public void iniciar() {
        System.out.println("Servidor Demorou 50s para iniciar");
    }
}
