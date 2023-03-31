package polimorfimo.ex8;

public class Servidor extends Computador {
    @Override
    public void iniciar() {
        super.iniciar();
        System.out.println("Demorou 50s");
    }
}
